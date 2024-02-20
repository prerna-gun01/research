package com.keywords.research.masterTable;

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

import com.keywords.research.entity.Category;
import com.keywords.research.entity.Segment;
import com.keywords.research.exception.CustomException;
import com.keywords.research.exception.GenericResponseEntity;
import com.keywords.research.service.CategoryMasterService;
import com.keywords.research.service.SegmentMasterService;

@RestController
@RequestMapping("/master")
public class MasterTableController {

	@Autowired
	private CategoryMasterService categoryMasterService;
	
//	@Autowired
//	private SubCategoryMasterService subCategoryMasterService;
	
	@Autowired
	private SegmentMasterService segmentMasterService;
	
	@PostMapping("/addCategoriesForKeyword")
	public ResponseEntity<GenericResponseEntity> addCategoriesForKeyword(@RequestBody Category category){
		GenericResponseEntity generic =  categoryMasterService.addCategoriesForKeyword(category);
		return new ResponseEntity<>(generic,HttpStatus.CREATED);
	}
	
	@GetMapping("/getCategoryListForMaster")
	public List<Category> getCategoryList(){
		return categoryMasterService.getCategoryList();
	}
	
	@GetMapping("/category/bysubCategory")
	public ResponseEntity<List<Category>> getCategoryListBySubCategory(@RequestParam(required = false) String name){
		List<Category> subCategoryList = new ArrayList<>();
		subCategoryList = categoryMasterService.getCategoryListBySubCategory(name);
		return ResponseEntity.ok(subCategoryList);
	}

	@PutMapping("/updateCategory/{id}")
	public ResponseEntity<GenericResponseEntity> updateCategory(@PathVariable Integer id, @RequestBody Category category){
		GenericResponseEntity generic = categoryMasterService.updateCategory(id, category);
		return new ResponseEntity<>(generic,HttpStatus.OK);
	}
	

	
	
	@DeleteMapping("/deleteCategories/{id}")
	public ResponseEntity<GenericResponseEntity> deleteCategories(@PathVariable Integer id) throws CustomException{
		GenericResponseEntity generic = categoryMasterService.deleteCategories(id);
		return new ResponseEntity<>(generic,HttpStatus.OK);
	}
	
	@PostMapping("/addSegmentsMaster")
	public ResponseEntity<GenericResponseEntity> addSegmentsMaster(@RequestBody Segment segments){
		GenericResponseEntity generic = segmentMasterService.addSegmentsMaster(segments);
		return new ResponseEntity<>(generic,HttpStatus.CREATED);
	}
	
	@PutMapping("/updateSegmentsMaster/{id}")
	public ResponseEntity<GenericResponseEntity> updateSegmentsMaster(@PathVariable Integer id, @RequestBody Segment segment){
		GenericResponseEntity generic = segmentMasterService.updateSegmentsMaster(id, segment);
		return new ResponseEntity<>(generic,HttpStatus.CREATED);
	}
	
	@GetMapping("/getSegmentListForMaster")
	public List<Segment> getSegmentList(){
		return segmentMasterService.getSegmentList();
	}
	
	@GetMapping("/all-categories")
	public Page<Category> getAllCategories(	@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size){
		return categoryMasterService.getAllCategories(page, size);
	}
	
	@GetMapping("/all-segments")
	public Page<Segment> getAllSegments(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size){
		return segmentMasterService.getAllSegments(page, size);
	}
	
	
	
//	@GetMapping("/segment/bysubSegment")
//	public ResponseEntity<List<Segment>> getSegmentListBySubSegment(@RequestParam(required = false) String name){
//		List<Segment> subSegmentList = new ArrayList<>();
//		subSegmentList = segmentMasterService.getCategoryListBySubCategory(name);
//		return ResponseEntity.ok(subSegmentList);
//	}
	
}
