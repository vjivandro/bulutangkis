package com.bulutangkis.learning.kuis;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bulutangkis.learning.R;

public class PrepareKuisActivity extends AppCompatActivity implements View.OnClickListener {
    private SharedPreferences sharedPreferences;
    private Button mulai;
    private TextView history_tv, nama_tv;

    String nama, nilaiakhir, indekakhir, index;
    int hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prepare_kuis);
        sharedPreferences = getSharedPreferences("my_shared_preferences", Context.MODE_PRIVATE);

        mulai = (Button) findViewById(R.id.btn_siap);
        history_tv = (TextView) findViewById(R.id.nilai_terakhir);
        nama_tv = (TextView) findViewById(R.id.tv_nama);

        nilaiakhir = sharedPreferences.getString("nilai", "");
        indekakhir = sharedPreferences.getString("index", "");
        nama = sharedPreferences.getString("nama", "");

        nama_tv.setText(nama);

        if (hasil <= 39) {
            index = "E";
            history_tv.setTextColor(Color.RED);
        } else if (hasil <= 54) {
            index = "D";
            history_tv.setTextColor(Color.RED);
        } else if (hasil <= 59){
            index = "C";
            history_tv.setTextColor(Color.rgb(255,99,71));
        } else if (hasil <= 64) {
            index = "C+";
            history_tv.setTextColor(Color.rgb(255,99,71));
        } else if (hasil <= 69) {
            index = "B-";
            history_tv.setTextColor(Color.rgb(255,99,71));
        } else if (hasil <= 74) {
            index = "B";
            history_tv.setTextColor(Color.rgb(255,99,71));
        } else if (hasil <= 79) {
            index = "B+";
            history_tv.setTextColor(Color.GREEN);
        } else if (hasil <= 84) {
            index = "A-";
            history_tv.setTextColor(Color.GREEN);
        } else {
            index = "A";
            history_tv.setTextColor(Color.GREEN);
        }

        if (nilaiakhir.isEmpty() && indekakhir.isEmpty()) {
            history_tv.setText("");
        } else {
            history_tv.setText(nilaiakhir + " ( " + indekakhir + " ) " );
        }

        mulai.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        startActivity(new Intent(this, KuisActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.refresh_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        // aksi logout dan mengembalikan ke login page
        if (id == R.id.action_refresh) {
            refreshing();
        }

        return super.onOptionsItemSelected(item);
    }

    private void refreshing() {
        nilaiakhir = sharedPreferences.getString("nilai", "");
        indekakhir = sharedPreferences.getString("index", "");
        nama = sharedPreferences.getString("nama", "");

        history_tv.setText(nilaiakhir + " ( " + indekakhir + " ) " );
    }
}
