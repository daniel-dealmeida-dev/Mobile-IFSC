package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ListView lv = findViewById(R.id.listview);

        sqLiteDatabase = openOrCreateDatabase("notas", MODE_PRIVATE, null);

        sqLiteDatabase.execSQL(
                "CREATE TABLE IF NOT EXISTS notas (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "titulo TEXT," +
                        "nota TEXT)"
        );

        // Inserir dados
        ContentValues contentValues = new ContentValues();
        contentValues.put("titulo", "joão");
        contentValues.put("nota", "7777777777");

        sqLiteDatabase.insert("notas", null, contentValues);

        // Recuperar dados
        Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM notas", null);

        ArrayList<com.example.meuapp.Nota> listaNotas = new ArrayList<>();

        if (c.moveToFirst()) {

            do {
                @SuppressLint("Range")
                int id = c.getInt(c.getColumnIndex("id"));

                @SuppressLint("Range")
                String titulo = c.getString(c.getColumnIndex("titulo"));

                @SuppressLint("Range")
                String nota = c.getString(c.getColumnIndex("nota"));

                com.example.meuapp.Nota n = new com.example.meuapp.Nota(id, titulo, nota);

                listaNotas.add(n);

                Log.d("SELECT", id + "," + titulo + "," + nota);

            } while (c.moveToNext());
        }

        c.close();

        ArrayList<String> listaTitulos = new ArrayList<>();

        for (com.example.meuapp.Nota nota : listaNotas) {
            listaTitulos.add(nota.getTitulo());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                listaTitulos
        );


        lv.setAdapter(adapter);
    }
}