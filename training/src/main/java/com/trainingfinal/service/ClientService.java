package com.trainingfinal.service;

import java.util.List;
import java.util.Optional;

import com.trainingfinal.entity.Client;
import com.trainingfinal.entity.Proficiency;

public interface ClientService {

	Optional<Client> createClient(String firstName, String lastName, String phone, Proficiency proficiency);

	List<Client> fetchClients(String firstName, String lastName, String phone);

	Optional<Client> updateClient(String firstName, String lastName, String phone, Proficiency proficiency,
			String newFirstName, String newLastName, String newPhone, Proficiency newProficiency);

	Optional<Client> deleteClient(String firstName, String lastName, String phone);

}
