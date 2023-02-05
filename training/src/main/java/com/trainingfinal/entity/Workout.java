package com.trainingfinal.entity;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Workout {
	private Long workoutId;
	private String workoutName;
	private Long clientId;
	private Double estimatedHrs;
	private List<Exercise> exercises;
	private BigDecimal price;
	
	@JsonIgnore
	public Long getWorkoutId() {
		return workoutId;
	}
}
