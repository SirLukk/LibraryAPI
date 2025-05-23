package com.library.libraryAPI.adapters.outbound.repositories;



import com.library.libraryAPI.adapters.outbound.persistance.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LivroRepository extends JpaRepository<LivroEntity, UUID> {

        List<LivroEntity> findByAutorContainingIgnoreCase(String autor);

        List<LivroEntity> findByTituloContainingIgnoreCase(String titulo);

        boolean existsByTitulo(String titulo);
}




