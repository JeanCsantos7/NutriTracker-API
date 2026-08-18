package com.Spring.NutriTrack.domain.model;

import com.Spring.NutriTrack.domain.enums.StatusMeta;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Meta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private Long usuarioId;

    private Double pesoMeta;

    private Double caloriasDiarias;

    private Double proteinasDiarias;

    private LocalDate dataInicio;

    private LocalDate dataFim;

    @Enumerated(EnumType.STRING)
    private StatusMeta status;
}
