package com.keywords.research.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.keywords.research.entity.Segment;
import com.keywords.research.entity.SubSegments;
import com.keywords.research.exception.CustomException;
import com.keywords.research.exception.GenericResponseEntity;
import com.keywords.research.repository.SegmentMasterRepository;
import com.keywords.research.repository.SubSegmentMasterRepository;

@Service
public class SegmentMasterServiceImpl implements SegmentMasterService{

	@Autowired
	private SegmentMasterRepository segmentMasterRepository;
	
//	@Autowired
//	private SubSegmentMasterRepository subSegmentMasterRepository;
//	
	@Override
	public GenericResponseEntity addSegmentsMaster(Segment segments) {
		segmentMasterRepository.save(segments);
		return new GenericResponseEntity(201, "Segments has been generated successfully");
	}

	@Override
	public GenericResponseEntity updateSegmentsMaster(Integer id, Segment segment) {
		Optional<Segment> segDB = segmentMasterRepository.findById(id);
		if(segDB.isPresent()) {
			Segment segment2 = segDB.get();
			segment2.setName(segment.getName());

			segment2.getSubSegments().clear();
			segment2.getSubSegments().addAll(segment.getSubSegments());
			
			segmentMasterRepository.save(segment2);
			return new GenericResponseEntity(200, "Keyword has been updated!");
		}
		throw new CustomException("Can't update as ID doesn't exist");
	}

	@Override
	public List<Segment> getSegmentList() {
		return segmentMasterRepository.findAll();
	}

	@Override
	public Page<Segment> getAllSegments(int page, int size) {
		Pageable pageable = buildPagable(page, size);
		Page<Segment> segment = null;
		segment = segmentMasterRepository.findAll(pageable);
		return segment;
	}
	
	private Pageable buildPagable(int page, int size) {
		if (page < 0) {
			page = 0;
		}
		if (size < 0 || size > 100) {
			size = 25;
		}

		Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "id");
		return pageable;
	}

	
	
	
//	@Override
//	public List<Contract> fetchByAccountName(String accountName, User user, Org org) {
////		
//		List<AccountMaster> accountMasterdb = accountMasterRepository.findByAccountNameAndOrg(accountName, org);
//		List<Contract> contract = new ArrayList<>();
//		contract.addAll(contractRepository.findByAccountMasterIn(accountMasterdb));
//
//		return contract;
//	}

	
	
	
//	@Override
//	public List<Category> getCategoryListBySubCategory(String name) {
//		SubCategory subCategory = subCategoryMasterRepository.findByName(name);
//		if(subCategory == null) {
//			throw new CustomException( name+"  doesn't exist.");
//		}
//		List<Category> categoryList = categoryMasterRepository.findBySubCategory(subCategory);
//		return categoryList;
//	}

//	@Override
//	public List<Segment> getCategoryListBySubCategory(String name) {
//		SubSegments subSegments = subSegmentMasterRepository.findByName(name);
//		if(subSegments == null) {
//			throw new CustomException( name+"  doesn't exist.");
//		}
//		List<Segment> segmentList = segmentMasterRepository.findBySubSegment(subSegments);
//		return segmentList;
//	}
}
