package com.trainingfinal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.trainingfinal.entity.Category;
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
@RequestMapping("/Category")
@OpenAPIDefinition(info = @Info(title = "Training Category Service"), servers = {
        @Server(url = "http://localhost:8080", description = "Local server.")})


public interface CategoryController {
	@Operation(
			summary = "Returns a list of categories",
			description = "Returns a list of categories given a supplied category Id",
			responses = {
				@ApiResponse(
					responseCode = "200",
					description = "The list of categories is returned",
					content = @Content(
						mediaType = "application/json",
						schema = @Schema(implementation = Workout.class))),
				@ApiResponse(
			        responseCode = "400", 
			        description = "The request parameters are invalid", 
			        content = @Content(mediaType = "application/json")),
			    @ApiResponse(
			        responseCode = "404", 
			        description = "No categories found with the input criteria", 
			        content = @Content(mediaType = "application/json")),
			    @ApiResponse(
			        responseCode = "500", 
			        description = "An unplanned error occurred", 
			        content = @Content(mediaType = "application/json"))
			},
		    parameters = {
		    	@Parameter(
		    	    name = "categoryId",
		    	    allowEmptyValue = false,
		    	    required = false,
		    	    description = "The category Ids (i.e., 1, 3, 4)")
			}
		)
		
		// Get/Read method
		@GetMapping
		@ResponseStatus(code = HttpStatus.OK)
		List<Category> fetchCategory(
				@RequestParam(required = false)
				Long categoryId);
	
}
