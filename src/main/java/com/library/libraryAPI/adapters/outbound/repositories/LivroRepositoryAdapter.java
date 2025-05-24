package com.library.libraryAPI.adapters.outbound.repositories;

import com.library.libraryAPI.adapters.outbound.persistance.LivroEntity;
import com.library.libraryAPI.adapters.outbound.repositories.LivroRepository;
import com.library.libraryAPI.application.ports.out.LivroRepositoryPort;
import com.library.libraryAPI.domain.livro.Livro;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class LivroRepositoryAdapter implements LivroRepositoryPort {

    private final LivroRepository repository;

    public LivroRepositoryAdapter(LivroRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Livro> findAll() {
        return repository.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Livro> findById(String id) {
        return repository.findById(UUID.fromString(id))
                .map(this::toDomain);
    }

    @Override
    public Livro save(Livro livro) {
        LivroEntity entity = toEntity(livro);
        return toDomain(repository.save(entity));
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(UUID.fromString(id));
    }

    @Override
    public boolean existsById(String id) {
        return repository.existsById(UUID.fromString(id));
    }

    @Override
    public List<Livro> findByAutor(String autor) {
        return repository.findByAutorContainingIgnoreCase(autor)
                .stream()
                .map(this::toDomain)
                .toList();
    }

    @Override
    public Optional<Livro> findByTitulo(String titulo) {
        return repository.findByTituloContainingIgnoreCase(titulo)
                .stream()
                .findFirst()
                .map(this::toDomain);
    }

    private Livro toDomain(LivroEntity entity) {
        return new Livro(
                entity.getId().toString(),
                entity.getTitulo(),
                entity.getAutor(),
                entity.getAno(),
                entity.getGenero()
        );
    }

    private LivroEntity toEntity(Livro livro) {
        LivroEntity entity = new LivroEntity();

        if (livro.getId() != null && !livro.getId().isBlank()) {
            entity.setId(UUID.fromString(livro.getId()));
        }

        entity.setTitulo(livro.getTitulo());
        entity.setAutor(livro.getAutor());
        entity.setAno(livro.getAno());
        entity.setGenero(livro.getGenero());

        return entity;
    }
}