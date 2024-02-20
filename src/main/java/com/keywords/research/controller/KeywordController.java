package com.keywords.research.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.keywords.research.entity.Keyword;
import com.keywords.research.entity.Type;
import com.keywords.research.exception.CustomException;
import com.keywords.research.exception.GenericResponseEntity;
import com.keywords.research.service.CompanyService;
import com.keywords.research.service.KeywordService;
import com.keywords.research.service.SegmentService;

@RestController
@RequestMapping("/research")
public class KeywordController {

	@Autowired
	private KeywordService keywordService;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private SegmentService segmentService;
	
	@PostMapping("/addKeyword")
	public ResponseEntity<GenericResponseEntity> addKeyword(@RequestBody Keyword keyword){
		GenericResponseEntity generic = keywordService.addKeyword(keyword);
		return new ResponseEntity<>(generic, HttpStatus.CREATED);
	}
	
	@GetMapping("/getKeywordList")
	public List<Keyword> getKeywordList(){
		return keywordService.getKeywordList();
	}
	
	
	@GetMapping("/getKeywordById/{id}")
	public Keyword getKeywordById(@PathVariable("id") Long keywordId) throws CustomException{
		return keywordService.getKeywordById(keywordId);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<GenericResponseEntity> updateKeyword(@PathVariable("id") Long keywordId, 
													@RequestBody Keyword keyword) throws CustomException{
		GenericResponseEntity generic= keywordService.updateKeyword(keywordId, keyword);
		return new ResponseEntity<>(generic,HttpStatus.OK);
	}
	
	@PutMapping("/addCompanies/{id}")
	public ResponseEntity<GenericResponseEntity> addCompanies(@PathVariable("id") Long keywordId, @RequestBody Keyword keyword)throws CustomException{
		GenericResponseEntity generic = companyService.addCompanies(keywordId, keyword);
		return new ResponseEntity<>(generic,HttpStatus.OK);
	}
	
	@PutMapping("/addSegments/{id}")
	public ResponseEntity<GenericResponseEntity> addSegments(@PathVariable("id") Long keywordId, @RequestBody Keyword keyword)throws CustomException{
		GenericResponseEntity generic = segmentService.addSegments(keywordId,keyword);
		return new ResponseEntity<>(generic,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/deleteCompanies/{id}")
		public ResponseEntity<GenericResponseEntity> deleteCompanies(@PathVariable("id") Long keywordId) throws CustomException{
		GenericResponseEntity generic = companyService.deleteCompanies(keywordId);
		return new ResponseEntity<>(generic,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteSegments/{id}")
	public ResponseEntity<GenericResponseEntity> deleteSegments(@PathVariable("id") Long keywordId)throws CustomException{
		GenericResponseEntity generic = segmentService.deleteSegments(keywordId);
		return new ResponseEntity<>(generic,HttpStatus.OK);
	}
	
	@GetMapping("/Type")
	public ResponseEntity<List<Keyword>> getTypeList(@RequestParam(required = false)Type type)throws CustomException{
		List<Keyword> typeKeywords = new ArrayList<>();
		typeKeywords = keywordService.get(type);
		return ResponseEntity.ok(typeKeywords);
	}
	
	@GetMapping("/keyword/byCategory")
	public ResponseEntity<List<Keyword>> getKeywordListByCategory(@RequestParam(required = false)String categoryName){
		List<Keyword> categoryKeywords = new ArrayList<>();
			categoryKeywords = keywordService.getKeywordListByCategory(categoryName);
			return ResponseEntity.ok(categoryKeywords);
		
		}

	@DeleteMapping("/deleteKeywords/{id}")
	public ResponseEntity<GenericResponseEntity> deleteKeywords (@PathVariable("id") Long keywordId) throws CustomException{
		GenericResponseEntity generic = keywordService.deleteKeywords(keywordId);
		return new ResponseEntity<>(generic,HttpStatus.OK);
	}
	
	
	@GetMapping("/all-keywords")
	public Page<Keyword> getAllKeywords(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size){
		return keywordService.getAllKeywords(page, size);
	}
	
}
