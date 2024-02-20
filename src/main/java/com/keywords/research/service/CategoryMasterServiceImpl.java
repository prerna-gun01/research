package com.keywords.research.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.keywords.research.entity.Category;
import com.keywords.research.entity.SubCategory;
import com.keywords.research.exception.CustomException;
import com.keywords.research.exception.GenericResponseEntity;
import com.keywords.research.repository.CategoryMasterRepository;
import com.keywords.research.repository.SubCategoryMasterRepository;

@Service
public class CategoryMasterServiceImpl  implements CategoryMasterService{

	@Autowired
	private CategoryMasterRepository categoryMasterRepository;

	@Autowired
	private SubCategoryMasterRepository subCategoryMasterRepository;


	@Override
	public GenericResponseEntity addCategoriesForKeyword(Category category) {
	
		SubCategory subCategory = subCategoryMasterRepository.save(category.getSubCategory());
		category.setSubCategory(subCategory);
		categoryMasterRepository.save(category);
		return new GenericResponseEntity(201, "Category has been generated successfully");
	}

	@Override
	public List<Category> getCategoryList() {
		return categoryMasterRepository.findAll();
	}

	@Override
	public List<Category> getCategoryListBySubCategory(String name) {
//		SubCategory subCategory = subCategoryMasterRepository.findByName(name);
		if(name == null) {
			throw new CustomException( name+"  doesn't exist.");
		}
		List<Category> categoryList = categoryMasterRepository.findBySubCategory(name);
		return categoryList;
	}

	@Override
	public GenericResponseEntity updateCategory(Integer id, Category category) {
		Optional<Category> categoryDB = categoryMasterRepository.findById(id);
		if(categoryDB.isPresent()) {
			Category existingCategory = categoryDB.get();
			existingCategory.setCategoryName(category.getCategoryName());
			SubCategory subCategory = subCategoryMasterRepository.save(category.getSubCategory());
			existingCategory.setSubCategory(subCategory);
			
			categoryMasterRepository.save(existingCategory);
			return new GenericResponseEntity(200, "Category has been updated!");
		}
		throw new CustomException("Can't update as ID doesn't exist");
	}

	@Override
	public GenericResponseEntity deleteCategories(Integer id) {
		Optional<Category> categoryId = categoryMasterRepository.findById(id);
		if(categoryId.isPresent()) {
			throw new CustomException("Can't delete as Categories can not be deleted");
		}
		throw new CustomException("Can't delete as ID doesn't exist");
	}

	@Override
	public Page<Category> getAllCategories(int page, int size) {
		Pageable pageable = buildPagable(page, size);
		Page<Category> category = null;
		category = categoryMasterRepository.findAll(pageable);
		return category;
	}
	
	private Pageable buildPagable(int page, int size) {
		if (page < 0) {
			page = 0;
		}
		if (size < 0 || size > 100) {
			size = 25;
		}

		Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "id");
		return pageable;
	}
	
}
