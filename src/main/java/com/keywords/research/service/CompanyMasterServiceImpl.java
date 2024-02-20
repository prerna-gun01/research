package com.keywords.research.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keywords.research.entity.Companies;
import com.keywords.research.exception.GenericResponseEntity;
import com.keywords.research.repository.CompanyMasterRepository;

@Service
public class CompanyMasterServiceImpl implements CompanyMasterService{

	@Autowired
	private CompanyMasterRepository companyMasterRepository;

//	@Override
//	public GenericResponseEntity addCompaniesForKeyword(Companies companies) {
//		System.out.println("welcome to");
//		companyMasterRepository.save(companies);
//		System.out.println("Dubai");
//		return new GenericResponseEntity(201, "Comany has been generated successfully");
//	}
}
