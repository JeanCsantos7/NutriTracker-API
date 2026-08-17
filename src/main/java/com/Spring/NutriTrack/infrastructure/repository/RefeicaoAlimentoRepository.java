package com.Spring.NutriTrack.infrastructure.repository;


import com.Spring.NutriTrack.domain.model.RefeicaoAlimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefeicaoAlimentoRepository extends JpaRepository<Long, RefeicaoAlimento> {
}
