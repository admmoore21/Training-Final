package com.trainingfinal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.trainingfinal.entity.Exercise;
import com.trainingfinal.entity.Rpe;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultExerciseDao implements ExerciseDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public List<Exercise> fetchExercises(Long workoutId) {
		log.info("DAO: workoutId={}", workoutId);
		
		//@formatter:off
		String sql = ""
				+"SELECT * "
				+ "FROM exercises "
				+ "WHERE workout_id = :workout_id ";
		//@formatter:on
				
		Map<String, Object> params = new HashMap<>();
		params.put("workout_id", workoutId);
				
		return jdbcTemplate.query(sql, params, new RowMapper<>() {
					
			@Override
			public Exercise mapRow(ResultSet rs, int rowNum) throws SQLException {
				//@formatter:off
				return Exercise.builder()
						.exerciseId(rs.getLong("exercise_id"))
						.workoutId(rs.getLong("workout_id"))
						.exerciseName(new String(rs.getString("exercise_name")))
						.numReps(rs.getInt("num_reps"))
						.numSets(rs.getInt("num_sets"))
						.weightLbs(rs.getDouble("weight_lbs"))
						.ratedPercievedExertion(Rpe.valueOf(rs.getString("Rpe")))
						.build();
				//@formatter:on
			}
		});
	}

}
