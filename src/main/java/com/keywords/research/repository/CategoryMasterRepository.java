package com.keywords.research.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keywords.research.entity.Category;
import com.keywords.research.entity.SubCategory;

@Repository
public interface CategoryMasterRepository extends JpaRepository<Category,Integer>{

	List<Category> findBySubCategory(String name);

}
