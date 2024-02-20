package com.keywords.research.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keywords.research.entity.Category;
import com.keywords.research.entity.Keyword;
import com.keywords.research.entity.Type;

@Repository
public interface KeywordsRepository extends JpaRepository<Keyword, Long>{
	List<Keyword> findByType(Type type);
	List<Keyword> findByCategory(Category category);
//	Page<Keyword> findAll(Pageable pageable);
}
