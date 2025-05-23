package com.library.libraryAPI.adapters.outbound.persistance;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import jakarta.persistence.Entity;

import java.util.UUID;

@Data
@Entity
public class LivroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull
    @Size(min = 1, max = 255)
    private String titulo;

    @NotNull
    private String autor;

    private int ano;

    @NotNull
    private String genero;

}
