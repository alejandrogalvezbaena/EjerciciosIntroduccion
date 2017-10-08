package com.example.usuario.ejerciciosintroduccion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Ejercicio2Activity_mostrarPagina extends AppCompatActivity {

    WebView vistaWeb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2_mostrar_pagina);

        vistaWeb =(WebView)findViewById(R.id.webVista);
        WebSettings webSettings = vistaWeb.getSettings();
        webSettings.setJavaScriptEnabled(true);
        vistaWeb.setWebViewClient(new WebViewClient());
        Intent i=this.getIntent();
        vistaWeb.loadUrl(i.getStringExtra("valor"));

    }
}
