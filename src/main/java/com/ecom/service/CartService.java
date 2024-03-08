package com.ecom.service;

import java.security.Principal;

import com.ecom.exceptions.CartException;
import com.ecom.exceptions.UsersException;
import com.ecom.model.Cart;

public interface CartService {
	
	Cart addCart(Cart cart,Integer userId,Principal user) throws UsersException,CartException;
	
	Cart updateCart(Cart cart,Integer cartId,Integer userId,Principal user) throws UsersException,CartException;
	
	Cart deleteCart(Integer cartId,Integer userId,Principal user) throws UsersException,CartException;
	
	Cart getCartById(Integer cartId,Integer userId,Principal user) throws UsersException,CartException;
	
	Cart getCartByUserId(Integer userId,Principal user) throws UsersException,CartException;
}
