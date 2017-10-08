package com.example.usuario.ejerciciosintroduccion;

import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Ejercicio4Activity extends AppCompatActivity implements View.OnClickListener{

    EditText texto;
    TextView respuesta;
    Button comprobar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio4);

        texto=(EditText)findViewById(R.id.edtTexto);
        respuesta=(TextView)findViewById(R.id.txvRespuesta);
        comprobar=(Button)findViewById(R.id.btnComprobar);
        comprobar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        try
        {
            String palabraComprobar = texto.getText().toString().replaceAll("\\s","").toLowerCase();
            if (palabraComprobar.equals(""))
            {
                throw new Exception();
            }
            if (EsPalindromo(palabraComprobar))
            {
                respuesta.setText("Es palindromo!");
            }
            else
            {
                respuesta.setText("NO Es palindromo!");
            }
        }
        catch (Exception e)
        {
            Toast.makeText(this,"Introduce una PALABRA correcta",Toast.LENGTH_SHORT).show();
        }


    }


    static boolean EsPalindromo(String s)
    {
        String palabra=s;
        int ini = 0;
        int fin = palabra.length()-1;
        boolean bError = false;

        while ((ini<fin) && (!bError)){

            if (palabra.charAt(ini)==palabra.charAt(fin)){
                ini++;
                fin--;
            } else {
                bError = true;
            }
        }
        if (!bError)
            return  true;
        else
            return  false;
    }
}