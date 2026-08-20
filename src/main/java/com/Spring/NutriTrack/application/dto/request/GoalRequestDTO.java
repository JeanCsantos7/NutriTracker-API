package com.Spring.NutriTrack.application.dto.request;

import com.Spring.NutriTrack.domain.enums.StatusMeta;

import java.time.LocalDate;

public record GoalRequestDTO(

        Long usuarioId,
        Double pesoMeta,
        Double caloriasDiarias,
        Double proteinasDiarias,
        LocalDate dataInicio,
        LocalDate dataFim,
        StatusMeta status
) {
}
