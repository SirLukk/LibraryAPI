package com.library.libraryAPI.utils.mappers;

import com.library.libraryAPI.adapters.outbound.persistance.LivroEntity;
import com.library.libraryAPI.domain.livro.Livro;

public class LivroMapper {

    public static LivroEntity toEntity(Livro livro) {
        LivroEntity entity = new LivroEntity();
        entity.setId(livro.getId());
        entity.setTitulo(livro.getTitulo());
        entity.setAutor(livro.getAutor());
        entity.setAno(livro.getAno());
        entity.setGenero(livro.getGenero());
        return entity;
    }

    public static Livro toDomain(LivroEntity entity) {
        return new Livro(
                entity.getId(),
                entity.getTitulo(),
                entity.getAutor(),
                entity.getAno(),
                entity.getGenero()
        );
    }
}
