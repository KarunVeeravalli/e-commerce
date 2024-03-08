package com.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.model.Promotions;

public interface PromotionsRepo extends JpaRepository<Promotions, Integer>  {

}
