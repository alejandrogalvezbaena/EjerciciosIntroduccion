package com.example.usuario.ejerciciosintroduccion;

import android.content.Intent;
import android.net.Uri;
import android.nfc.FormatException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Ejercicio2Activity extends AppCompatActivity implements View.OnClickListener {

    EditText direccion;
    Button boton;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2);
        direccion=(EditText)findViewById(R.id.edtDireccion);
        boton=(Button)findViewById(R.id.btnIr);
        boton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        try
        {
            String url=direccion.getText().toString();
            String comprobar="";
            String comienzo="http";
            int f;
            for(f=0;f<=3;f++) {
                comprobar+=url.charAt(f);
            }
            if (comprobar.equals(comienzo))
            {
                i=new Intent(this, Ejercicio2Activity_mostrarPagina.class);
                i.putExtra("valor", direccion.getText().toString());
                startActivity(i);
            }
            else
            {
                throw new Exception();
            }
        }
        catch (Exception e)
        {
            Toast.makeText(this,"Introduce una URL correcta",Toast.LENGTH_SHORT).show();
        }


    }
}
