package com.Spring.NutriTrack.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FichaDeTreino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Integer treinoId;

    private Integer exercicioId;

    private Integer seriesPrevistas;

    private Integer repeticoesPrevistas;

    private Double cargaPrevista;

    private String observacao;
}
