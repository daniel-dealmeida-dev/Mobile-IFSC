package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AdaptePlaneta extends ArrayAdapter<Planeta> {
    Context lcontext;

    public AdaptePlaneta(@NonNull Context context, int resource, @NonNull List<Planeta> objects) {
        super(context, resource, objects);
        lcontext=context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //inflar layout-> processar o xml
        LayoutInflater inflater = LayoutInflater.from(lcontext);
        View view = inflater.inflate(R.layout.item, parent, false);

        ImageView imageView = view.findViewById(R.id.imageView2);
        TextView tvNome = view.findViewById(R.id.textView2);

        Planeta p = getItem(position);

        tvNome.setText(p.nome);
        imageView.setImageResource(p.foto); // Adiciona a foto do planeta

        return view;
    }}