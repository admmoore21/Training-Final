package com.trainingfinal.service;

import java.util.List;

import com.trainingfinal.entity.WorkoutCategory;

public interface WorkoutCategoryService {

	List<WorkoutCategory> fetchWorkoutCategories(Long workoutId);

}
