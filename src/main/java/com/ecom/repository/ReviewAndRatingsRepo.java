package com.ecom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.model.ReviewsAndRatings;

public interface ReviewAndRatingsRepo  extends JpaRepository<ReviewsAndRatings, Integer> {
	public List<ReviewsAndRatings> findAllByProductId(Integer productId);
}
