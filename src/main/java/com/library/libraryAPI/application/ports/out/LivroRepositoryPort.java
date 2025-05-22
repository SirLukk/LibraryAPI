package com.library.libraryAPI.application.ports.out;


import com.library.libraryAPI.domain.livro.Livro;

import java.util.List;
import java.util.Optional;

public interface LivroRepositoryPort {

    List<Livro> findAll();
    Optional<Livro> findById(Long id);
    Livro save(Livro livro);
    void deleteById(Long id);
    boolean existsById(Long id);
}
