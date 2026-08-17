package com.Spring.NutriTrack.infrastructure.repository;

import com.Spring.NutriTrack.domain.model.ExercicioRealizado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExercicioRealizadoRepository extends JpaRepository<Long, ExercicioRealizado> {
}
