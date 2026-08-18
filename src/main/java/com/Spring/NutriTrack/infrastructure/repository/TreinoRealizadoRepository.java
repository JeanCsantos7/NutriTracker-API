package com.Spring.NutriTrack.infrastructure.repository;

import com.Spring.NutriTrack.domain.model.TreinoRealizado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreinoRealizadoRepository extends JpaRepository<TreinoRealizado,Long > {
}
