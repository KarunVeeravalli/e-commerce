package com.ecom.service.Imp;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.exceptions.ReviewsAndRatingsException;
import com.ecom.exceptions.UsersException;
import com.ecom.model.ReviewsAndRatings;
import com.ecom.repoHelper.UtilityHelper;
import com.ecom.repository.ReviewAndRatingsRepo;
import com.ecom.service.ReviewsAndRatingsService;
import com.ecom.service.UsersService;

@Service
public class ReviewsAndRatingsServiceImp implements ReviewsAndRatingsService{
	
	@Autowired
	ReviewAndRatingsRepo reviewAndRatingsRepo;
	
	@Autowired
	UtilityHelper utilityHelper;
	
	@Autowired
	UsersService usersService;

	@Override
	public ReviewsAndRatings addReviewsAndRatings(ReviewsAndRatings reviewsAndRatings, Integer userId, Principal user)
			throws UsersException, ReviewsAndRatingsException {
		return reviewAndRatingsRepo.save(reviewsAndRatings);
	}

	@Override
	public ReviewsAndRatings updateReviewsAndRatings(ReviewsAndRatings reviewsAndRatings, Integer reviewsAndRatingsId,
			Integer userId, Principal user) throws UsersException, ReviewsAndRatingsException {
		ReviewsAndRatings oldreReviewsAndRatings = getReviewsAndRatingsById(reviewsAndRatingsId, userId, user);
		BeanUtils.copyProperties(reviewsAndRatings, oldreReviewsAndRatings, utilityHelper.getNullPropertyNames(reviewsAndRatings));
		return reviewAndRatingsRepo.save(oldreReviewsAndRatings);
	}

	@Override
	public ReviewsAndRatings getReviewsAndRatingsById(Integer reviewsAndRatingsId, Integer userId, Principal user)
			throws UsersException, ReviewsAndRatingsException {
		return reviewAndRatingsRepo.findById(reviewsAndRatingsId).get();
	}

	@Override
	public ReviewsAndRatings deleteReviewsAndRatings(Integer reviewsAndRatingsId, Integer userId, Principal user)
			throws UsersException, ReviewsAndRatingsException {
		ReviewsAndRatings reviewsAndRatings = getReviewsAndRatingsById(reviewsAndRatingsId, userId, user);
		reviewAndRatingsRepo.deleteById(reviewsAndRatingsId);
		return reviewsAndRatings;
	}

	@Override
	public List<ReviewsAndRatings> getAllReviewsAndRatingsByProductId(Integer userId,Integer productId, Principal user)
			throws UsersException, ReviewsAndRatingsException {
		
		return reviewAndRatingsRepo.findAllByProductId(productId);
	}

}
