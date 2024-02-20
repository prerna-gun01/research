package com.keywords.research.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.keywords.research.entity.Category;
import com.keywords.research.exception.GenericResponseEntity;

public interface CategoryMasterService {

	public GenericResponseEntity addCategoriesForKeyword(Category category);

	

	public List<Category> getCategoryList();

	public List<Category> getCategoryListBySubCategory(String name);

//	public GenericResponseEntity deleteCompanies(Integer id);

	public GenericResponseEntity updateCategory(Integer id, Category category);

	public GenericResponseEntity deleteCategories(Integer id);

	public Page<Category> getAllCategories(int page, int size);

}
