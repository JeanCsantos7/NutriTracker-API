package com.Spring.NutriTrack.infrastructure.repository;

import com.Spring.NutriTrack.domain.model.FichaDeTreino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FichaDeTreinoRepository extends JpaRepository<FichaDeTreino, Long> {
}
