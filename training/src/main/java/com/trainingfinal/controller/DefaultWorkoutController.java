package com.trainingfinal.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.trainingfinal.entity.Workout;
import com.trainingfinal.service.WorkoutService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultWorkoutController implements WorkoutController {

	@Autowired
	private WorkoutService workoutService;

	// Post/Create workout
	@Override
	public Optional<Workout> createWorkout(String workoutName, Long clientId, 
			Double estimatedHrs, BigDecimal price) {
		log.info("workoutName={}, clientId={}, estimatedHrs={}, price={}", workoutName,
				clientId, estimatedHrs, price);
		
		return workoutService.createWorkout(workoutName, clientId, estimatedHrs, price);
	}

	// Get/Read workout
	@Override
	public List<Workout> fetchWorkouts(Long clientId) {
		log.info("clientId={}", clientId);
		
		return workoutService.fetchWorkouts(clientId);
	}

	// Put/Update workout
	@Override
	public Optional<Workout> updateWorkout(String workoutName, Long clientId, 
			Double estimatedHrs, BigDecimal price, String newWorkoutName, Long newClientId, 
			Double newEstimatedHrs, BigDecimal newPrice) {
		log.info("workoutName={}, clientId={}, estimatedHrs={}, price={}, newWorkoutName={}, "
				+ "newClientId={}, newEstimatedHrs={}, newPrice={}", workoutName, clientId, 
				estimatedHrs, price, newWorkoutName, newClientId, newEstimatedHrs, newPrice);
		
		return workoutService.updateWorkout(workoutName, clientId, estimatedHrs, price, newWorkoutName, 
				newClientId, newEstimatedHrs, newPrice);
	}

}
