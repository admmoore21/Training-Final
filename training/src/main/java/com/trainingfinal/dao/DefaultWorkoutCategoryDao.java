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

import com.trainingfinal.entity.Client;
import com.trainingfinal.entity.Proficiency;
import com.trainingfinal.entity.WorkoutCategory;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultWorkoutCategoryDao implements WorkoutCategoryDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<WorkoutCategory> fetchWorkoutCategories(Long workoutId) {
		log.info("DAO: workoutId={}", workoutId);
		
		//@formatter:off
		String sql = ""
				+"SELECT * "
				+ "FROM workout_category "
				+ "WHERE workout_id = :workout_id ";
		//@formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("workout_id", workoutId);
		
		return jdbcTemplate.query(sql, params, new RowMapper<>() {
			
			@Override
			public WorkoutCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
				//@formatter:off
				return WorkoutCategory.builder()
					.workoutId(rs.getLong("workout_id"))
					.categoryId(rs.getLong("category_id"))
					.build();
				//@formatter:on
			}
		});
	}
}