package com.trainingfinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainingfinal.dao.ExerciseDao;
import com.trainingfinal.entity.Exercise;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultExerciseService implements ExerciseService {

	@Autowired
	private ExerciseDao exerciseDao;
	
	// Get/Read exercises
	@Override
	public List<Exercise> fetchExercises(Long workoutId) {
		log.info("workoutId={}", workoutId);
		
		return exerciseDao.fetchExercises(workoutId);
	}
}