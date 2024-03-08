package com.ecom.service;

import java.security.Principal;
import java.util.List;

import com.ecom.exceptions.ReviewsAndRatingsException;
import com.ecom.exceptions.UsersException;
import com.ecom.model.ReviewsAndRatings;

public interface ReviewsAndRatingsService {

	ReviewsAndRatings addReviewsAndRatings(ReviewsAndRatings reviewsAndRatings,Integer userId,Principal user) throws UsersException,ReviewsAndRatingsException;
	
	ReviewsAndRatings updateReviewsAndRatings(ReviewsAndRatings reviewsAndRatings,Integer reviewsAndRatingsId,Integer userId,Principal user) throws UsersException,ReviewsAndRatingsException;
	
	ReviewsAndRatings getReviewsAndRatingsById(Integer reviewsAndRatingsId,Integer userId,Principal user) throws UsersException,ReviewsAndRatingsException;
	
	ReviewsAndRatings deleteReviewsAndRatings(Integer reviewsAndRatingsId,Integer userId,Principal user) throws UsersException,ReviewsAndRatingsException;
	
	List<ReviewsAndRatings> getAllReviewsAndRatingsByProductId(Integer userId,Integer productId,Principal user) throws UsersException,ReviewsAndRatingsException;
	

}
