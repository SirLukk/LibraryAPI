package com.library.libraryAPI.adapters.inbound.controller;


import com.library.libraryAPI.application.ports.in.LivroService;
import com.library.libraryAPI.domain.livro.Livro;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation. *;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/api/v1")
@RestController
@Tag(name = "Gerenciamento de Livros", description = "Sistema para gerenciar livros de uma biblioteca.")
public class LivroController {

    private final LivroService service;

    public LivroController(LivroService service) {
        this.service = service;
    }


    @GetMapping
    @Operation(summary = "Listar todos os Livros:")
    public ResponseEntity<List<Livro>> listaLivros() {
        List<Livro> livros = service.listaLivros();
        return ResponseEntity.ok(livros);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar livro por id:")
    public ResponseEntity<Livro> buscaLivro(@PathVariable String id) {

        Optional<Livro> livro = service.buscaLivro(id);
        return livro
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Registra livro:")
    public ResponseEntity<Livro> registraLivro(@RequestBody Livro livro) {

        livro.setId(null);
        Livro livroRegistrado = service.registraLivro(livro);
        return ResponseEntity.ok(livroRegistrado);

    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar livro:")
    public ResponseEntity<Livro> atualizaLivro(@PathVariable String id, @RequestBody Livro livro) {

        Optional<Livro> livroAtualizado = service.atualizaLivro(id, livro);
        return livroAtualizado
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar livro:")
    public ResponseEntity<Void> deletaLivro(@PathVariable String id) {
        boolean deletou = service.deletaLivro(id);
        if (deletou) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscar/autor")
    @Operation(summary = "Busca por Autor:")
    public ResponseEntity<List<Livro>> buscaAutor(@RequestParam String autor) {

        List<Livro> autorBuscado = service.buscaAutor(autor);
        return ResponseEntity.ok(autorBuscado);

    }

    @GetMapping("/buscar/titulo")
    @Operation(summary = "Buscar por Titulo:")
    public ResponseEntity<Livro> buscaTitulo(@RequestParam String titulo) {

        Optional<Livro> tituloBuscado = service.buscaTitulo(titulo);
        return tituloBuscado
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }
}
