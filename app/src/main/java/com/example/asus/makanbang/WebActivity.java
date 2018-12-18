package com.example.asus.makanbang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {

    //mendeklarasikan variable global dengan tipe akses Private
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        webView = (WebView) findViewById(R.id.web_view);
        webView.setWebViewClient(new CustomWebViewClient());

        WebSettings webSetting = webView.getSettings();
        webSetting.setJavaScriptEnabled(true);

        //menyaring variable yang dikirim dan menyocokkannya
        if ("Ayam Bakar".equals(getIntent().getStringExtra("ayambakar_key"))) {
            webView.loadUrl("http://www.bankmandiri.co.id/article/875447371254.asp");
        } else if ("Bakso".equals(getIntent().getStringExtra("bakso_key"))) {
            webView.loadUrl("https://cookpad.com/id/resep/2664196-bakso-urat-homemade");
        } else if ("Nasi Goreng".equals(getIntent().getStringExtra("nasgor_key"))) {
            webView.loadUrl("https://cookpad.com/id/resep/2651286-nasi-goreng-praktis");
        } else if ("Nasi Gudeg".equals(getIntent().getStringExtra("nasigudeg_key"))) {
            webView.loadUrl("https://cookpad.com/id/resep/1994424-nasi-gudeg-ala-bunda-jk");
        } else if ("Rendang".equals(getIntent().getStringExtra("rendang_key"))) {
            webView.loadUrl("https://cookpad.com/id/resep/2699753-rendang");
        }

    }

    private class CustomWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}