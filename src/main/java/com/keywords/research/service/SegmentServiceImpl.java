package com.keywords.research.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keywords.research.entity.Keyword;
import com.keywords.research.exception.CustomException;
import com.keywords.research.exception.GenericResponseEntity;
import com.keywords.research.repository.KeywordsRepository;
import com.keywords.research.repository.SegmentsRepository;

@Service
public class SegmentServiceImpl implements SegmentService{

	@Autowired
	private KeywordsRepository keywordsRepository;
	
	@Autowired
	private SegmentsRepository segmentsRepository;
	
	@Override
	public GenericResponseEntity addSegments(Long keywordId, Keyword keyword) throws CustomException{
		Optional<Keyword> keyDB = keywordsRepository.findById(keywordId);
		if(keyDB.isPresent()) {
		Keyword existingKeyword = keyDB.get();
		existingKeyword.getSegments().clear();
		existingKeyword.setSegments(keyword.getSegments());
		keywordsRepository.save(existingKeyword);
		return new GenericResponseEntity(200, "Segment of Keyword has been saved successfully");
		}
		throw new CustomException("Can't update as keyword doesn't exist");
	}

	@Override
	public GenericResponseEntity deleteSegments(Long keywordId)  throws CustomException{
		Optional<Keyword> keyDB = keywordsRepository.findById(keywordId);
		if(keyDB.isPresent()) {
			Keyword existingKeyword = keyDB.get();
			existingKeyword.getSegments().clear();
//			segmentsRepository.deleteAll();
//			keywordsRepository.deleteById(keywordId);
			keywordsRepository.save(existingKeyword);
			return new GenericResponseEntity(200, "Company of Keyword has been deletd successfully");
		}
		throw new CustomException("Can't delete as ID doesn't exist");
	}
}
