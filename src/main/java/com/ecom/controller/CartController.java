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
import com.ecom.exceptions.CartException;
import com.ecom.exceptions.UsersException;
import com.ecom.model.Cart;
import com.ecom.service.CartService;



@RestController
@RequestMapping("/cart")
@CrossOrigin
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@PutMapping("updateCart/{userId}/{cartId}")
	ResponseEntity<GeneralResponse> updateCart(@RequestBody Cart cart,@PathVariable Integer userId,@PathVariable Integer cartId, Principal user) throws UsersException,CartException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("Cart updated by user Id : " + userId);
		generalResponse.setData(cartService.updateCart(cart, cartId, userId, user));
		return ResponseEntity.ok(generalResponse);
	}
	

	@PostMapping("addCart/{userId}")
	ResponseEntity<GeneralResponse> addCart(@RequestBody Cart cart,@PathVariable Integer userId, Principal user) throws UsersException,CartException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("Cart added by user Id : " + userId);
		generalResponse.setData(cartService.addCart(cart,  userId, user));
		return ResponseEntity.ok(generalResponse);
	}
	

	@DeleteMapping("deleteCart/{userId}/{cartId}")
	ResponseEntity<GeneralResponse> deleteCart(@PathVariable Integer userId,@PathVariable Integer cartId, Principal user) throws UsersException,CartException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("Cart deleted by user Id : " + userId);
		generalResponse.setData(cartService.deleteCart(cartId,  userId, user));
		return ResponseEntity.ok(generalResponse);
	}
	
	
	@GetMapping("getCartById/{userId}/{cartId}")
	ResponseEntity<GeneralResponse> getCartById(@PathVariable Integer userId, @PathVariable Integer cartId,Principal user) throws UsersException,CartException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("Cart found by user Id : " + userId);
		generalResponse.setData(cartService.getCartById(cartId,  userId, user));
		return ResponseEntity.ok(generalResponse);
	}
	
	@GetMapping("getCartByUserId/{userId}")
	ResponseEntity<GeneralResponse> getCartByUserId(@PathVariable Integer userId, Principal user) throws UsersException,CartException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("All itmes found in Cart by user Id : " + userId);
		generalResponse.setData(cartService.getCartByUserId(  userId, user));
		return ResponseEntity.ok(generalResponse);
	}

}
