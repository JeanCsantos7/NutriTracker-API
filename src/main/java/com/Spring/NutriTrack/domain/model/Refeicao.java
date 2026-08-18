package com.Spring.NutriTrack.domain.model;

import com.Spring.NutriTrack.domain.enums.TipoRefeicao;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Refeicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private Long usuarioId;

    private LocalDate data;
    @Enumerated(EnumType.STRING)

    private TipoRefeicao tipo;

}
