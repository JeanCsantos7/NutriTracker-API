package com.Spring.NutriTrack.infrastructure.repository;

import com.Spring.NutriTrack.domain.model.RegistroPeso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroPesoRepository extends JpaRepository<RegistroPeso, Long> {
}
