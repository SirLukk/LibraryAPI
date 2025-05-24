package com.library.libraryAPI.application.service;

import com.library.libraryAPI.application.ports.out.LivroRepositoryPort;
import com.library.libraryAPI.domain.livro.Livro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LivroServiceImplTest {

    @Mock
    private LivroRepositoryPort repository;

    @InjectMocks
    private LivroServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveListarTodosOsLivros() {
        List<Livro> livros = List.of(
                new Livro("1", "Livro A", "Autor A", 2020, "Ficção"),
                new Livro("2", "Livro B", "Autor B", 2021, "Aventura")
        );
        when(repository.findAll()).thenReturn(livros);

        List<Livro> resultado = service.listaLivros();

        assertEquals(2, resultado.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void deveBuscarLivroPorId() {
        Livro livro = new Livro("1", "Livro A", "Autor A", 2020, "Ficção");
        when(repository.findById("1")).thenReturn(Optional.of(livro));

        Optional<Livro> resultado = service.buscaLivro("1");

        assertTrue(resultado.isPresent());
        assertEquals("Livro A", resultado.get().getTitulo());
        verify(repository).findById("1");
    }

    @Test
    void deveRegistrarNovoLivroComIdNulo() {
        Livro livroInput = new Livro("qualquer", "Novo Livro", "Novo Autor", 2023, "Terror");
        Livro livroSalvo = new Livro("generated-id", "Novo Livro", "Novo Autor", 2023, "Terror");

        when(repository.save(any(Livro.class))).thenReturn(livroSalvo);

        Livro resultado = service.registraLivro(livroInput);

        assertNotNull(resultado.getId());
        assertEquals("Novo Livro", resultado.getTitulo());
        verify(repository).save(argThat(l -> l.getId() == null));
    }

    @Test
    void deveAtualizarLivroExistente() {
        Livro original = new Livro("1", "Antigo", "Autor", 2020, "Drama");
        Livro atualizacao = new Livro("1", "Novo", "Novo Autor", 2024, "Ação");

        when(repository.findById("1")).thenReturn(Optional.of(original));
        when(repository.save(any())).thenReturn(atualizacao);

        Optional<Livro> resultado = service.atualizaLivro("1", atualizacao);

        assertTrue(resultado.isPresent());
        assertEquals("Novo", resultado.get().getTitulo());
        verify(repository).save(any());
    }

    @Test
    void deveDeletarLivroQuandoExistente() {
        when(repository.existsById("1")).thenReturn(true);

        boolean resultado = service.deletaLivro("1");

        assertTrue(resultado);
        verify(repository).deleteById("1");
    }

    @Test
    void naoDeveDeletarLivroInexistente() {
        when(repository.existsById("999")).thenReturn(false);

        boolean resultado = service.deletaLivro("999");

        assertFalse(resultado);
        verify(repository, never()).deleteById(any());
    }

    @Test
    void deveBuscarLivrosPorAutor() {
        List<Livro> livros = List.of(new Livro("1", "Livro A", "Autor A", 2020, "Romance"));
        when(repository.findByAutor("Autor A")).thenReturn(livros);

        List<Livro> resultado = service.buscaAutor("Autor A");

        assertEquals(1, resultado.size());
        assertEquals("Livro A", resultado.get(0).getTitulo());
    }

    @Test
    void deveBuscarLivroPorTitulo() {
        Livro livro = new Livro("1", "O Segredo", "Autor X", 2019, "Mistério");
        when(repository.findByTitulo("O Segredo")).thenReturn(Optional.of(livro));

        Optional<Livro> resultado = service.buscaTitulo("O Segredo");

        assertTrue(resultado.isPresent());
        assertEquals("O Segredo", resultado.get().getTitulo());
    }
}
