package com.bulutangkis.learning.about;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.bulutangkis.learning.R;

public class InformasiActivity extends AppCompatActivity {

    TextView versionTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informasi);

        versionTv = (TextView) findViewById(R.id.tv_versi);

        //versi
        String versionName = "";
        int versionCode = -1;
        try {
            PackageInfo packageInfo = this.getPackageManager().
                    getPackageInfo(this.getPackageName(), 0);
            versionName = packageInfo.versionName;
            versionCode = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();

        }

        versionTv.setText("Versi : "+String.format(versionName));

    }
}
