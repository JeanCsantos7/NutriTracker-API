package com.Spring.NutriTrack.application.dto.request;

import com.Spring.NutriTrack.domain.enums.Objetivo;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;

public record UsuarioRequestDTO(
        String nome,
        String email,
        String senhaHash,
        LocalDate dataNascimento,
        Double altura,
        Double pesoAtual,
        Objetivo objetivo,
        LocalDate dataCadastro


) {
}
