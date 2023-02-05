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

import com.trainingfinal.entity.Category;
import com.trainingfinal.entity.CategoryName;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultCategoryDao implements CategoryDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public List<Category> fetchCategory(Long categoryId) {
		log.info("DAO: categoryId={}", categoryId);		

		//@formatter:off
		String sql = ""
				+"SELECT * "
				+ "FROM categories "
				+ "WHERE category_id = :category_id";
		//@formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("category_id", categoryId);
		
		return jdbcTemplate.query(sql, params, new RowMapper<>() {
			
			@Override
			public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
				//@formatter:off
				return Category.builder()
						.categoryId(rs.getLong("category_id"))
						.categoryName(CategoryName.valueOf(rs.getString("category_name")))
						.build();
				//@formatter:on
			}
		});
	}
}
