package com.Spring.NutriTrack.application.service;

import com.Spring.NutriTrack.application.dto.request.GoalRequestDTO;
import com.Spring.NutriTrack.application.dto.response.GoalResponseDTO;
import com.Spring.NutriTrack.application.mapper.GoalMapper;
import com.Spring.NutriTrack.domain.enums.StatusMeta;
import com.Spring.NutriTrack.domain.model.Meta;
import com.Spring.NutriTrack.domain.model.Usuario;
import com.Spring.NutriTrack.infrastructure.repository.MetaRepository;
import com.Spring.NutriTrack.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GoalService {

    private final MetaRepository goalRepository;
    private final GoalMapper goalsMapper;
    private final UsuarioRepository usersRepository;

    public GoalResponseDTO saveGoal(GoalRequestDTO goalsDTO){
        Meta goals = new Meta();

        Usuario user = usersRepository.findById(goalsDTO.usuarioId()).orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        goals.setUsersGoals(user);
        goals.setPesoMeta(goalsDTO.pesoMeta());
        goals.setCaloriasDiarias(goalsDTO.caloriasDiarias());
        goals.setProteinasDiarias(goalsDTO.proteinasDiarias());
        goals.setDataInicio(goalsDTO.dataInicio());
        goals.setDataFim(goalsDTO.dataFim());
        goals.setStatus(StatusMeta.EM_PROGRESSO);

        Meta saved = goalRepository.save(goals);

        return goalsMapper.toDTO(saved);

    }

    public Page<GoalResponseDTO> findAll(Pageable pageable){
       Page<Meta> goals = goalRepository.findAll(pageable);
       return goals.map(goalsMapper::toDTO);

    }

    public GoalResponseDTO findByID(Long id){
       Meta findMeta = goalRepository.findById(id).orElseThrow(() -> new RuntimeException("Registro não localizado!"));
       return goalsMapper.toDTO(findMeta);
    }

    public GoalResponseDTO updateGoals(GoalRequestDTO goalsDTO, Long id){
        Meta findGoals = goalRepository.findById(id).orElseThrow(() -> new RuntimeException("Meta não localizada!"));
        goalsMapper.update(goalsDTO, findGoals);
        Meta saved = goalRepository.save(findGoals);
        return goalsMapper.toDTO(saved);

    }

    public GoalResponseDTO finishGoal(Long id){
        Meta goals = goalRepository.findById(id).orElseThrow(() -> new RuntimeException("Meta não localizada!"));
        StatusMeta previousGoal = goals.getStatus();

        if(!previousGoal.equals(StatusMeta.CONCLUIDA)){

            goals.setStatus(StatusMeta.CONCLUIDA);
            goalRepository.save(goals);


        }
        else{
            throw new RuntimeException("Não é possível editar uma meta já concluida ou cancelada!");
        }

        return goalsMapper.toDTO(goals);

    }


}
