package com.keywords.research.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Keyword {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long keywordId;
	
	@NotEmpty(message = "keyword name can't be empty")
	@NotNull(message = "keyword can't be null")
	private String name;
	
	@NotEmpty
	@NotNull
	private String description;
	
	
	@Enumerated(EnumType.STRING)
	private Type type;

	
	@Enumerated(EnumType.STRING)
	private Volume volume;


	@OneToOne
	private Category category;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Companies> companies = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Segment> segments = new ArrayList<>();
	
	public List<Segment> getSegments() {
		return segments;
	}

	public void setSegments(List<Segment> segments) {
		this.segments = segments;
	}

	public List<Companies> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Companies> companies) {
		this.companies = companies;
	}

	public long getKeywordId() {
		return keywordId;
	}

	public void setKeywordId(long keywordId) {
		this.keywordId = keywordId;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Volume getVolume() {
		return volume;
	}

	public void setVolume(Volume volume) {
		this.volume = volume;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
