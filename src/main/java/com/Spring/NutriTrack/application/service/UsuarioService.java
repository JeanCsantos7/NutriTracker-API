package com.Spring.NutriTrack.application.service;

import com.Spring.NutriTrack.application.dto.request.UsuarioRequestDTO;
import com.Spring.NutriTrack.application.dto.response.UsuarioResponseDTO;
import com.Spring.NutriTrack.application.mapper.UsuarioMapper;
import com.Spring.NutriTrack.domain.model.Usuario;
import com.Spring.NutriTrack.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
@RequiredArgsConstructor

public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public UsuarioResponseDTO save(UsuarioRequestDTO dto) {
        Usuario toEntity = usuarioMapper.toEntity(dto);
        String hasPassword = bCryptPasswordEncoder.encode(dto.senhaHash());
        toExistMail(dto.email());
        toEntity.setDataCadastro(LocalDate.now());
        toEntity.setSenhaHash(hasPassword);
        Usuario saveUser = usuarioRepository.save(toEntity);

        return usuarioMapper.toDTO(saveUser);


    }

    public Page<UsuarioResponseDTO> findAll(Pageable pageable) {

        Page<Usuario> users = usuarioRepository.findAll(pageable);
        return users.map(usuarioMapper::toDTO);

    }

    public UsuarioResponseDTO findByID(Long id) {
        Usuario findUser = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não localizado!"));
        return usuarioMapper.toDTO(findUser);


    }

    public void toExistMail(String email) {

        try {
            Boolean test = usuarioRepository.existsByEmail(email);
            if (test) {
                throw new RuntimeException("Email Já cadastrado!!");
            }
        } catch (Exception e) {
            throw new RuntimeException("Email Já cadastrado!");
        }


    }


    public UsuarioResponseDTO updateProfile(UsuarioRequestDTO dto, Long id) {

        Usuario findUser = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não localizado!"));
        usuarioMapper.update(dto, findUser);
        Usuario saveUser = usuarioRepository.save(findUser);

        return usuarioMapper.toDTO(saveUser);

    }

    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }


}
