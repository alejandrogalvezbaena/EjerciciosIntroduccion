package com.example.usuario.ejerciciosintroduccion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button eje1, eje2, eje3, eje4;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eje1 =(Button)findViewById(R.id.btnEjercicio1);
        eje1.setOnClickListener(this);
        eje2 =(Button)findViewById(R.id.btnEjercicio2);
        eje2.setOnClickListener(this);
        eje3 =(Button)findViewById(R.id.btnEjercicio3);
        eje3.setOnClickListener(this);
        eje4 =(Button)findViewById(R.id.btnEjercicio4);
        eje4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnEjercicio1:
                i=new Intent(this, Ejercicio1Activity.class);
                break;
            case R.id.btnEjercicio2:
                i=new Intent(this, Ejercicio2Activity.class);
                break;
            case R.id.btnEjercicio3:
                i=new Intent(this, Ejercicio3Activity.class);
                break;
            case R.id.btnEjercicio4:
                i=new Intent(this, Ejercicio4Activity.class);
                break;
        }
        startActivity(i);

    }
}
