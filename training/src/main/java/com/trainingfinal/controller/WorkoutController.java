package com.trainingfinal.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

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
@RequestMapping("/Workouts")
@OpenAPIDefinition(info = @Info(title = "Workout Service"), servers = {
        @Server(url = "http://localhost:8080", description = "Local server.")})

public interface WorkoutController {	
// @formatter:off
	@Operation(
		summary = "Create a workout for a client",
		description = "Create a workout by supplying the workout name, client id, "
					+ "estimated hrs, and price."	,
		responses = {
			@ApiResponse(
				responseCode = "201",
				description = "The created workout is returned",
				content = @Content(
					mediaType = "application/json",
					schema = @Schema(implementation = Workout.class))),
			@ApiResponse(
		        responseCode = "400", 
		        description = "The request parameters are invalid", 
		        content = @Content(mediaType = "application/json")),
		    @ApiResponse(
		        responseCode = "404", 
		        description = "Unable to create workout with the input criteria", 
		        content = @Content(mediaType = "application/json")),
		    @ApiResponse(
		        responseCode = "500", 
		        description = "An unplanned error occurred", 
		        content = @Content(mediaType = "application/json"))
		},
	    parameters = {
	    	@Parameter(
	    	    name = "workoutName",
	    	    allowEmptyValue = false,
	    	    required = false,
	    	    description = "The workout name (i.e., 'Monday Leg Push'"),
	    	@Parameter(
	            name = "clientId",
	            allowEmptyValue = false,
	            required = false,
	            description = "The client Id (i.e., '1' or '2')"),
	    	@Parameter(
	            name = "estimatedHrs",
	            allowEmptyValue = false,
	            required = false,
	            description = "The estimated hrs (i.e., '0.5')"),
	    	@Parameter(
	            name = "price",
	            allowEmptyValue = false,
	            required = false,
	            description = "The price (i.e., '125')"),
	   }
	)
	
	// Post/Create method
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	 Optional<Workout> createWorkout(
			 @RequestParam(required = false)
			 String workoutName,
			 @RequestParam(required = false)
			 Long clientId,
			 @RequestParam(required = false)
			 Double estimatedHrs, 
			 @RequestParam(required = false)
			 BigDecimal price);
	
	@Operation(
			summary = "Returns a list of workouts for a client",
			description = "Returns a list of workouts given a client id",
			responses = {
				@ApiResponse(
					responseCode = "200",
					description = "The workouts are returned",
					content = @Content(
						mediaType = "application/json",
						schema = @Schema(implementation = Workout.class))),
				@ApiResponse(
			        responseCode = "400", 
			        description = "The request parameters are invalid", 
			        content = @Content(mediaType = "application/json")),
			    @ApiResponse(
			        responseCode = "404", 
			        description = "No client found with the input criteria", 
			        content = @Content(mediaType = "application/json")),
			    @ApiResponse(
			        responseCode = "500", 
			        description = "An unplanned error occurred", 
			        content = @Content(mediaType = "application/json"))
			},
		    parameters = {
		    	@Parameter(
		    	    name = "clientId",
		    	    allowEmptyValue = false,
		    	    required = false,
		    	    description = "The client id (i.e., '1' or '2'")
		   }
		)
		
		// Get/Read method
		@GetMapping
		@ResponseStatus(code = HttpStatus.OK)
		 List<Workout> fetchWorkouts(
				 @RequestParam(required = false)
				 Long clientId);
	
	@Operation(
			summary = "Update a workout",
			description = "Update a workout by supplying the workout name, client id, "
						+ "estimated hrs, and price."	,
			responses = {
				@ApiResponse(
					responseCode = "200",
					description = "The workout is updated!",
					content = @Content(
						mediaType = "application/json",
						schema = @Schema(implementation = Workout.class))),
				@ApiResponse(
			        responseCode = "400", 
			        description = "The request parameters are invalid", 
			        content = @Content(mediaType = "application/json")),
			    @ApiResponse(
			        responseCode = "404", 
			        description = "Unable to update the workout with the input criteria", 
			        content = @Content(mediaType = "application/json")),
			    @ApiResponse(
			        responseCode = "500", 
			        description = "An unplanned error occurred", 
			        content = @Content(mediaType = "application/json"))
			},
		    parameters = {
		    	@Parameter(
		    	    name = "workoutName",
		    	    allowEmptyValue = false,
		    	    required = false,
		    	    description = "The workout name (i.e., 'Monday Leg Push'"),
		    	@Parameter(
		            name = "clientId",
		            allowEmptyValue = false,
		            required = false,
		            description = "The client Id (i.e., '1' or '2')"),
		    	@Parameter(
		            name = "estimatedHrs",
		            allowEmptyValue = false,
		            required = false,
		            description = "The estimated hrs (i.e., '0.5')"),
		    	@Parameter(
		            name = "price",
		            allowEmptyValue = false,
		            required = false,
		            description = "The price (i.e., '125')"),
		   }
		)
		
		// Put/Update method
		@PutMapping
		@ResponseStatus(code = HttpStatus.OK)
		 Optional<Workout> updateWorkout(
				@RequestParam(required = false)
				String workoutName,
				@RequestParam(required = false)
				Long clientId,
				@RequestParam(required = false)
				Double estimatedHrs, 
				@RequestParam(required = false)
				BigDecimal price,
				@RequestParam(required = false)
				String newWorkoutName,
				@RequestParam(required = false)
				Long newClientId,
				@RequestParam(required = false)
				Double newEstimatedHrs, 
				@RequestParam(required = false)
				BigDecimal newPrice);
}
