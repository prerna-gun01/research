package com.keywords.research.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keywords.research.entity.Companies;
import com.keywords.research.entity.Keyword;
import com.keywords.research.exception.CustomException;
import com.keywords.research.exception.GenericResponseEntity;
import com.keywords.research.repository.CompanyRepository;
import com.keywords.research.repository.KeywordsRepository;

@Service
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	private KeywordsRepository keywordsRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Override
	public GenericResponseEntity addCompanies(Long keywordId, Keyword keyword) throws CustomException{
		Optional<Keyword> keyDB = keywordsRepository.findById(keywordId);
		if(keyDB.isPresent()) {
			Keyword existingKeyword = keyDB.get();
			List<Companies> compDB = keyword.getCompanies();
			System.out.println("compDB"+compDB);
			List<Companies> companyList = new ArrayList<>();
			for(Companies companies : compDB) {
				Companies keyCompanies = new Companies();
				keyCompanies.setName(companies.getName());
				companyList.add(keyCompanies);
			}
			existingKeyword.setCompanies(companyList);
			keywordsRepository.save(existingKeyword);
			return new GenericResponseEntity(200, "Company of Keyword has been saved successfully");
		}
		throw new CustomException("Can't update as keyword doesn't exist");
	}
//	@Override
//	public GenericResponseEntity deleteEmployee(Long employeeId) throws CustomException{
//		Optional<Employee> employeeById = employeeRepository.findById(employeeId);
//		if(employeeById.isPresent()) {
//			employeeRepository.deleteById(employeeId);
//			return new GenericResponseEntity(200, "Employee deleted successfully");
//		}
//		else {
//		throw new CustomException("Can't delete as ID doesn't exist");
//		}
//	}
	@Override
	public GenericResponseEntity deleteCompanies(Long keywordId) throws CustomException {
		Optional<Keyword> keyDB = keywordsRepository.findById(keywordId);
		if(keyDB.isPresent()) {
			Keyword existingKeyword = keyDB.get();
			existingKeyword.getCompanies().clear();
//			companyRepository.deleteById(companyId);
//			keywordsRepository.deleteById(keywordId);
			keywordsRepository.save(existingKeyword);
			return new GenericResponseEntity(200, "Company of Keyword has been deleted successfully");
		}
		throw new CustomException("Can't delete as ID doesn't exist");
	}

//	@Override
//	public GenericResponseEntity deleteCompanies(Integer companyId) {
//		Optional<Companies> compDB = companyRepository.findById(companyId);
//		if(compDB.isPresent()) {
//			Companies companies = compDB.get();
//			companies.setKeyword(null);
//			companyRepository.delete(companies);
//		}
//		throw new CustomException("Can't delete as ID doesn't exist");
//	}

//	@Override
//	public GenericResponseEntity deleteCompanies(Long keywordId, Integer companyId) throws CustomException {
//		Optional<Keyword> keyDB = keywordsRepository.findById(keywordId);
//		if(keyDB.isPresent()) {
//			Optional<Companies> compDB = companyRepository.findById(companyId);
//			if(compDB.isPresent()) {
//				keyDB.getCompanies().remove(compDB);
//				System.out.println(" " + keyDB);
////				keyDB.get().remove(compDB);
//				keywordsRepository.save(keyDB);
//				System.out.println(" " + keyDB);
//			}
//			throw new CustomException("Can't delete as Company doesn't exist");
//		}
//		throw new CustomException("Can't delete as ID doesn't exist");
//	}

//	@Override
//	@Transactional
//	public GenericResponseEntity deleteCompanies(Long keywordId, Integer companyId) throws CustomException {
//		Optional<Keyword> keyDB = keywordsRepository.findById(keywordId);
//		if(keyDB.isPresent()) {
//			Optional<Companies> compDB = companyRepository.findById(companyId);
//			if(compDB.isPresent() && keyDB.get().getCompanies().contains(compDB.get())) {
//				keyDB.get().getCompanies().remove(compDB.get());
//				companyRepository.delete(compDB.get());
//			}
//		}
//		throw new CustomException("Can't delete as ID doesn't exist");
//	}

//	@Override
//	public GenericResponseEntity deleteCompanies(Long id) throws CustomException {
//		Optional<Keyword> keyDB = keywordsRepository.findById(id);
//		if(keyDB.isPresent()) {
//			Keyword existingKeyword = keyDB.get();
//			List<Companies> compDB = existingKeyword.getCompanies();
//			System.out.println("compDB"+compDB);
////			companyRepository.deleteAll(compDB);
//			
//			List<Companies> companyList = new ArrayList<>();
//			for(Companies companies : compDB) {
//				Companies keyCompanies = new Companies();
////				companyRepository.deleteAll(compDB);
//				keyCompanies.setName(companies.getName());
//				companyList.add(keyCompanies);
//			}
//			existingKeyword.setCompanies(companyList);
//			
//			
//			keywordsRepository.save(existingKeyword);
//			return new GenericResponseEntity(200, "Company deleted successfully");
//		}
//		throw new CustomException("Can't delete as ID doesn't exist");
//	}

	
	
}
