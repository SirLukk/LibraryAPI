package com.library.libraryAPI.utils.mappers;

import com.library.libraryAPI.adapters.outbound.persistance.LivroEntity;
import com.library.libraryAPI.domain.livro.Livro;
import java.util.UUID;

public class LivroMapper {

    public static LivroEntity toEntity(Livro livro) {
        LivroEntity entity = new LivroEntity();

        if (livro.getId() != null)
            entity.setId(UUID.fromString(livro.getId()));

        entity.setTitulo(livro.getTitulo());
        entity.setAutor(livro.getAutor());
        entity.setAno(livro.getAno());
        entity.setGenero(livro.getGenero());
        return entity;
    }

    public static Livro toDomain(LivroEntity entity) {
        return new Livro(
                entity.getId().toString(),
                entity.getTitulo(),
                entity.getAutor(),
                entity.getAno(),
                entity.getGenero()
        );
    }
}
