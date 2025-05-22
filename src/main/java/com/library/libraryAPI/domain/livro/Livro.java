package com.library.libraryAPI.domain.livro;


public class Livro {

    private Long id;
    private String titulo;
    private String autor;
    private int ano;
    private String genero;

    public Livro(){

    }

    public Livro(Long id, String titulo, String autor, int ano, String genero){
        this.id = id;
        this.autor = autor;
        this.titulo = titulo;
        this.ano = ano;
        this.genero = genero;
    }
}
