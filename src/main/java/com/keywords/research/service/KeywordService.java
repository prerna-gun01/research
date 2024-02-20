package com.keywords.research.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.keywords.research.entity.Keyword;
import com.keywords.research.entity.Type;
import com.keywords.research.exception.CustomException;
import com.keywords.research.exception.GenericResponseEntity;

public interface KeywordService {

	public GenericResponseEntity addKeyword(Keyword keyword);

	public List<Keyword> getKeywordList();

	public Keyword getKeywordById(Long id) throws CustomException;

	public GenericResponseEntity updateKeyword(Long id, Keyword keyword) ;

	public List<Keyword> get(Type type)throws CustomException;

	public List<Keyword> getKeywordListByCategory(String categoryName)throws CustomException;

	public GenericResponseEntity deleteKeywords(Long keywordId);

	public Page<Keyword> getAllKeywords(int page, int size);

//	public Page<Keyword> getAllKeywords(int page, int size);

//	public ResponseEntity<Page<Keyword>> getKeywords(int page, int size);

	

}
