package com.Spring.NutriTrack.infrastructure.repository;

import com.Spring.NutriTrack.domain.model.Treino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreinoRepository extends JpaRepository<Treino, Long> {
}
