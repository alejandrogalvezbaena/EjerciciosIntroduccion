package com.example.usuario.ejerciciosintroduccion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Ejercicio1Activity extends AppCompatActivity implements View.OnClickListener{

    Button boton;
    EditText euros, dolares, valorCambio;
    RadioButton radioEuros, radioDolares;
    double cambio=0.852478581;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);

        euros=(EditText) findViewById(R.id.text_euros);
        dolares=(EditText) findViewById((R.id.text_dolares));
        valorCambio=(EditText)findViewById(R.id.edtValorCambio);
        radioEuros=(RadioButton) findViewById(R.id.radio_euros);
        radioDolares=(RadioButton) findViewById((R.id.radio_dolares));
        boton=(Button) findViewById(R.id.boton_convertir);
        boton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        try
        {
            if (view==boton)
                cambio=Double.parseDouble(valorCambio.getText().toString());
                if ((radioEuros.isChecked()) && !(euros.getText().toString().equals("."))) {
                    dolares.setText(convertirADolares(euros.getText().toString()));
                }
                else if(!(dolares.getText().toString().equals("."))){
                    euros.setText(convertirAEuros(dolares.getText().toString()));

                }
        }
        catch (Exception e)
        {
            Toast.makeText(this,"Introduce un valor correcto",Toast.LENGTH_SHORT).show();
        }

    }

    public String convertirADolares(String cantidad) {
        double valor = Double.parseDouble(cantidad) / cambio;
        return Double.toString(Math.round(valor*100d)/100d);
        //return String.valueOf(valor);
    }

    public String convertirAEuros(String cantidad) {
        double valor = Double.parseDouble(cantidad) * cambio;
        //return String.format("%.2f", valor);

        return Double.toString(Math.round(valor*100d)/100d);
    }
}