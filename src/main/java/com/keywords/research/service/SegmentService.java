package com.keywords.research.service;

import com.keywords.research.entity.Keyword;
import com.keywords.research.exception.CustomException;
import com.keywords.research.exception.GenericResponseEntity;

public interface SegmentService {

	public GenericResponseEntity addSegments(Long keywordId, Keyword keyword) throws CustomException;

	public GenericResponseEntity deleteSegments(Long keywordId) throws CustomException;

}
