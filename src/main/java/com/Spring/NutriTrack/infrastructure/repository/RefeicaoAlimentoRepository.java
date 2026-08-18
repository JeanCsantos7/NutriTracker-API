package com.Spring.NutriTrack.infrastructure.repository;


import com.Spring.NutriTrack.domain.model.RefeicaoAlimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefeicaoAlimentoRepository extends JpaRepository<RefeicaoAlimento, Long> {
}
