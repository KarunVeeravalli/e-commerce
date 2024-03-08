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
import com.ecom.exceptions.PromotionsException;
import com.ecom.exceptions.UsersException;
import com.ecom.model.Promotions;
import com.ecom.service.PromotionsService;




@RestController
@RequestMapping("/promotions")
@CrossOrigin
public class PromotionsController {
	
	@Autowired
	PromotionsService promotionsService;
	
	@PutMapping("updatePromotion/{userId}/{promotionsId}")
	ResponseEntity<GeneralResponse> updatePromotion(@RequestBody Promotions promotions,@PathVariable Integer userId,@PathVariable Integer promotionsId, Principal user) throws UsersException,PromotionsException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("Promotions updated by user Id : " + userId);
		generalResponse.setData(promotionsService.updatePromotion( promotions,promotionsId, userId, user));
		return ResponseEntity.ok(generalResponse);
	}
	

	@PostMapping("addPromotion/{userId}")
	ResponseEntity<GeneralResponse> addPromotion(@RequestBody Promotions promotions,@PathVariable Integer userId, Principal user) throws UsersException,PromotionsException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("Promotions added by user Id : " + userId);
		generalResponse.setData(promotionsService.addPromotion(  promotions,userId, user));
		return ResponseEntity.ok(generalResponse);
	}
	

	@DeleteMapping("deletePromotion/{userId}/{promotionsId}")
	ResponseEntity<GeneralResponse> deletePromotion(@PathVariable Integer userId,@PathVariable Integer promotionsId, Principal user) throws UsersException,PromotionsException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("Promotions deleted by user Id : " + userId);
		generalResponse.setData(promotionsService.deletePromotion(promotionsId,  userId, user));
		return ResponseEntity.ok(generalResponse);
	}
	
	
	@GetMapping("getPromotionById/{userId}/{promotionsId}")
	ResponseEntity<GeneralResponse> getPromotionById(@PathVariable Integer userId, @PathVariable Integer promotionsId,Principal user) throws UsersException,PromotionsException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("Promotions found by user Id : " + userId);
		generalResponse.setData(promotionsService.getPromotionById(promotionsId,  userId, user));
		return ResponseEntity.ok(generalResponse);
	}
	
	@GetMapping("getAllPromotions/{userId}")
	ResponseEntity<GeneralResponse> getAllPromotions(@PathVariable Integer userId, Principal user) throws UsersException,PromotionsException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("All Promotions found updated by user Id : " + userId);
		generalResponse.setData(promotionsService.getAllPromotions(  userId, user));
		return ResponseEntity.ok(generalResponse);
	}
	


}
