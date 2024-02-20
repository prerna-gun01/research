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

import com.keywords.research.entity.Category;
import com.keywords.research.entity.Companies;
import com.keywords.research.entity.Keyword;
import com.keywords.research.entity.Segment;
import com.keywords.research.entity.SubCategory;
import com.keywords.research.entity.Type;
import com.keywords.research.exception.CustomException;
import com.keywords.research.exception.GenericResponseEntity;
import com.keywords.research.repository.CategoryRepository;
import com.keywords.research.repository.KeywordsRepository;
import com.keywords.research.repository.SubCategoryRepository;

@Service
public class KeywordServiceImpl implements KeywordService {

	@Autowired
	private KeywordsRepository keywordsRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private SubCategoryRepository subCategoryRepository;

	@Override
	public GenericResponseEntity addKeyword(Keyword keyword) {

		SubCategory subCategory = subCategoryRepository.save(keyword.getCategory().getSubCategory());
		Category category = categoryRepository.save(keyword.getCategory());
		category.setSubCategory(subCategory);
		keyword.setCategory(category);

		keywordsRepository.save(keyword);
		return new GenericResponseEntity(201, "Keyword has been generated successfully");
	}

	@Override
	public GenericResponseEntity updateKeyword(Long id, Keyword keyword) throws CustomException {
		Optional<Keyword> keyDB = keywordsRepository.findById(id);
		if (keyDB.isPresent()) {
			Keyword existingKeyword = keyDB.get();
			existingKeyword.setName(keyword.getName());
			existingKeyword.setDescription(keyword.getDescription());
			existingKeyword.setType(keyword.getType());
			existingKeyword.setVolume(keyword.getVolume());

			SubCategory subCategory = subCategoryRepository.save(keyword.getCategory().getSubCategory());
			Category category = categoryRepository.save(keyword.getCategory());
			category.setSubCategory(subCategory);
			existingKeyword.setCategory(category);

			List<Companies> compDB = keyword.getCompanies();
			System.out.println("compDB" + compDB);
			List<Companies> companyList = new ArrayList<>();
			for (Companies companies : compDB) {
				Companies keyCompanies = new Companies();
				keyCompanies.setName(companies.getName());
				companyList.add(keyCompanies);
			}
			existingKeyword.setCompanies(companyList);
			
			existingKeyword.getSegments().clear();
			existingKeyword.setSegments(keyword.getSegments());

			keywordsRepository.save(existingKeyword);
			return new GenericResponseEntity(200, "Keyword has been updated!");
		}
		throw new CustomException("Can't update as ID doesn't exist");
	}

	@Override
	public List<Keyword> getKeywordList() {
//		List<Keyword> list = keywordsRepository.findAll();
		return keywordsRepository.findAll();
	}

	@Override
	public Keyword getKeywordById(Long id) throws CustomException {
		Optional<Keyword> keywordById = keywordsRepository.findById(id);
		if (keywordById.isPresent()) {
			return keywordById.get();
		}
		throw new CustomException(id + " Id of keyword is not found");
	}

	@Override
	public List<Keyword> get(Type type) {
		List<Keyword> typeList = keywordsRepository.findByType(type);
			return typeList;
}

	

	@Override
	public List<Keyword> getKeywordListByCategory(String categoryName) {
		Category category = categoryRepository.findByCategoryName(categoryName);
		if(category == null) {
			throw new CustomException( categoryName+" categoryName doesn't exist.");
		}
		List<Keyword> keywordList = keywordsRepository.findByCategory(category);
		return keywordList;
	}

	@Override
	public GenericResponseEntity deleteKeywords(Long keywordId) {
		Optional<Keyword> keyId = keywordsRepository.findById(keywordId);
		if(keyId.isPresent()) {
			keywordsRepository.deleteById(keywordId);
			return new GenericResponseEntity(200, "Keyword deleted successfully");
		}
		throw new CustomException("Can't delete as ID doesn't exist");
	}
	
	@Override
	public Page<Keyword> getAllKeywords(int page, int size) {
		Pageable pageable = buildPagable(page, size);
		Page<Keyword> keyword = null;
		keyword = keywordsRepository.findAll(pageable);
		return keyword;
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
//	public Page<Segment> getAllSegments(int page, int size) {
//		Pageable pageable = buildPagable(page, size);
//		Page<Segment> segment = null;
//		segment = segmentMasterRepository.findAll(pageable);
//		return segment;
//	}
//	
//	private Pageable buildPagable(int page, int size) {
//		if (page < 0) {
//			page = 0;
//		}
//		if (size < 0 || size > 100) {
//			size = 25;
//		}
//
//		Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "id");
//		return pageable;
//	}

//	@Override
//	public ResponseEntity<Page<Keyword>> getKeywords(int page, int size) {
//		Page<Keyword> keyPage = keywordsRepository.findAll(PageRequest.of(page, size));
//		return ResponseEntity.ok(keyPage);
//	}

	
//	@Override
//	public List<Category> getCategoryNByName(String categoryName) {
//		Keyword category = categoryRepository.findByCategoryName(categoryName);
//		if(category == null) {
//			System.out.println("Error");
//		}
//		return categoryRepository.findByCategoryName(categoryName);
//	}

//	@Override
//	public List<Keyword> get(Category category) {
//		List<Keyword> categoryList = keywordsRepository.findByCategory(category);
//		return categoryList;
//	}

//	@Override
//	public List<Contract> fetchByQualityName(String qualityName, User user, Org org) {
////		List<Quality> qualitydb = qualityRepository.findAllByQualityNameAndUserId(qualityName, user.getId());
//		List<Quality> qualitydb = qualityRepository.findAllByQualityNameAndOrg(qualityName, org);
//		List<Contract> contract = new ArrayList<>();
//		contract.addAll(contractRepository.findByQualityIn(qualitydb));
//
//		return contract;
//	}
//	@Override
//	public Object getCategoryList(String categoryName) {
//		List<Category> categoryDB = categoryRepository.findAllByCategoryName(categoryName);
//		List<Keyword>  keyword = new ArrayList<>();
//		keyword.addAll(keywordsRepository.findByCategoryIn(categoryDB));
//		return keyword;
//	}
}
