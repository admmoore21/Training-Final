package com.trainingfinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.trainingfinal.entity.WorkoutCategory;
import com.trainingfinal.service.WorkoutCategoryService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultWorkoutCategoryController implements WorkoutCategoryController {

	@Autowired
	private WorkoutCategoryService workoutCategoryService;
	@Override
	public List<WorkoutCategory> fetchWorkoutCategories(Long workoutId) {
		log.info("workoutId={}", workoutId);
		
		return workoutCategoryService.fetchWorkoutCategories(workoutId);
	}

}
