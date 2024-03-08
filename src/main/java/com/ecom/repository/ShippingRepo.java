package com.ecom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.model.Shipping;

public interface ShippingRepo extends JpaRepository<Shipping, Integer> {

	public List<Shipping> findAllByUserId(Integer userId);

}
