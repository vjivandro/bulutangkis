package com.bulutangkis.learning.about;

import android.content.Context;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.bulutangkis.learning.R;

public class FipWebviewActivity extends AppCompatActivity {

    private String Url_Fip = "https://www.um.ac.id/page/fakultas-ilmu-pendidikan";
    private WebView webView;
    private ConnectivityManager conMgr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        webView = (WebView) findViewById(R.id.webview);

        conMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        if (conMgr.getActiveNetworkInfo() != null
                && conMgr.getActiveNetworkInfo().isAvailable()
                && conMgr.getActiveNetworkInfo().isConnected()) {

            webView.getSettings().setBuiltInZoomControls(true);
            webView.getSettings().setSupportZoom(true);
            webView.getSettings().setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.setWebViewClient(new MyBrowser());
            webView.loadUrl(Url_Fip);

        } else {
            Toast.makeText(this, "Periksa Jaringan anda", Toast.LENGTH_LONG).show();
        }
    }

    public class MyBrowser extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            if (view == null) {
                webView.loadUrl(url);
            }
            return true;
        }
    }
}
