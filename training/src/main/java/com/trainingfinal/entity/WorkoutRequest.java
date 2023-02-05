package com.trainingfinal.entity;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class WorkoutRequest {
	@NotNull
	@Length(max = 30)
	@Pattern(regexp = "[\\w\\s]*")
	private String workoutName;
	
	@NotNull
	@Length(max = 30)
	@Pattern(regexp = "[\\w\\s]*")
	private String client;
	
	@NotNull
	@Length(max = 30)
	@Pattern(regexp = "[\\w\\s]*")
	private Double estimatedHrs;
	
	private List<@NotNull @Length(max = 30) @Pattern(
			regexp = "[\\w\\s]*") String> exercises;
	
	@NotNull
	@Positive
	@Min(20)
	@Max(200)
	private Double price;
}
