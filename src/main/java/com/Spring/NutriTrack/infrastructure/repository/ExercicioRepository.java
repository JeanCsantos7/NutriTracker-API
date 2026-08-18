package com.Spring.NutriTrack.infrastructure.repository;

import com.Spring.NutriTrack.domain.model.Exercicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExercicioRepository extends JpaRepository<Exercicio, Long> {
}
