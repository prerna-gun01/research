package com.keywords.research.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Segment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<SubSegments> subSegments = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SubSegments> getSubSegments() {
		return subSegments;
	}

	public void setSubSegments(List<SubSegments> subSegments) {
		this.subSegments = subSegments;
	}

	public Segment(int id, String name, List<SubSegments> subSegments) {
		super();
		this.id = id;
		this.name = name;
		this.subSegments = subSegments;
	}

	public Segment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
