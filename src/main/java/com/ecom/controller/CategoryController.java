package com.ecom.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.dto.GeneralResponse;
import com.ecom.exceptions.CategoryException;
import com.ecom.exceptions.UsersException;
import com.ecom.model.Category;
import com.ecom.service.Categoryservice;

@RestController
@RequestMapping("/category")
@CrossOrigin
public class CategoryController {
	@Autowired
	Categoryservice categoryservice;
	
	@PutMapping("updateCategory/{userId}/{categoryId}")
	ResponseEntity<GeneralResponse> updateCategory(@RequestBody Category category,@PathVariable Integer userId,@PathVariable Integer categoryId, Principal user) throws UsersException,CategoryException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("Category updated by user Id : " + userId);
		generalResponse.setData(categoryservice.updateCategory(category, categoryId, userId, user));
		return ResponseEntity.ok(generalResponse);
	}
	

	@PostMapping("addCart/{userId}")
	ResponseEntity<GeneralResponse> addCart(@RequestBody Category category,@PathVariable Integer userId, Principal user) throws UsersException,CategoryException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("Category added by user Id : " + userId);
		generalResponse.setData(categoryservice.addCategory(category,  userId, user));
		return ResponseEntity.ok(generalResponse);
	}
	

	@DeleteMapping("deleteCategory/{userId}/{categoryId}")
	ResponseEntity<GeneralResponse> deleteCart(@PathVariable Integer userId,@PathVariable Integer categoryId, Principal user) throws UsersException,CategoryException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("Category deleted by user Id : " + userId);
		generalResponse.setData(categoryservice.deleteCategory(categoryId,  userId, user));
		return ResponseEntity.ok(generalResponse);
	}
	
	
	@GetMapping("getCategoryById/{userId}/{categoryId}")
	ResponseEntity<GeneralResponse> getCategoryById(@PathVariable Integer userId, @PathVariable Integer categoryId,Principal user) throws UsersException,CategoryException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("Category found by user Id : " + userId);
		generalResponse.setData(categoryservice.getCategoryById(categoryId,  userId, user));
		return ResponseEntity.ok(generalResponse);
	}
	
	@GetMapping("getAllCategories/{userId}")
	ResponseEntity<GeneralResponse> getAllCategories(@PathVariable Integer userId, Principal user) throws UsersException,CategoryException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("All Categories found  by user Id : " + userId);
		generalResponse.setData(categoryservice.getAllCategories(  userId, user));
		return ResponseEntity.ok(generalResponse);
	}
	

}
