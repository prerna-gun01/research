package com.keywords.research.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keywords.research.entity.Segment;
import com.keywords.research.entity.SubSegments;

@Repository
public interface SegmentMasterRepository extends JpaRepository<Segment, Integer>{



//	List<Segment> findBySubSegment(SubSegments subSegments);

}
