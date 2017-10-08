package com.example.usuario.ejerciciosintroduccion;

import android.app.AlertDialog;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Ejercicio3Activity extends AppCompatActivity implements View.OnClickListener {

    TextView txvContador, txvTiempo;
    Button restar, sumar, comenzar, reiniciar;
    CountDownTimer contador;
    int segundos, minutos, cafes;
    boolean maximoCafes;
    AlertDialog.Builder popup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio3);

        txvContador=(TextView)findViewById(R.id.txvContador);
        txvTiempo=(TextView)findViewById(R.id.txvTiempo);
        restar=(Button) findViewById(R.id.btnRestar);
        sumar=(Button) findViewById(R.id.btnSumar);
        comenzar=(Button) findViewById(R.id.btnComenzar);
        reiniciar=(Button)findViewById(R.id.btnReiniciar);
        restar.setOnClickListener(this);
        sumar.setOnClickListener(this);
        comenzar.setOnClickListener(this);
        reiniciar.setOnClickListener(this);

        segundos=0;
        minutos=0;
        cafes=0;

        maximoCafes=false;
        reiniciar.setEnabled(false);
        comenzar.setEnabled(false);
        popup=new AlertDialog.Builder(this);
    }

    @Override
    public void onClick(View view) {
        if (view==restar)
        {
            if ((minutos + segundos != 0)) {
                comenzar.setEnabled(true);
                if (segundos != 0) {
                    segundos = 0;
                } else {
                    segundos = 30;
                    minutos--;
                }
                txvTiempo.setText(String.format("%02d", minutos) + " : " + String.format("%02d", segundos));
            }

        }
        if (view==sumar)
        {
            comenzar.setEnabled(true);
            if (segundos >= 30) {
                segundos = 60;
            } else {
                segundos = 30;
            }
            if (segundos >= 60) {
                segundos = 0;
                minutos++;
            }
            txvTiempo.setText(String.format("%02d", minutos) + " : " + String.format("%02d", segundos));

        }
        if (view==comenzar)
        {
            sumar.setEnabled(false);
            restar.setEnabled(false);
            comenzar.setEnabled(false);
            contador = new CountDownTimer(((minutos * 60) + segundos) * 1000, 1000) {
                @Override
                public void onTick(long l)
                {
                    if (segundos <= 0) {
                        segundos = 59;
                        minutos--;
                    } else {
                        segundos--;
                    }
                    txvTiempo.setText(String.format("%02d", minutos) + " : " + String.format("%02d", segundos));
                }

                @Override
                public void onFinish()
                {
                    sumar.setEnabled(true);
                    restar.setEnabled(true);
                    segundos = 0;
                    txvTiempo.setText(String.format("%02d", minutos) + " : " + String.format("%02d", segundos));
                    cafes++;
                    txvContador.setText(String.valueOf(cafes));
                    if (cafes==10)
                    {
                        comenzar.setEnabled(false);
                        restar.setEnabled(false);
                        sumar.setEnabled(false);
                        reiniciar.setEnabled(true);


                        popup.setTitle("Mensaje Importante");
                        popup.setMessage("Has bebido demasiados cafés por hoy");
                        popup.setPositiveButton("Ok", null);
                        popup.show();
                    }
                }
            };
            contador.start();

        }
        if (view==reiniciar)
        {
            cafes=0;
            txvContador.setText(String.valueOf(cafes));
            comenzar.setEnabled(true);
            restar.setEnabled(true);
            sumar.setEnabled(true);
            reiniciar.setEnabled(false);
        }

    }
}