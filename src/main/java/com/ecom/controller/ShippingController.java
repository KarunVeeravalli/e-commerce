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
import com.ecom.exceptions.ShippingException;
import com.ecom.exceptions.UsersException;
import com.ecom.model.Shipping;
import com.ecom.service.ShippingService;



@RestController
@RequestMapping("/shipping")
@CrossOrigin
public class ShippingController {

	@Autowired
	ShippingService shippingService;
	
	@PutMapping("updateShipping/{userId}/{shippingId}")
	ResponseEntity<GeneralResponse> updateShipping(@RequestBody Shipping shipping,@PathVariable Integer userId,@PathVariable Integer shippingId, Principal user) throws UsersException,ShippingException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("Shipping updated by user Id : " + userId);
		generalResponse.setData(shippingService.updateShipping( shipping,shippingId, userId, user));
		return ResponseEntity.ok(generalResponse);
	}
	

	@PostMapping("addShipping/{userId}")
	ResponseEntity<GeneralResponse> addShipping(@RequestBody Shipping shipping,@PathVariable Integer userId, Principal user) throws UsersException,ShippingException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("Shipping added by user Id : " + userId);
		generalResponse.setData(shippingService.addShipping(  shipping,userId, user));
		return ResponseEntity.ok(generalResponse);
	}
	

	@DeleteMapping("deleteShipping/{userId}/{shippingId}")
	ResponseEntity<GeneralResponse> deleteShipping(@PathVariable Integer userId,@PathVariable Integer shippingId, Principal user) throws UsersException,ShippingException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("Shipping deleted by user Id : " + userId);
		generalResponse.setData(shippingService.deleteShipping(shippingId,  userId, user));
		return ResponseEntity.ok(generalResponse);
	}
	
	
	@GetMapping("getShippingById/{userId}/{shippingId}")
	ResponseEntity<GeneralResponse> getShippingById(@PathVariable Integer userId, @PathVariable Integer shippingId,Principal user) throws UsersException,ShippingException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("Shipping found by user Id : " + userId);
		generalResponse.setData(shippingService.getShippingById(shippingId,  userId, user));
		return ResponseEntity.ok(generalResponse);
	}
	
	@GetMapping("getAllShipping/{userId}")
	ResponseEntity<GeneralResponse> getAllShipping(@PathVariable Integer userId, Principal user) throws UsersException,ShippingException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("All Shipping found by user Id : " + userId);
		generalResponse.setData(shippingService.getAllShipping(  userId, user));
		return ResponseEntity.ok(generalResponse);
	}
	
}
