package com.library.libraryAPI.adapters.outbound.repositories;

import com.library.libraryAPI.adapters.outbound.persistance.LivroEntity;
import com.library.libraryAPI.adapters.outbound.repositories.LivroRepository;
import com.library.libraryAPI.application.ports.out.LivroRepositoryPort;
import com.library.libraryAPI.domain.livro.Livro;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
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
    public Optional<Livro> findById(Long id) {
        return repository.findById(id)
                .map(this::toDomain);
    }

    @Override
    public Livro save(Livro livro) {
        LivroEntity entity = toEntity(livro);
        return toDomain(repository.save(entity));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public Optional<Livro> findByAutor(String autor) {
        return repository.findByAutorContainingIgnoreCase(autor)
                .stream()
                .findFirst()
                .map(this::toDomain);
    }

    @Override
    public Optional<Livro> findByTitulo(String titulo) {
        return repository.findByTituloContainingIgnoreCase(titulo)
                .stream()
                .findFirst()
                .map(this::toDomain);
    }

    // Conversão de Entity para Domain
    private Livro toDomain(LivroEntity entity) {
        return new Livro(
                entity.getId(),
                entity.getTitulo(),
                entity.getAutor(),
                entity.getAno(),
                entity.getGenero()
        );
    }

    // Conversão de Domain para Entity
    private LivroEntity toEntity(Livro livro) {
        LivroEntity entity = new LivroEntity();
        entity.setId(livro.getId());
        entity.setTitulo(livro.getTitulo());
        entity.setAutor(livro.getAutor());
        entity.setAno(livro.getAno());
        entity.setGenero(livro.getGenero());
        return entity;
    }
}