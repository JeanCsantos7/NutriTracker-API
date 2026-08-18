package com.Spring.NutriTrack.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RefeicaoAlimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long refeicaoId;

    private Long alimentoId;

    private Double quantidade;
}
