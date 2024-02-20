package com.keywords.research.service;

import com.keywords.research.entity.Keyword;
import com.keywords.research.exception.CustomException;
import com.keywords.research.exception.GenericResponseEntity;

public interface CompanyService {

	public GenericResponseEntity addCompanies(Long keywordId, Keyword keyword)throws CustomException;

//	public GenericResponseEntity deleteCompanies(Integer companyId);

	public GenericResponseEntity deleteCompanies(Long keywordId) throws CustomException;


}
