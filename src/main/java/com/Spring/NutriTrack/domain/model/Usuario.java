package com.Spring.NutriTrack.domain.model;

import com.Spring.NutriTrack.domain.enums.Objetivo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String senhaHash;
    private LocalDate dataNascimento;
    private Double altura;
    private Double pesoAtual;

    @Enumerated(EnumType.STRING)
    private Objetivo objetivo;
    private LocalDate dataCadastro;
}
