package com.Spring.NutriTrack.api.controller;

import com.Spring.NutriTrack.application.dto.request.GoalRequestDTO;
import com.Spring.NutriTrack.application.dto.response.GoalResponseDTO;
import com.Spring.NutriTrack.application.service.GoalService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goals")
@RequiredArgsConstructor
public class GoalController {

    private final GoalService goalsService;

    @PostMapping("/createGoal")
    public ResponseEntity<GoalResponseDTO> saveGoal(@RequestBody GoalRequestDTO goalsRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(goalsService.saveGoal(goalsRequest));

    }

    @GetMapping
    public ResponseEntity<Page<GoalResponseDTO>> findAll(Pageable pageable){

      return ResponseEntity.ok(goalsService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GoalResponseDTO> findByID(@PathVariable Long id){
        return ResponseEntity.ok(goalsService.findByID(id));
    }

    @PutMapping("/editGoals/{id}")
    public ResponseEntity<GoalResponseDTO> updateGoals(@RequestBody GoalRequestDTO goalsDTO, @PathVariable Long id){
     return ResponseEntity.ok(goalsService.updateGoals(goalsDTO, id));
    }

    @PutMapping("/finishGoal/{id}")
    public ResponseEntity<GoalResponseDTO> finishGoal( @PathVariable Long id){
      return ResponseEntity.ok(goalsService.finishGoal(id));
    }




}
