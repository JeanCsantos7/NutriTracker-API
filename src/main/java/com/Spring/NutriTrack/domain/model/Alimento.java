package com.Spring.NutriTrack.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Alimento {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String nome;

    private Integer calorias;

    private Integer proteinas;

    private Integer carboidratos;

    private Integer gorduras;

    }



