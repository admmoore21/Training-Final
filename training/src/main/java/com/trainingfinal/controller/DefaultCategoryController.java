package com.trainingfinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.trainingfinal.entity.Category;
import com.trainingfinal.service.CategoryService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultCategoryController implements CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@Override
	public List<Category> fetchCategory(Long categoryId) {
		log.info("categoryId={}", categoryId);
		return categoryService.fetchCategory(categoryId);
	}

}
