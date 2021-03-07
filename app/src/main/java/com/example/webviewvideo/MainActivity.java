package com.example.webviewvideo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.DialogInterface;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    //não esquecer de abrir uses-permission INTERNET no manifest e na aplicação:  android:usesCleartextTraffic="true"

    private WebView webView;
    String url = "https://www.ludopedia.com.br/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        getSupportActionBar().hide();

        webView = findViewById(R.id.webView);

        //para não abrir nova aba no seu navegador
        webView.setWebViewClient(new WebViewClient());

        //permissão para usar js
        webView.getSettings().setJavaScriptEnabled(true);

        //armazenamnto de dados no disco p/ melhor performance
        webView.getSettings().setDomStorageEnabled(true);

        webView.loadUrl(url);
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        } else {
            spamSair();
        }
    }

    public void spamSair(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
//        dialog.setTitle("Sair?");
        dialog.setMessage("Deseja sair da aplicação?");
        dialog.setCancelable(false);

        dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        dialog.setNegativeButton("Não", null);

        dialog.create();
        dialog.show();
    }
}