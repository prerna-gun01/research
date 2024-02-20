package com.keywords.research.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Companies {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int companyId;
	private String name;
	
//	@ManyToOne
//	private Keyword keyword;
//	
//	public Keyword getKeyword() {
//		return keyword;
//	}
//	public void setKeyword(Keyword keyword) {
//		this.keyword = keyword;
//	}
	
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Companies() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
