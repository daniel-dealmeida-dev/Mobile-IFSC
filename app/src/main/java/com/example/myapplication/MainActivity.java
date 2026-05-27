package com.example.meuapp;

import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button b;
    TextView tv;
    EditText edmin, edmax;

    @RequiresApi(api = Build.VERSION_CODES.VANILLA_ICE_CREAM)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = findViewById(R.id.button);
        tv = findViewById(R.id.tv);
        edmin = findViewById(R.id.edMin);
        edmax = findViewById(R.id.edMax);


        b.setOnClickListener(v -> {
            // int min= Integer.parseInt(edmin.getText().toString());
            // int max= Integer.parseInt(edmax.getText().toString());
            String minStr = edmin.getText().toString();
            String maxStr = edmax.getText().toString();
            if (minStr.isEmpty()){
                edmin.setError("Informe uma valor mínimo");
                return;
            }
            if (maxStr.isEmpty()) {
                edmax.setError("Informe um valor máximo");
                return;
            }

            int min=Integer.parseInt(minStr);
            int max=Integer.parseInt(maxStr);


            Random random= new Random();
            int r = random.nextInt(min, max);
            tv.setText(Integer.toString(r));

        });

    }
}