package com.Spring.NutriTrack.infrastructure.repository;

import com.Spring.NutriTrack.domain.model.ExercicioRealizado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExercicioRealizadoRepository extends JpaRepository<ExercicioRealizado, Long> {
}
