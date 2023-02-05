package com.trainingfinal.dao;

import java.util.List;

import com.trainingfinal.entity.Exercise;

public interface ExerciseDao {

	List<Exercise> fetchExercises(Long workoutId);

}
