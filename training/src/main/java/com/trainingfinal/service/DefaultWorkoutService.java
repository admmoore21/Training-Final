package com.trainingfinal.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trainingfinal.dao.WorkoutDao;
import com.trainingfinal.entity.Workout;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultWorkoutService implements WorkoutService {

	@Autowired
	private WorkoutDao workoutDao;
	
	// Post/Create workout
	@Override
	public Optional<Workout> createWorkout(String workoutName, Long clientId, 
			Double estimatedHrs, BigDecimal price) {
		log.info("The createWorkout method was called with workoutName={}, clientId={}, "
				+ "estimatedHrs={}, price={}", workoutName, clientId, estimatedHrs, price);
		
		return workoutDao.createWorkout(workoutName, clientId, estimatedHrs, price);
	}
	
	// Get/Read workout
	@Transactional(readOnly = true)
	@Override
	public List<Workout> fetchWorkouts(Long clientId) {
		log.info("The fetchWorkouts method was called with clientId={}", clientId);
		
		return workoutDao.fetchWorkouts(clientId);
	}

	// Put/Update workout
	@Override
	public Optional<Workout> updateWorkout(String workoutName, Long clientId, 
			Double estimatedHrs, BigDecimal price, String newWorkoutName, 
			Long newClientId, Double newEstimatedHrs, BigDecimal newPrice) {
		log.info("The updateWorkout method was called with workoutName={}, "
				+ "clientId={}, estimatedHrs={}, price={}, newWorkoutName={}, "
				+ "newClientId={}, newEstimatedHrs={}, newPrice={}", workoutName, 
				clientId, estimatedHrs, price, newWorkoutName, newClientId, 
				newEstimatedHrs, newPrice );
		
		return workoutDao.updateWorkout(workoutName, clientId, estimatedHrs, price, 
				newWorkoutName, newClientId, newEstimatedHrs, newPrice);
	}
	

}
