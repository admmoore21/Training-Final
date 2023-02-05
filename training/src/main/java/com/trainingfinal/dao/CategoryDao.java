package com.trainingfinal.dao;

import java.util.List;

import com.trainingfinal.entity.Category;

public interface CategoryDao {

	List<Category> fetchCategory(Long categoryId);

}
