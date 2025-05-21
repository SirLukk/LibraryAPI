package com.library.libraryAPI.adapters.inbound.controller;


import com.library.libraryAPI.adapters.outbound.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1")
@RestController
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping
    public String HelloWorld(){
        return "Hello world!";
    }

}
