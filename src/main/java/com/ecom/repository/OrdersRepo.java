package com.ecom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.model.Orders;

public interface OrdersRepo extends JpaRepository<Orders, Integer>  {
	public List<Orders> findAllByUsersId(Integer userId);
}
