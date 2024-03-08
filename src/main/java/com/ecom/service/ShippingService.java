package com.ecom.service;

import java.security.Principal;
import java.util.List;

import com.ecom.exceptions.ShippingException;
import com.ecom.exceptions.UsersException;
import com.ecom.model.Shipping;

public interface ShippingService {

	Shipping addShipping(Shipping shipping,Integer userId,Principal user) throws UsersException,ShippingException;
	
	Shipping updateShipping(Shipping shipping,Integer shippingId,Integer userId,Principal user) throws UsersException,ShippingException;
	
	Shipping getShippingById(Integer shippingId,Integer userId,Principal user) throws UsersException,ShippingException;
	
	Shipping deleteShipping(Integer shipping,Integer userId,Principal user) throws UsersException,ShippingException;
	
	List<Shipping> getAllShipping(Integer userId,Principal user) throws UsersException,ShippingException;
	
}
