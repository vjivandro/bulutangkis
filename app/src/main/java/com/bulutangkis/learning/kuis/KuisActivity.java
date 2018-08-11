package com.bulutangkis.learning.kuis;

import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bulutangkis.learning.R;
import com.bulutangkis.learning.dbhelper.DatabaseHelper;
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
    private int detik = 300000;  // 1 menit = 1000 s
    private Button btnPrev, btnNext, btnSelesai;
    int jawabanYgDiPilih[] = null;
    int jawabanYgBenar[] = null;
    boolean cekPertanyaan = false;
    int urutanPertanyaan = 0;
    String noSalah = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis);

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
        btnPrev = (Button) findViewById(R.id.buttonPrev);
        btnNext = (Button) findViewById(R.id.buttonNext);
        btnSelesai = (Button) findViewById(R.id.buttonSelesai);

        final Calendar c = Calendar.getInstance();
        int day = c.get(Calendar.DAY_OF_MONTH);
        int month = c.get(Calendar.MONTH);
        int year = c.get(Calendar.YEAR);
        txttanggal.setText(Integer.toString(day)+"-"+Integer.toString(month+1)+"-"+Integer.toString(year));

        listKuis = new ArrayList<KuisModel>();
        listKuis = db.getKuis();

        btnSelesai.setOnClickListener(this);
        btnPrev.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        //new getSoalWasit().execute();
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
                    Toast.makeText(getBaseContext(), "Isi dulu", Toast.LENGTH_LONG).show();
                }else{
                    txtnama.setText(inputUser.getText().toString());
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
        btnSelesai.setEnabled(false);
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
            String jwb_a = kuisModel.getPil_a();
            String jwb_b = kuisModel.getPil_b();
            String jwb_c = kuisModel.getPil_c();
            String jwb_d = kuisModel.getPil_d();

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
                btnNext.setEnabled(false);
                btnSelesai.setEnabled(true);
            }

            if (urutan_soal_soal == 0)
                btnPrev.setEnabled(false);

            if (urutan_soal_soal > 0)
                btnPrev.setEnabled(true);

            if (urutan_soal_soal < (listKuis.size() - 1))
                btnNext.setEnabled(true);

        } catch (Exception e) {
            Log.e(this.getClass().toString(), e.getMessage(), e.getCause());
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.buttonPrev:
                actionPrev();
                break;
            case R.id.buttonNext:
                actionNext();
                break;
            case R.id.buttonSelesai:
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
        AlertDialog tampilKotakAlert;
        tampilKotakAlert = new AlertDialog.Builder(KuisActivity.this).create();
        tampilKotakAlert.setTitle("Hasil");
        int hasil = jumlahJawabanYgBenar * (100/ jawabanYgDiPilih.length); // menampilkan Hasil
        tampilKotakAlert.setMessage("Benar :" +jumlahJawabanYgBenar +"\n"+ "Dari Soal :"
                + (listKuis.size()+ "\n" + "Nilai Anda : "+hasil));



        tampilKotakAlert.setButton(AlertDialog.BUTTON_NEGATIVE, "Keluar",
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        cekPertanyaan = false;
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
            AlertDialog tampilKotakAlert;
            tampilKotakAlert = new AlertDialog.Builder(KuisActivity.this).create();
            tampilKotakAlert.setTitle("Nilai");
            tampilKotakAlert.setMessage("Benar " +jumlahJawabanYgBenar + " dari "
                    + (listKuis.size() +" soal. "+noSalah));

            tampilKotakAlert.setButton(AlertDialog.BUTTON_NEUTRAL, "Lagi",
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

            tampilKotakAlert.setButton(AlertDialog.BUTTON_NEGATIVE, "Keluar",
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

}
