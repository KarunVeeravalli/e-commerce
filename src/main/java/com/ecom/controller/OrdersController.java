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
import com.ecom.exceptions.OrdersException;
import com.ecom.exceptions.UsersException;
import com.ecom.model.Orders;
import com.ecom.service.OrdersService;


@RestController
@RequestMapping("/orders")
@CrossOrigin
public class OrdersController {
	@Autowired
	OrdersService ordersService;
	
	@PutMapping("updateOrders/{userId}/{ordersId}")
	ResponseEntity<GeneralResponse> updateOrders(@RequestBody Orders orders,@PathVariable Integer userId,@PathVariable Integer ordersId, Principal user) throws UsersException,OrdersException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("Orders updated by user Id : " + userId);
		generalResponse.setData(ordersService.updateOrders( orders,ordersId, userId, user));
		return ResponseEntity.ok(generalResponse);
	}
	

	@PostMapping("addOrders/{userId}")
	ResponseEntity<GeneralResponse> addOrders(@RequestBody Orders orders,@PathVariable Integer userId, Principal user) throws UsersException,OrdersException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("Orders added by user Id : " + userId);
		generalResponse.setData(ordersService.addOrders(  orders,userId, user));
		return ResponseEntity.ok(generalResponse);
	}
	

	@DeleteMapping("deleteOrder/{userId}/{ordersId}")
	ResponseEntity<GeneralResponse> deleteOrder(@PathVariable Integer userId,@PathVariable Integer ordersId, Principal user) throws UsersException,OrdersException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("Orders deleted by user Id : " + userId);
		generalResponse.setData(ordersService.deleteOrder(ordersId,  userId, user));
		return ResponseEntity.ok(generalResponse);
	}
	
	
	@GetMapping("getOrderById/{userId}/{ordersId}")
	ResponseEntity<GeneralResponse> getOrderById(@PathVariable Integer userId, @PathVariable Integer ordersId,Principal user) throws UsersException,OrdersException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("Orders found by user Id : " + userId);
		generalResponse.setData(ordersService.getOrderById(ordersId,  userId, user));
		return ResponseEntity.ok(generalResponse);
	}
	
	@GetMapping("getAllOrdersByUser/{userId}")
	ResponseEntity<GeneralResponse> getAllOrdersByUser(@PathVariable Integer userId, Principal user) throws UsersException,OrdersException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("All Orders found by user Id : " + userId);
		generalResponse.setData(ordersService.getAllOrdersByUser(  userId, user));
		return ResponseEntity.ok(generalResponse);
	}
	
}
