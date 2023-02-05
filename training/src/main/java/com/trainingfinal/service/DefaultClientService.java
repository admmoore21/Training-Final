package com.trainingfinal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainingfinal.dao.ClientDao;
import com.trainingfinal.entity.Client;
import com.trainingfinal.entity.Proficiency;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultClientService implements ClientService {

	@Autowired
	private ClientDao clientDao;
	
	// Post/Create client
	@Override
	public Optional<Client> createClient(String firstName, String lastName, 
			String phone, Proficiency proficiency) {
		log.info("firstName={}, lastName={}, phone={}, proficiency={}", 
				firstName, lastName, phone, proficiency);
		
		return clientDao.createClient(firstName, lastName, phone, proficiency);
	}

	// Get/Read Client
	@Override
	public List<Client> fetchClients(String firstName, String lastName, String phone) {
		log.info("firstName={}, lastName{}, phone={}", firstName, lastName, phone);
		return clientDao.fetchClients(firstName, lastName, phone);
	}

	// Put/Update client
	@Override
	public Optional<Client> updateClient(String firstName, String lastName, String phone, 
			Proficiency proficiency, String newFirstName, String newLastName, 
			String newPhone, Proficiency newProficiency) {
		log.info("firstName={}, lastName={}, phone={}, proficiency={}, newFirstName={}, "
				+ "newLastName={}, newPhone={}, newProficiency={}", firstName, lastName, 
				phone, proficiency, newFirstName, newLastName, newPhone, newProficiency);
		
		return clientDao.updateClient(firstName, lastName, 
				phone, proficiency, newFirstName, newLastName, newPhone, newProficiency);
	}

	// Delete client
	@Override
	public Optional<Client> deleteClient(String firstName, String lastName, String phone) {
		log.info("firstName={}, lastName{}, phone={}", firstName, lastName, phone);
		return clientDao.deleteClient(firstName, lastName, phone);
	}

}
