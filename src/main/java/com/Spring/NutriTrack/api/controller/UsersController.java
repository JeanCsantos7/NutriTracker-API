package com.Spring.NutriTrack.api.controller;

import com.Spring.NutriTrack.application.dto.request.UsuarioRequestDTO;
import com.Spring.NutriTrack.application.dto.response.UsuarioResponseDTO;
import com.Spring.NutriTrack.application.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {

     private final UsuarioService usuarioService;



    @PostMapping("/createAccount")
    public ResponseEntity<UsuarioResponseDTO> save( @RequestBody UsuarioRequestDTO dto){
       return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(dto));
    }

    @GetMapping
    public ResponseEntity<Page<UsuarioResponseDTO>> findAll(Pageable pageable){
        return ResponseEntity.ok(usuarioService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> findByID(@PathVariable Long id){
     return ResponseEntity.ok(usuarioService.findByID(id));
    }

    @PutMapping("/editAccount/{id}")
    public ResponseEntity<UsuarioResponseDTO> update(@RequestBody  UsuarioRequestDTO dto,  @PathVariable Long id){

        return ResponseEntity.ok(usuarioService.updateProfile(dto, id));
    }

    @DeleteMapping("/deleteAccount/{id}")
    public ResponseEntity<Void> delete(@PathVariable  Long id){
        usuarioService.delete(id);
       return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
