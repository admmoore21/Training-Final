package com.trainingfinal.dao;

import java.math.BigDecimal;
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

import com.trainingfinal.entity.Workout;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultWorkoutDao implements WorkoutDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	// Post/Create method to create workouts within the workouts table
	@Override
	public Optional<Workout> createWorkout(String workoutName, Long clientId, Double estimatedHrs, BigDecimal price) {
		log.info("DAO: The createWorkout method was called with workoutName={}, clientId={}, "
				+ "estimatedHrs={}, price={}", workoutName, clientId, estimatedHrs, price);

		// @formatter: off
		String sql = "" + "INSERT INTO workouts (workout_name, client_id, estimated_hrs, price" + ") VALUES ("
				+ ":workout_name, :client_id, :estimated_hrs, :price)";
		// @formatter: on

		Map<String, Object> params = new HashMap<>();
		params.put("workout_name", workoutName);
		params.put("client_id", clientId);
		params.put("estimated_hrs", estimatedHrs);
		params.put("price", price.toString());

		jdbcTemplate.update(sql, params);
		return Optional.ofNullable(Workout.builder().workoutName(workoutName).clientId(clientId)
				.estimatedHrs(estimatedHrs).price(price).build());
	}

	/* Post/Create method to create workouts within the workouts table 
	 * I ould like to add functionality to this method to be able to fetch exercises as 
	 * well within the workouts. I'm not sure how at the moment*/
	@Override
	public List<Workout> fetchWorkouts(Long clientId) {
		log.info("DAO: clientId={}", clientId);
		
		// @formatter:off
		String sql = "" + "SELECT * " 
				+ "FROM workouts " 
				+ "WHERE client_id = :client_id";
		// @formatter:on

		Map<String, Object> params = new HashMap<>();
		params.put("client_id", clientId);

		return jdbcTemplate.query(sql, params, new RowMapper<>() {

			@Override
			public Workout mapRow(ResultSet rs, int rowNum) throws SQLException {
				//@formatter:off
				return Workout.builder()
						.workoutId(rs.getLong("workout_id"))
						.workoutName(new String(rs.getString("workout_name")))
						.clientId(rs.getLong("client_Id"))
						.estimatedHrs(rs.getDouble("estimated_hrs"))
						.price(rs.getBigDecimal("price"))
						.build();
				//@formatter:on
			}
		});
	}

	// Post/Create method to create workouts within the workouts table
	@Override
	public Optional<Workout> updateWorkout(String workoutName, Long clientId, Double estimatedHrs, BigDecimal price,
			String newWorkoutName, Long newClientId, Double newEstimatedHrs, BigDecimal newPrice) {
		log.info("DAO: workoutName={}, clientId={}, estimatedHrs={}, price={}, newWorkoutName={}, "
				+ "newClientId={}, newEstimatedHrs={}, newPrice={}", workoutName, clientId, 
				estimatedHrs, price, newWorkoutName, newClientId, newEstimatedHrs, newPrice );
		//@formatter: off
		String sql = ""
				+ "UPDATE workouts "
				+ "SET workout_name = :new_workout_name, "
				+ "client_id = :new_client_id, "
				+ "estimated_hrs= :new_estimated_hrs, "
				+ "price = :new_price "
				+ "WHERE workout_name = :workout_name AND "
				+ "client_id = :client_id AND "
				+ "estimated_hrs = :estimated_hrs AND "
				+ "price = :price";
		//@formatter: on
		
		Map<String, Object> params = new HashMap<>();
		params.put("workout_name", workoutName);
		params.put("client_id", clientId);
		params.put("estimated_hrs", estimatedHrs);
		params.put("price", price);
		params.put("new_workout_name", newWorkoutName);
		params.put("new_client_id", newClientId);
		params.put("new_estimated_hrs", newEstimatedHrs);
		params.put("new_price", newPrice);

	    jdbcTemplate.update(sql, params);
		return Optional.ofNullable(Workout.builder()
				.workoutName(newWorkoutName).clientId(newClientId).estimatedHrs(newEstimatedHrs)
				.price(newPrice).build());
	}
}
