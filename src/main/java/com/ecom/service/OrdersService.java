package com.ecom.service;

import java.security.Principal;
import java.util.List;

import com.ecom.exceptions.OrdersException;
import com.ecom.exceptions.UsersException;
import com.ecom.model.Orders;

public interface OrdersService {
	
	Orders addOrders(Orders orders,Integer userId,Principal user) throws UsersException,OrdersException;
	
	Orders updateOrders(Orders orders,Integer orderId,Integer userId,Principal user) throws UsersException,OrdersException;
	
	Orders deleteOrder(Integer orderId,Integer userId,Principal user) throws UsersException,OrdersException;
	
	List<Orders> getAllOrdersByUser(Integer userId,Principal user) throws UsersException,OrdersException;
	
	Orders getOrderById(Integer orderId, Integer userId,Principal user) throws UsersException,OrdersException;
	
	

}
