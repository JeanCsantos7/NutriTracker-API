package com.Spring.NutriTrack.application.mapper;


import com.Spring.NutriTrack.application.dto.request.UsuarioRequestDTO;
import com.Spring.NutriTrack.application.dto.response.UsuarioResponseDTO;
import com.Spring.NutriTrack.domain.model.Usuario;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioResponseDTO toDTO(Usuario entity);
    Usuario toEntity(UsuarioRequestDTO dto);


    @BeanMapping(
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
    )

    void update(
            UsuarioRequestDTO dto,
            @MappingTarget Usuario entity
    );



}
