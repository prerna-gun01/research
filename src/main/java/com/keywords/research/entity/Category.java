package com.keywords.research.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
//	@NotEmpty
//	@NotNull
	private String categoryName;
	
	@OneToOne(orphanRemoval = true)
	private SubCategory subCategory;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	
	
//	@OneToOne
//	private Keyword keyword;
//	
//	public Keyword getKeyword() {
//		return keyword;
//	}
//
//	public void setKeyword(Keyword keyword) {
//		this.keyword = keyword;
//	}
}
