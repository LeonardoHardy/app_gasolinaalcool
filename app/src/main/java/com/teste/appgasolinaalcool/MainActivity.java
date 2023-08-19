package com.teste.appgasolinaalcool;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText precoAlcool;
    private TextInputEditText precoGasolina;
    private TextView resultadoPreco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        precoAlcool = findViewById(R.id.precoAlcool);
        precoGasolina = findViewById(R.id.precoGasolina);
        resultadoPreco = findViewById(R.id.resultadoPreco);
    }

    public void melhorPreco(View view) {
        //Recuperar valores digitados nós campos alcool e gasolina

        String alcool = precoAlcool.getText().toString();
        String gasolina = precoGasolina.getText().toString();

        //Validação logica com converção de String para Double

        Boolean camposValidacao = validacaoCampos(alcool, gasolina);
        if (camposValidacao){
            Double valorAlcool = Double.parseDouble(alcool);
            Double valorGasolina = Double.parseDouble(gasolina);
        if (valorAlcool / valorGasolina >= 0.7){
            resultadoPreco.setText("Gasolina é melhor");
        } else {
            resultadoPreco.setText("Alcool é melhor");
        }
        }else {
            resultadoPreco.setText("Preencha os campos acima");
        }
    }

    //Metodo para validar campos obrigatorios
    public Boolean validacaoCampos(String validarAlcool, String validarGasolina) {
        Boolean camposValidacao = true;
        if (validarAlcool == null || validarAlcool.equals("")) {
            camposValidacao = false;
        } else if (validarGasolina == null || validarGasolina.equals("")) {
            camposValidacao = false;
        }
        return camposValidacao;
    }

}