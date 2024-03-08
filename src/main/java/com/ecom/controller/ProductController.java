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
import com.ecom.exceptions.ProductException;
import com.ecom.exceptions.UsersException;
import com.ecom.model.Product;
import com.ecom.service.ProductService;



@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PutMapping("updateProduct/{userId}/{productId}")
	ResponseEntity<GeneralResponse> updateProduct(@RequestBody Product product,@PathVariable Integer userId,@PathVariable Integer productId, Principal user) throws UsersException,ProductException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("Product updated by user Id : " + userId);
		generalResponse.setData(productService.updateProduct( product,productId, userId, user));
		return ResponseEntity.ok(generalResponse);
	}
	

	@PostMapping("addProduct/{userId}")
	ResponseEntity<GeneralResponse> addProduct(@RequestBody Product product,@PathVariable Integer userId, Principal user) throws UsersException,ProductException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("Product added by user Id : " + userId);
		generalResponse.setData(productService.addProduct(  product,userId, user));
		return ResponseEntity.ok(generalResponse);
	}
	

	@DeleteMapping("deleteProduct/{userId}/{productId}")
	ResponseEntity<GeneralResponse> deleteProduct(@PathVariable Integer userId,@PathVariable Integer productId, Principal user) throws UsersException,ProductException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("Product deleted by user Id : " + userId);
		generalResponse.setData(productService.deleteProduct(productId,  userId, user));
		return ResponseEntity.ok(generalResponse);
	}
	
	
	@GetMapping("getProductById/{userId}/{productId}")
	ResponseEntity<GeneralResponse> getProductById(@PathVariable Integer userId, @PathVariable Integer productId,Principal user) throws UsersException,ProductException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("Product found by user Id : " + userId);
		generalResponse.setData(productService.getProductById(productId,  userId, user));
		return ResponseEntity.ok(generalResponse);
	}
	
	@GetMapping("getAllProducts/{userId}")
	ResponseEntity<GeneralResponse> getAllProducts(@PathVariable Integer userId, Principal user) throws UsersException,ProductException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("All Product found by user Id : " + userId);
		generalResponse.setData(productService.getAllProducts(  userId, user));
		return ResponseEntity.ok(generalResponse);
	}
	

}
