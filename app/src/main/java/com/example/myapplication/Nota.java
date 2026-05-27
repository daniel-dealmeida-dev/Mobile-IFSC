package com.example.meuapp;

public class Nota {

    private Integer id;
    private String titulo;
    private String nota;

    public Nota(Integer id, String titulo, String nota) {
        this.id = id;
        this.titulo = titulo;
        this.nota = nota;
    }

    public Integer getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getNota() {
        return nota;
    }
}