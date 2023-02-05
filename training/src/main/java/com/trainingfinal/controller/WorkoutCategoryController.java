package com.trainingfinal.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.trainingfinal.entity.Workout;
import com.trainingfinal.entity.WorkoutCategory;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/WorkoutCategory")
@OpenAPIDefinition(info = @Info(title = "Training Workout Category Service"), servers = {
        @Server(url = "http://localhost:8080", description = "Local server.")})

public interface WorkoutCategoryController {
	// @formatter:off
	@Operation(
			summary = "Returns a list workout category Ids",
			description = "Returns a list of workout category Ids given a supplied workout Id",
			responses = {
				@ApiResponse(
					responseCode = "200",
					description = "The list of category Ids is returned",
					content = @Content(
						mediaType = "application/json",
						schema = @Schema(implementation = Workout.class))),
				@ApiResponse(
			        responseCode = "400", 
			        description = "The request parameters are invalid", 
			        content = @Content(mediaType = "application/json")),
			    @ApiResponse(
			        responseCode = "404", 
			        description = "No categories with the input criteria", 
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
		    	    description = "The workoutId (i.e., 1 "),
		   }
		)
		
		// Get/Read method
		@GetMapping
		@ResponseStatus(code = HttpStatus.OK)
		 List<WorkoutCategory> fetchWorkoutCategories(
				@RequestParam(required = false)
				Long workoutId);
}
