package com.trainingfinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.trainingfinal.entity.Exercise;
import com.trainingfinal.service.ExerciseService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultExerciseController implements ExerciseController {

	@Autowired
	private ExerciseService exerciseService;
	@Override
	public List<Exercise> fetchExercises(Long workoutId) {
		log.info("workoutId={}", workoutId);
		
		return exerciseService.fetchExercises(workoutId);
	}

}
