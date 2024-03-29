package com.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.model.Cart;


public interface CartRepo extends JpaRepository<Cart, Integer> {
	
	public Cart  findByUsersId(Integer usersId);

}
