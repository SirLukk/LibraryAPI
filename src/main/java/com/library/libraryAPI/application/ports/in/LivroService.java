package com.library.libraryAPI.application.ports.in;


import com.library.libraryAPI.domain.livro.Livro;

import java.util.List;
import java.util.Optional;

public interface LivroService {

    List<Livro> listaLivros();
    Optional<Livro> buscaLivro(Long id);
    Livro registraLivro(Livro livro);
    Optional<Livro> atualizaLivro(Long id, Livro livro);
    boolean deletaLivro(Long id);
    List<Livro> buscaAutor(String autor);
    Optional<Livro> buscaTitulo(String titulo);

}


