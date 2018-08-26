package com.bulutangkis.learning.kuis;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bulutangkis.learning.R;
import com.bulutangkis.learning.helper.DatabaseHelper;
import com.bulutangkis.learning.model.KuisModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class KuisActivity extends AppCompatActivity implements View.OnClickListener {

    private DatabaseHelper db;
    private TextView txtnama, txtno, txttanggal, txtwaktu, txtsoal;
    private RadioGroup radioGroup;
    private RadioButton rb_a, rb_b, rb_c, rb_d;
    private List<KuisModel> listKuis;
    private CounterClass mCountDownTimer;
    private int detik = 5400000;  // 1 menit = 1000 s
    private FloatingActionButton fab_prev, fab_next, fab_done;
    int jawabanYgDiPilih[] = null;
    int jawabanYgBenar[] = null;
    boolean cekPertanyaan = false;
    int urutanPertanyaan = 0;
    private SharedPreferences sharedPreferences;
    private String noSalah = "";
    private String nama, nilai, index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis);
        sharedPreferences = getSharedPreferences("my_shared_preferences", Context.MODE_PRIVATE);

        db = new DatabaseHelper(this);
        txtnama = (TextView) findViewById(R.id.textViewNama);
        txtno = (TextView) findViewById(R.id.textViewHalaman);
        txttanggal = (TextView) findViewById(R.id.textViewTanggal);
        txtwaktu = (TextView) findViewById(R.id.textViewWaktu);
        txtsoal = (TextView) findViewById(R.id.textViewSoal2);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup1);
        rb_a = (RadioButton) findViewById(R.id.radio0);
        rb_b = (RadioButton) findViewById(R.id.radio1);
        rb_c = (RadioButton) findViewById(R.id.radio2);
        rb_d = (RadioButton) findViewById(R.id.radio3);

        fab_prev = findViewById(R.id.fab_prev);
        fab_prev.getRippleColor();
        fab_next = findViewById(R.id.fab_next);
        fab_next.getRippleColor();
        fab_done = findViewById(R.id.fab_done);
        fab_done.getRippleColor();

        fab_prev.setOnClickListener(this);
        fab_next.setOnClickListener(this);
        fab_done.setOnClickListener(this);

        final Calendar c = Calendar.getInstance();
        int day = c.get(Calendar.DAY_OF_MONTH);
        int month = c.get(Calendar.MONTH);
        int year = c.get(Calendar.YEAR);
        txttanggal.setText(Integer.toString(day)+"-"+Integer.toString(month+1)+"-"+Integer.toString(year));

        listKuis = new ArrayList<KuisModel>();
        listKuis = db.getKuis();

        jawabanYgDiPilih = new int[listKuis.size()];
        java.util.Arrays.fill(jawabanYgDiPilih, -2);
        jawabanYgBenar = new int[listKuis.size()];
        java.util.Arrays.fill(jawabanYgBenar, -1);
        showInputUser();
    }

    private void showInputUser() {
        LayoutInflater mInflater = LayoutInflater.from(this);
        View v = mInflater.inflate(R.layout.dialog_nama, null);

        final AlertDialog dialog = new AlertDialog.Builder(this).create();

        dialog.setView(v);
        dialog.setTitle("Ketikkan Nama Anda");
        dialog.setIcon(R.drawable.ic_timer_red);
        dialog.setCancelable(false);

        final Button btnOk = (Button) v.findViewById(R.id.buttonOK);
        final EditText inputUser = (EditText) v.findViewById(R.id.editTextNama);

        btnOk.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                if(inputUser.getText().toString().equals("")){
                    Toast.makeText(getBaseContext(), "Maaf! Nama tidak boleh kosong", Toast.LENGTH_LONG).show();
                }else{
                    txtnama.setText(inputUser.getText().toString());
                    nama = inputUser.getText().toString();
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("nama", nama);
                    editor.commit();
                    startKuis();
                    dialog.dismiss();
                }

            }
        });

        dialog.show();
    }

    private void startKuis() {
        setupWaktu();
        setupSoal();
    }

    private void setupWaktu() {
        mCountDownTimer = new KuisActivity.CounterClass(detik, 1000);
        mCountDownTimer.start();
    }

    private void setupSoal() {
        Collections.shuffle(listKuis);
        this.tunjukanPertanyaan(0, cekPertanyaan);
    }

    private void tunjukanPertanyaan(int urutan_soal_soal, boolean review) {
        fab_done.setEnabled(false);
        try {
            radioGroup.clearCheck();
            KuisModel kuisModel = new KuisModel();
            kuisModel = listKuis.get(urutan_soal_soal);
            String pertanyaan = kuisModel.getSoal();
            if (jawabanYgBenar[urutan_soal_soal] == -1) {
                jawabanYgBenar[urutan_soal_soal] = kuisModel.getJawaban();
            }


            txtsoal.setText(pertanyaan.toCharArray(), 0, pertanyaan.length());
            radioGroup.check(-1);
            String jwb_a = "A. " + kuisModel.getPil_a();
            String jwb_b = "B. " + kuisModel.getPil_b();
            String jwb_c = "C. " + kuisModel.getPil_c();
            String jwb_d = "D. " + kuisModel.getPil_d();

            // mengisis radio button dengan pilihan jawaban
            rb_a.setText(jwb_a.toCharArray(), 0, jwb_a.length());
            rb_b.setText(jwb_b.toCharArray(), 0, jwb_b.length());
            rb_c.setText(jwb_c.toCharArray(), 0, jwb_c.length());
            rb_d.setText(jwb_d.toCharArray(), 0, jwb_d.length());


            Log.d("", jawabanYgDiPilih[urutan_soal_soal] + "");

            if (jawabanYgDiPilih[urutan_soal_soal] == 0)
                radioGroup.check(R.id.radio0);
            if (jawabanYgDiPilih[urutan_soal_soal] == 1)
                radioGroup.check(R.id.radio1);
            if (jawabanYgDiPilih[urutan_soal_soal] == 2)
                radioGroup.check(R.id.radio2);
            if (jawabanYgDiPilih[urutan_soal_soal] == 3)
                radioGroup.check(R.id.radio3);

            pasangLabelDanNomorUrut();

            if (urutan_soal_soal == (listKuis.size() - 1)){
                fab_next.setEnabled(false);
                fab_done.setEnabled(true);
            }

            if (urutan_soal_soal == 0)
                fab_prev.setEnabled(false);

            if (urutan_soal_soal > 0)
                fab_prev.setEnabled(true);

            if (urutan_soal_soal < (listKuis.size() - 1))
                fab_next.setEnabled(true);

        } catch (Exception e) {
            Log.e(this.getClass().toString(), e.getMessage(), e.getCause());
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.fab_prev:
                actionPrev();
                break;
            case R.id.fab_next:
                actionNext();
                break;
            case R.id.fab_done:
                actionDone();
                break;
        }
    }

    private void actionPrev() {
        aturJawaban_nya();
        urutanPertanyaan--;
        if (urutanPertanyaan < 0)
            urutanPertanyaan = 0;

        tunjukanPertanyaan(urutanPertanyaan, cekPertanyaan);
    }

    private void actionNext() {
        aturJawaban_nya();
        urutanPertanyaan++;
        if (urutanPertanyaan >= listKuis.size())
            urutanPertanyaan = listKuis.size() - 1;

        tunjukanPertanyaan(urutanPertanyaan, cekPertanyaan);
    }

    private void actionDone() {
        aturJawaban_nya();
        // hitung berapa yg benar
        int jumlahJawabanYgBenar = 0;
        for (int i = 0; i < jawabanYgBenar.length; i++) {
            if ((jawabanYgBenar[i] != -1) && (jawabanYgBenar[i] == jawabanYgDiPilih[i]))
                jumlahJawabanYgBenar++;
            if(jawabanYgBenar[i] != jawabanYgDiPilih[i])
                noSalah = noSalah+" " + Integer.toString(i+1);
        }
        if(noSalah == ""){
            noSalah = "Benar semua";
        }
        else{
            noSalah = "No yang salah"+noSalah;
        }

        AlertDialog.Builder tampilKotakAlert = new AlertDialog.Builder(KuisActivity.this);
        tampilKotakAlert.setTitle("Hasil");
        int hasil = jumlahJawabanYgBenar * (100/ jawabanYgDiPilih.length); // menampilkan Hasil
        nilai = String.valueOf(hasil);

        if (hasil <= 39) {
            index = "E";
        } else if (hasil <= 54) {
            index = "D";
        } else if (hasil <= 59){
            index = "C";
        } else if (hasil <= 64) {
            index = "C+";
        } else if (hasil <= 69) {
            index = "B-";
        } else if (hasil <= 74) {
            index = "B";
        } else if (hasil <= 79) {
            index = "B+";
        } else if (hasil <= 84) {
            index = "A-";
        } else {
            index = "A";
        }

        tampilKotakAlert.setMessage("Benar :" +jumlahJawabanYgBenar +"\n"+ "Dari Soal :"
                + (listKuis.size()+ "\n" + "Nilai Anda : "+hasil) + "\n" + index);

        tampilKotakAlert.setNegativeButton("Keluar",
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        cekPertanyaan = false;
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("nilai", nilai);
                        editor.putString("index", index);
                        editor.commit();
                        finish();
                    }
                });

        tampilKotakAlert.show();
    }

    private class CounterClass extends CountDownTimer {
        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */
        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            long millis = millisUntilFinished;
            String hms = String.format(
                    "%02d:%02d:%02d",
                    TimeUnit.MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis)
                            - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS
                            .toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis)
                            - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
                            .toMinutes(millis)));
            txtwaktu.setText(hms);  
        }

        @Override
        public void onFinish() {
            aturJawaban_nya();
            // hitung berapa yg benar
            int jumlahJawabanYgBenar = 0;
            for (int i = 0; i < jawabanYgBenar.length; i++) {
                if ((jawabanYgBenar[i] != -1) && (jawabanYgBenar[i] == jawabanYgDiPilih[i]))
                    jumlahJawabanYgBenar++;
                if(jawabanYgBenar[i] != jawabanYgDiPilih[i])
                    noSalah = noSalah+" " + Integer.toString(i+1);
            }
            if(noSalah == ""){
                noSalah = "Benar semua";
            }
            else{
                noSalah = "No yang salah"+noSalah;
            }

            android.app.AlertDialog.Builder tampilKotakAlert = new android.app.AlertDialog.Builder(KuisActivity.this);
            tampilKotakAlert.setTitle("Anda Kehabisan waktu");
            tampilKotakAlert.setIcon(R.drawable.ic_sentiment_very_dissatisfied);
            tampilKotakAlert.setMessage("Benar " +jumlahJawabanYgBenar + " dari "
                    + (listKuis.size() +" soal. "+noSalah));

            tampilKotakAlert.setPositiveButton( "Lagi",
                    new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int which) {
                            cekPertanyaan = false;
                            urutanPertanyaan = 0;
                            noSalah="";
                            Arrays.fill(jawabanYgDiPilih, -2);
                            KuisActivity.this.tunjukanPertanyaan(0,
                                    cekPertanyaan);
                        }
                    });

            tampilKotakAlert.setPositiveButton("Keluar",
                    new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int which) {
                            cekPertanyaan = false;
                            finish();
                        }
                    });

            tampilKotakAlert.show();
        }
    }

    private void aturJawaban_nya() {
        if (rb_a.isChecked())
            jawabanYgDiPilih[urutanPertanyaan] = 0;
        if (rb_b.isChecked())
            jawabanYgDiPilih[urutanPertanyaan] = 1;

        Log.d("", Arrays.toString(jawabanYgDiPilih));
        Log.d("", Arrays.toString(jawabanYgBenar));
    }


    private void pasangLabelDanNomorUrut() {
        txtno.setText("Soal ke " + (urutanPertanyaan + 1) + " dari "
                + listKuis.size());
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Toast.makeText(getApplicationContext(), "Selesaikan test hingga selesai", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            super.onKeyDown(keyCode, event);
            return true;
        }
        return false;
    }
}
