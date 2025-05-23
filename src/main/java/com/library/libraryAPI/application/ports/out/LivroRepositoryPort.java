package com.library.libraryAPI.application.ports.out;


import com.library.libraryAPI.domain.livro.Livro;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LivroRepositoryPort {

    List<Livro> findAll();
    Optional<Livro> findById(String id);
    Livro save(Livro livro);
    void deleteById(String id);
    boolean existsById(String id);
    List<Livro> findByAutor(String autor);
    Optional<Livro> findByTitulo(String titulo);
}
