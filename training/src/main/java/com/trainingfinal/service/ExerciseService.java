package com.trainingfinal.service;

import java.util.List;

import com.trainingfinal.entity.Exercise;

public interface ExerciseService {

	List<Exercise> fetchExercises(Long workoutId);

}
