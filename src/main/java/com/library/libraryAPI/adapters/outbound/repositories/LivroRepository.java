package com.library.libraryAPI.adapters.outbound.repositories;



import com.library.libraryAPI.adapters.outbound.persistance.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<LivroEntity, Long> {

        List<LivroEntity> findByAutorContainingIgnoreCase(String autor);

        List<LivroEntity> findByTituloContainingIgnoreCase(String titulo);

        boolean existsByTitulo(String titulo);
}




