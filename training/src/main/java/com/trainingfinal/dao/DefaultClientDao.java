package com.trainingfinal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.trainingfinal.entity.Client;
import com.trainingfinal.entity.Proficiency;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultClientDao implements ClientDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	// Post/Create method to create clients within clients table
	@Override
	public Optional<Client> createClient(String firstName, String lastName, String phone, Proficiency proficiency) {
		log.info("DAO: firstName={}, lastName={}, phone={}, proficiency={}", 
				firstName, lastName, phone, proficiency);
		
		//@formatter:off
		String sql = ""
				+ "INSERT INTO clients (first_name, last_name, phone, proficiency"
				+ ") VALUES ("
				+ ":first_name, :last_name, :phone, :proficiency)";
		//@formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("first_name", firstName);
		params.put("last_name", lastName);
		params.put("phone", phone);
		params.put("proficiency", proficiency.toString());
		
		jdbcTemplate.update(sql, params);
		return Optional.ofNullable(Client.builder().firstName(firstName).lastName(lastName)
				.phone(phone).proficiency(proficiency).build());
	}

	// Get/Read method to fetch clients within clients table
	@Override
	public List<Client> fetchClients(String firstName, String lastName, String phone) {
		log.info("DAO: firstName={}, lastName={}, phone={}", firstName, lastName, phone);
		
		//@formatter:off
		String sql = ""
				+"SELECT * "
				+ "FROM clients "
				+ "WHERE first_name = :first_name "
				+ "AND last_name = :last_name "
				+ "AND phone = :phone";
		//@formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("first_name", firstName);
		params.put("last_name", lastName);
		params.put("phone", phone);
		
		return jdbcTemplate.query(sql, params, new RowMapper<>() {
			
			@Override
			public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
				//@formatter:off
				return Client.builder()
						.clientId(rs.getLong("client_Id"))
						.firstName(new String(rs.getString("first_name")))
						.lastName(new String(rs.getString("last_name")))
						.phone(new String(rs.getString("phone")))
						.proficiency(Proficiency.valueOf(rs.getString("proficiency")))
						.build();
				//@formatter:on
			}
		});
	}

	// Put/Update method to create clients within clients table
	@Override
	public Optional<Client> updateClient(String firstName, String lastName, String phone, Proficiency proficiency,
			String newFirstName, String newLastName, String newPhone, Proficiency newProficiency) {
		log.info("DAO: firstName={}, lastName={}, phone={}, proficiency={}, newFirstName={}, "
				+ "newLastName={}, newPhone={}, newProficiency={}", firstName, lastName, 
				phone, proficiency, newFirstName, newLastName, newPhone, newProficiency);
		
		//@formatter: off
		String sql = ""
				+ "UPDATE clients "
				+ "SET first_name = :new_first_name, "
				+ "last_name = :new_last_name, "
				+ "phone= :new_phone, "
				+ "proficiency = :new_proficiency "
				+ "WHERE first_name = :first_name AND "
				+ "last_name = :last_name AND "
				+ "phone = :phone";
		//@formatter: on
		
		Map<String, Object> params = new HashMap<>();
		params.put("first_name", firstName);
		params.put("last_name", lastName);
		params.put("phone", phone);
		params.put("proficiency", proficiency);
		params.put("new_first_name", newFirstName);
		params.put("new_last_name", newLastName);
		params.put("new_phone", newPhone);
		params.put("new_proficiency", proficiency);

	    jdbcTemplate.update(sql, params);
		return Optional.ofNullable(Client.builder()
				.firstName(newFirstName).lastName(newLastName).phone(newPhone)
				.proficiency(newProficiency).build());
	}

	// Delete method to delete clients within clients table
	@Override
	public Optional<Client> deleteClient(String firstName, String lastName, String phone) {
		//@formatter: off
		String sql = ""
				+"DELETE FROM clients WHERE "
				+ "first_name = :first_name AND "
				+ "last_name = :last_name AND "
				+ "phone = :phone";
		//@formatter: on
		
		Map<String, Object> params = new HashMap<>();
		params.put("first_name", firstName);
		params.put("last_name", lastName);
		params.put("phone", phone);
		
		jdbcTemplate.update(sql, params);
		return Optional.ofNullable(Client.builder().firstName(firstName)
				.lastName(lastName).phone(phone).build());
	}

}
