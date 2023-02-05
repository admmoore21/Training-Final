package com.trainingfinal.dao;

import java.util.List;

import com.trainingfinal.entity.WorkoutCategory;

public interface WorkoutCategoryDao {

	List<WorkoutCategory> fetchWorkoutCategories(Long workoutId);

}
