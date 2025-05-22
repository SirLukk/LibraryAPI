package com.library.libraryAPI.adapters.inbound.controller;


import com.library.libraryAPI.domain.livro.Livro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation. *;
import java.util.List;
import java.util.Optional;

@RequestMapping("/api/v1")
@RestController
public class LivroController {

    private final LivroService service;

    @GetMapping
    public ResponseEntity <List<Livro>>listaLivros(){
        List<Livro> livros = service.listaLivros();
        return ResponseEntity.ok(livros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscaLivro(@PathVariable Long id){

        Optional<Livro> livro = service.buscaLivro(id);
        return livro
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @PostMapping
    public ResponseEntity<Livro> registraLivro(@RequestBody Livro livro){

        Livro livroRegistrado = service.registraLivro(livro);
        return ResponseEntity.ok(livroRegistrado);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizaLivro(@PathVariable Long id, @RequestBody Livro livro){

        Optional<Livro> livroAtualizado = service.AtulizaLivro(id, livro);
        return livroAtualizado
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletaLivro(@PathVariable Long id) {
        boolean deletou = service.deletaLivro(id);
        if (deletou) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
