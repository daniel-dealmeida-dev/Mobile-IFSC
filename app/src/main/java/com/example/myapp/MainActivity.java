package com.example.myapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import java.util.Random;

public class MainActivity extends AppCompatActivity {
Button bntAvancar, bntVoltar;

ImageView imageView;

Integer imagens[] = new Integer[]{
        R.drawable.cachorro,
        R.drawable.cachorro,
        R.drawable.patinho,
        R.drawable.gardem,
        R.drawable.happy,
        R.drawable.porquinho
    };
    int posicao=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        bntVoltar = findViewById(R.id.button);
        bntAvancar = findViewById(R.id.buttonAvancar);
        imageView = findViewById(R.id.imageView);

        bntAvancar.setOnClickListener(v -> {
        imageView.setImageResource(imagens[posicao]);
    });

    }



}