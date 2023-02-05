package com.trainingfinal.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.trainingfinal.entity.Exercise;
import com.trainingfinal.entity.Workout;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/Exercises")
@OpenAPIDefinition(info = @Info(title = "Training Exercise Service"), servers = {
        @Server(url = "http://localhost:8080", description = "Local server.")})

public interface ExerciseController {
	// @formatter: off
	@Operation(
			summary = "Returns a list of exercises",
			description = "Returns a list of exercises given a workout Id",
			responses = {
				@ApiResponse(
					responseCode = "200",
					description = "The list of exercises is returned",
					content = @Content(
						mediaType = "application/json",
						schema = @Schema(implementation = Workout.class))),
				@ApiResponse(
			        responseCode = "400", 
			        description = "The request parameters are invalid", 
			        content = @Content(mediaType = "application/json")),
			    @ApiResponse(
			        responseCode = "404", 
			        description = "No exercises found with the input criteria", 
			        content = @Content(mediaType = "application/json")),
			    @ApiResponse(
			        responseCode = "500", 
			        description = "An unplanned error occurred", 
			        content = @Content(mediaType = "application/json"))
			},
		    parameters = {
		    	@Parameter(
		    	    name = "workoutId",
		    	    allowEmptyValue = false,
		    	    required = false,
		    	    description = "The workout ID (i.e., 1 or 2")
		   }
		)
		
		// Get/Read method
		@GetMapping
		@ResponseStatus(code = HttpStatus.OK)
		 List<Exercise> fetchExercises(
				@RequestParam(required = false)
				Long workoutId);
}
