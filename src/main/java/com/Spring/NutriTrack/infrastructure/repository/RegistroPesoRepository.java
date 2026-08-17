package com.Spring.NutriTrack.infrastructure.repository;

import com.Spring.NutriTrack.domain.model.RegistroPeso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroPesoRepository extends JpaRepository<Long, RegistroPeso> {
}
