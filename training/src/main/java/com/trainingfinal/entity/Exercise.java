package com.trainingfinal.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Exercise {
	private Long exerciseId;
	private Long workoutId;
	private String exerciseName;
	private int numReps;
	private int numSets;
	private Double weightLbs;
	private Rpe	ratedPercievedExertion;
	
}
