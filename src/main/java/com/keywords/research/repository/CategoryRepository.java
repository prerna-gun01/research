package com.keywords.research.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.keywords.research.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

	Category findByCategoryName(String categoryName);

//	List<Category> findByCategoryName(String categoryName);

//	List<Category> findAllByCategoryName(String categoryName);

}
