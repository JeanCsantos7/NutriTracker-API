package com.Spring.NutriTrack.infrastructure.repository;

import com.Spring.NutriTrack.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

     Boolean existsByEmail(String email);
}
