package com.trainingfinal.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.trainingfinal.entity.Workout;

public interface WorkoutDao {
	
	/**
	 * 
	 * @param workoutName
	 * @param clientId
	 * @param estimatedHrs
	 * @param price
	 * @return
	 */
	Optional<Workout> createWorkout(String workoutName, Long clientId, Double estimatedHrs, BigDecimal price);

	/**
	 * 
	 * @param clientId
	 * @return
	 */
	List<Workout> fetchWorkouts(Long clientId);

	/**
	 * 
	 * @param workoutName
	 * @param clientId
	 * @param estimatedHrs
	 * @param price
	 * @param newWorkoutName
	 * @param newClientId
	 * @param newEstimatedHrs
	 * @param newPrice
	 * @return
	 */
	Optional<Workout> updateWorkout(String workoutName, Long clientId, Double estimatedHrs, BigDecimal price,
			String newWorkoutName, Long newClientId, Double newEstimatedHrs, BigDecimal newPrice);
	
}
