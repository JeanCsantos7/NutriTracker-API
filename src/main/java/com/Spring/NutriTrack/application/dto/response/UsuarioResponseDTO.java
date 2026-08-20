package com.Spring.NutriTrack.application.dto.response;

import com.Spring.NutriTrack.domain.enums.Objetivo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class UsuarioResponseDTO {

    private String nome;
    private Double altura;
    private Double pesoAtual;
    private Objetivo objetivo;
    private LocalDate dataCadastro;
}
