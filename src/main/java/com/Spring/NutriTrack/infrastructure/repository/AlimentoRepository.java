package com.Spring.NutriTrack.infrastructure.repository;

import com.Spring.NutriTrack.domain.model.Alimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlimentoRepository extends JpaRepository<Alimento, Long> {
}