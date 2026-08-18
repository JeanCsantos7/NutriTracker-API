package com.Spring.NutriTrack.infrastructure.repository;

import com.Spring.NutriTrack.domain.model.Meta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetaRepository extends JpaRepository<Meta, Long> {
}
