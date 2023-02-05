package com.trainingfinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainingfinal.dao.WorkoutCategoryDao;
import com.trainingfinal.entity.WorkoutCategory;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultWorkoutCategoryService implements WorkoutCategoryService {

	@Autowired
	private WorkoutCategoryDao workoutCategoryDao;
	
	@Override
	public List<WorkoutCategory> fetchWorkoutCategories(Long workoutId) {
		log.info("workoutId={}", workoutId);
		
		return workoutCategoryDao.fetchWorkoutCategories(workoutId);
	}
}
