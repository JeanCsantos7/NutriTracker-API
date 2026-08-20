package com.Spring.NutriTrack.application.mapper;


import com.Spring.NutriTrack.application.dto.request.GoalRequestDTO;
import com.Spring.NutriTrack.application.dto.response.GoalResponseDTO;
import com.Spring.NutriTrack.domain.model.Meta;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface GoalMapper {

    @Mapping(source = "usersGoals.id", target = "usuarioId" )
    GoalResponseDTO toDTO(Meta metaEntity);



    @BeanMapping(
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
    )

    void update(
            GoalRequestDTO dto,
            @MappingTarget Meta entity
            );




}
