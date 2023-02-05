package com.trainingfinal.service;

import java.util.List;

import com.trainingfinal.entity.Category;

public interface CategoryService {

	List<Category> fetchCategory(Long categoryId);

}
