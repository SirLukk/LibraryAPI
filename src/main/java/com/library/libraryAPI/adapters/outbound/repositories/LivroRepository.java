package com.library.libraryAPI.adapters.outbound.repositories;

import com.library.libraryAPI.domain.livro.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {

        List<Livro> findByid(Long id);

}
