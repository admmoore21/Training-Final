package com.trainingfinal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.trainingfinal.entity.Client;
import com.trainingfinal.entity.Proficiency;
import com.trainingfinal.service.ClientService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultClientController implements ClientController {
	
	@Autowired
	private ClientService clientService;
	
	// Post/Create client
	@Override
	public Optional<Client> createClient(String firstName, String lastName, 
			String phone, Proficiency proficiency) {
		log.info("firstName={}, lastName={}, phone={}, proficiency={}", 
				firstName, lastName, phone, proficiency);
		return clientService.createClient(firstName, lastName, phone, proficiency);
	}

	// Get/Read client
	@Override
	public List<Client> fetchClients(String firstName, String lastName, String phone) {
		log.info("firstName={}, lastName={}, phone={}", firstName, lastName, phone);

		return clientService.fetchClients(firstName, lastName, phone);
	}

	// Put/Update Client
	@Override
	public Optional<Client> updateClient(String firstName, String lastName, String phone, 
			Proficiency proficiency, String newFirstName, String newLastName, String newPhone, 
			Proficiency newProficiency) {
		log.info("firstName={}, lastName={}, phone={}, proficiency={}, newFirstName={}, "
				+ "newLastName={}, newPhone={}, newProficiency={}", firstName, lastName, phone, 
				proficiency, newFirstName, newLastName, newPhone, newProficiency);
		return clientService.updateClient(firstName, lastName, phone, proficiency, 
				newFirstName, newLastName, newPhone, newProficiency);
	}

	// Delete client
	@Override
	public Optional<Client> deleteClient(String firstName, String lastName, String phone) {
		log.info("firstName={}, lastName={}, phone={}", firstName, lastName, phone);
		return clientService.deleteClient(firstName, lastName, phone);
	}

}
