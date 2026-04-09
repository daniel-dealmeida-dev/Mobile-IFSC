package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etPeso, etAltura;
    Button btnCalcular;
    TextView tvResultado;
    ImageView imgMostra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPeso = findViewById(R.id.etPeso);
        etAltura = findViewById(R.id.etAltura);
        btnCalcular = findViewById(R.id.btnCalcular);
        tvResultado = findViewById(R.id.tvResultado);
        imgMostra = findViewById(R.id.imageView);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String pesoStr = etPeso.getText().toString();
                String alturaStr = etAltura.getText().toString();

                if (pesoStr.isEmpty() || alturaStr.isEmpty()) {
                    tvResultado.setText("Preencha todos os campos!");
                    return;
                }

                double peso = Double.parseDouble(pesoStr);
                double altura = Double.parseDouble(alturaStr);

                double imc = peso / (altura * altura);

                String classificacao;

                if (imc < 18.5) {
                    classificacao = "Abaixo do peso";
                    imgMostra.setImageResource(R.drawable.abaixopeso);
                } else if (imc < 25) {
                    classificacao = "Peso normal";
                    imgMostra.setImageResource(R.drawable.normal);
                } else if (imc < 30) {
                    classificacao = "Sobrepeso";
                    imgMostra.setImageResource(R.drawable.sobrepeso);
                } else {
                    classificacao = "Obesidade";
                    imgMostra.setImageResource(R.drawable.obesidade3);
                }

                tvResultado.setText(String.format("IMC: %.2f\n%s", imc, classificacao));
            }
        });
    }
}