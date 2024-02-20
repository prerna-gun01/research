package com.keywords.research.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keywords.research.entity.SubSegments;

@Repository
public interface SubSegmentMasterRepository extends JpaRepository<SubSegments, Integer>{

	static List<SubSegments> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

//	SubSegments findByName(String name);

}
