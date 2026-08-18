package com.Spring.NutriTrack.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExercicioRealizado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private Integer treinoRealizadoID;

    private Integer exercicioId;

    private Integer seriesRealizadas;

    private Integer repeticoes;

    private Integer carga;


}
