package com.keywords.research.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.keywords.research.entity.Segment;
import com.keywords.research.exception.GenericResponseEntity;

public interface SegmentMasterService {

//	GenericResponseEntity addSegmentsMaster(Segment segments);

	public GenericResponseEntity addSegmentsMaster(Segment segments);

	public GenericResponseEntity updateSegmentsMaster(Integer id, Segment segment);

	public List<Segment> getSegmentList();

	public Page<Segment> getAllSegments(int page, int size);

//	public List<Segment> fetchBySubSegments(String name);


//	public List<Segment> getCategoryListBySubCategory(String name);

}
