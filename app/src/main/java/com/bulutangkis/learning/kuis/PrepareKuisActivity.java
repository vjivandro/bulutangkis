package com.bulutangkis.learning.kuis;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bulutangkis.learning.R;

public class PrepareKuisActivity extends AppCompatActivity implements View.OnClickListener {
    private SharedPreferences sharedPreferences;
    private Button mulai;
    private TextView history;

    String nilaiakhir, indekakhir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prepare_kuis);
        sharedPreferences = getSharedPreferences("my_shared_preferences", Context.MODE_PRIVATE);

        mulai = (Button) findViewById(R.id.btn_siap);
        history = (TextView) findViewById(R.id.nilai_terakhir);

        nilaiakhir = sharedPreferences.getString("nilai", "");
        indekakhir = sharedPreferences.getString("index", "");

        history.setText(nilaiakhir + " = " + indekakhir);

        mulai.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this, KuisActivity.class));
    }
}
