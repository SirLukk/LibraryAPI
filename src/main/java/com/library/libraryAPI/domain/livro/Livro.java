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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

}
