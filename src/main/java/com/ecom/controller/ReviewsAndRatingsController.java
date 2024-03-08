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
import com.ecom.exceptions.ReviewsAndRatingsException;
import com.ecom.exceptions.UsersException;
import com.ecom.model.ReviewsAndRatings;
import com.ecom.service.ReviewsAndRatingsService;




@RestController
@RequestMapping("/reviewsAndRatings")
@CrossOrigin
public class ReviewsAndRatingsController {
	

	@Autowired
	ReviewsAndRatingsService reviewsAndRatingsService;
	
	@PutMapping("updateReviewsAndRatings/{userId}/{reviewsAndRatingsId}")
	ResponseEntity<GeneralResponse> updateReviewsAndRatings(@RequestBody ReviewsAndRatings reviewsAndRatings,@PathVariable Integer userId,@PathVariable Integer reviewsAndRatingsId, Principal user) throws UsersException,ReviewsAndRatingsException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("ReviewsAndRatings updated by user Id : " + userId);
		generalResponse.setData(reviewsAndRatingsService.updateReviewsAndRatings( reviewsAndRatings,reviewsAndRatingsId, userId, user));
		return ResponseEntity.ok(generalResponse);
	}
	

	@PostMapping("addReviewsAndRatings/{userId}")
	ResponseEntity<GeneralResponse> addReviewsAndRatings(@RequestBody ReviewsAndRatings reviewsAndRatings,@PathVariable Integer userId, Principal user) throws UsersException,ReviewsAndRatingsException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("ReviewsAndRatings added by user Id : " + userId);
		generalResponse.setData(reviewsAndRatingsService.addReviewsAndRatings(  reviewsAndRatings,userId, user));
		return ResponseEntity.ok(generalResponse);
	}
	

	@DeleteMapping("deleteReviewsAndRatings/{userId}/{reviewsAndRatingsId}")
	ResponseEntity<GeneralResponse> deleteReviewsAndRatings(@PathVariable Integer userId,@PathVariable Integer reviewsAndRatingsId, Principal user) throws UsersException,ReviewsAndRatingsException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("ReviewsAndRatings deleted by user Id : " + userId);
		generalResponse.setData(reviewsAndRatingsService.deleteReviewsAndRatings(reviewsAndRatingsId,  userId, user));
		return ResponseEntity.ok(generalResponse);
	}
	
	
	@GetMapping("getReviewsAndRatingsById/{userId}/{reviewsAndRatingsId}")
	ResponseEntity<GeneralResponse> getReviewsAndRatingsById(@PathVariable Integer userId, @PathVariable Integer reviewsAndRatingsId,Principal user) throws UsersException,ReviewsAndRatingsException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("ReviewsAndRatings found by user Id : " + userId);
		generalResponse.setData(reviewsAndRatingsService.getReviewsAndRatingsById(reviewsAndRatingsId,  userId, user));
		return ResponseEntity.ok(generalResponse);
	}
	
	@GetMapping("getAllReviewsAndRatingsByProductId/{userId}/{productId}")
	ResponseEntity<GeneralResponse> getAllReviewsAndRatingsByProductId(@PathVariable Integer userId,@PathVariable Integer productId, Principal user) throws UsersException,ReviewsAndRatingsException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("All ReviewsAndRatings found by user Id : " + userId);
		generalResponse.setData(reviewsAndRatingsService.getAllReviewsAndRatingsByProductId(  userId,productId ,user));
		return ResponseEntity.ok(generalResponse);
	}
	


}
