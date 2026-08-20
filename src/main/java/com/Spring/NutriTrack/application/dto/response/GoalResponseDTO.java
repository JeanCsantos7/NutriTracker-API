package com.Spring.NutriTrack.application.dto.response;


import com.Spring.NutriTrack.domain.enums.StatusMeta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GoalResponseDTO {
    private Long usuarioId;
    private Double pesoMeta;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private StatusMeta status;
}
