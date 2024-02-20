package com.keywords.research.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keywords.research.entity.Segment;

@Repository
public interface SegmentsRepository extends JpaRepository<Segment, Integer>{

}
