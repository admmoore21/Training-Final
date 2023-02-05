package com.trainingfinal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.trainingfinal.entity.Client;
import com.trainingfinal.entity.Proficiency;
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
@RequestMapping("/Clients")
@OpenAPIDefinition(info = @Info(title = "Training Client Service"), servers = {
        @Server(url = "http://localhost:8080", description = "Local server.")})

public interface ClientController {	
	// @formatter:off
	@Operation(
		summary = "Create a client",
		description = "Create a client by supplying the first name, last name, "
					+ "phone number, and proficiency level.",
		responses = {
			@ApiResponse(
				responseCode = "201",
				description = "The client is created!",
				content = @Content(
					mediaType = "application/json",
					schema = @Schema(implementation = Workout.class))),
			@ApiResponse(
		        responseCode = "400", 
		        description = "The request parameters are invalid", 
		        content = @Content(mediaType = "application/json")),
		    @ApiResponse(
		        responseCode = "404", 
		        description = "Unable to create client with the input criteria", 
		        content = @Content(mediaType = "application/json")),
		    @ApiResponse(
		        responseCode = "500", 
		        description = "An unplanned error occurred", 
		        content = @Content(mediaType = "application/json"))
		},
	    parameters = {
	    	@Parameter(
	    	    name = "firstName",
	    	    allowEmptyValue = false,
	    	    required = false,
	    	    description = "The first name (i.e., 'John'"),
	    	@Parameter(
	            name = "lastName",
	            allowEmptyValue = false,
	            required = false,
	            description = "The last name (i.e., 'Smith')"),
	    	@Parameter(
	            name = "phone",
	            allowEmptyValue = false,
	            required = false,
	            description = "The phone number (i.e., '4064562324')"),
	    	@Parameter(
	            name = "proficiency",
	            allowEmptyValue = false,
	            required = false,
	            description = "The proficiency level (i.e., 'beginner')"),
	   }
	)
	
	// Post/Create method
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	 Optional<Client> createClient(
			 @RequestParam(required = false)
			 String firstName,
			 @RequestParam(required = false)
			 String lastName,
			 @RequestParam(required = false)
			 String phone, 
			 @RequestParam(required = false)
			 Proficiency proficiency);
	
	@Operation(
			summary = "Returns a list of clients",
			description = "Returns a list of clients given a first name, last name, "
						+ "and phone number",
			responses = {
				@ApiResponse(
					responseCode = "200",
					description = "The list of clients is returned",
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
		    	    name = "firstName",
		    	    allowEmptyValue = false,
		    	    required = false,
		    	    description = "The first name (i.e., 'John'"),
		 		 @Parameter(
		 		    name = "lastName",
		 		    allowEmptyValue = false,
		 		    required = false,
		 		    description = "The last name (i.e., 'Smith'"),
		 		@Parameter(
			 		name = "phone",
			 		allowEmptyValue = false,
			 		required = false,
			 		description = "The phone number (i.e., '4067838494'"),
		   }
		)
		
		// Get/Read method
		@GetMapping
		@ResponseStatus(code = HttpStatus.OK)
		 List<Client> fetchClients(
				@RequestParam(required = false)
				String firstName,
				@RequestParam(required = false)
				String lastName,
				@RequestParam(required = false)
				String phone);
	
	@Operation(
			summary = "Update a client",
			description = "Update a client by supplying the client first name, client last name, "
						+ "phone, and proficiency."	,
			responses = {
				@ApiResponse(
					responseCode = "200",
					description = "The client is updated!",
					content = @Content(
						mediaType = "application/json",
						schema = @Schema(implementation = Workout.class))),
				@ApiResponse(
			        responseCode = "400", 
			        description = "The request parameters are invalid", 
			        content = @Content(mediaType = "application/json")),
			    @ApiResponse(
			        responseCode = "404", 
			        description = "Unable to update the client with the input criteria", 
			        content = @Content(mediaType = "application/json")),
			    @ApiResponse(
			        responseCode = "500", 
			        description = "An unplanned error occurred", 
			        content = @Content(mediaType = "application/json"))
			},
		    parameters = {
		    	@Parameter(
		    	    name = "firstName",
		    	    allowEmptyValue = false,
		    	    required = false,
		    	    description = "The first name (i.e., 'John'"),
		    	@Parameter(
		            name = "lastName",
		            allowEmptyValue = false,
		            required = false,
		            description = "The last name (i.e., 'Smith')"),
		    	@Parameter(
		            name = "phone",
		            allowEmptyValue = false,
		            required = false,
		            description = "The phone number (i.e., '1234567890')"),
		    	@Parameter(
		            name = "proficiency",
		            allowEmptyValue = false,
		            required = false,
		            description = "The proficiency level (i.e., 'intermediate')")
		   }
		)
		
		// Put/Update method
		@PutMapping
		@ResponseStatus(code = HttpStatus.OK)
		 Optional<Client> updateClient(
				@RequestParam(required = false)
				String firstName,
				@RequestParam(required = false)
				String lastName,
				@RequestParam(required = false)
				String phone, 
				@RequestParam(required = false)
				Proficiency proficiency,
				@RequestParam(required = false)
				String newFirstName,
				@RequestParam(required = false)
				String newLastName,
				@RequestParam(required = false)
				String newPhone, 
				@RequestParam(required = false)
				Proficiency newProficiency);
	
	@Operation(
			summary = "Delete a client",
			description = "Delete a client by supplying the client first name, last name, "
						+ "and phone number."	,
			responses = {
				@ApiResponse(
					responseCode = "200",
					description = "The client is deleted!",
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
		    	    name = "firstName",
		    	    allowEmptyValue = false,
		    	    required = false,
		    	    description = "The first name (i.e., 'John'"),
		    	@Parameter(
		            name = "lastName",
		            allowEmptyValue = false,
		            required = false,
		            description = "The last name (i.e., 'Smith')"),
		    	@Parameter(
		            name = "phone",
		            allowEmptyValue = false,
		            required = false,
		            description = "The phone number (i.e., '1234567890')")
		   }
		)
		
		// Delete method
		@DeleteMapping
		@ResponseStatus(code = HttpStatus.OK)
		Optional<Client> deleteClient(
				@RequestParam(required = false)
				String firstName,
				@RequestParam(required = false)
				String lastName,
				@RequestParam(required = false)
				String phone);
}
