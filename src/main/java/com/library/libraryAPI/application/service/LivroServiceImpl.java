package com.library.libraryAPI.application.service;


import com.library.libraryAPI.application.ports.in.LivroService;
import com.library.libraryAPI.application.ports.out.LivroRepositoryPort;
import com.library.libraryAPI.domain.livro.Livro;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class LivroServiceImpl implements LivroService {

    private final LivroRepositoryPort repository;

    public LivroServiceImpl(LivroRepositoryPort repository){

        this.repository = repository;
    }

    @Override
    public List<Livro> listaLivros(){

        return repository.findAll();

    }

    @Override
    public Optional<Livro> buscaLivro(Long id){

        return repository.findById(id);

    }

    @Override
    public Livro registraLivro(Livro livro){

        livro.setId(null);
        return repository.save(livro);

    }

    @Override
    public Optional<Livro> atualizaLivro(Long id, Livro dados) {
        return repository.findById(id).map(existing -> {
            existing.setTitulo(dados.getTitulo());
            existing.setAutor(dados.getAutor());
            existing.setAno(dados.getAno());
            existing.setGenero(dados.getGenero());
            return repository.save(existing);  // ← garante UPDATE, não criação
        });
    }

    @Override
    public boolean deletaLivro(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }

    @Override
    public Optional<Livro> buscaAutor(String autor){

        return repository.findByAutor(autor);
    }

    @Override
    public Optional<Livro> buscaTitulo(String titulo){

        return repository.findByTitulo(titulo);
    }



}
