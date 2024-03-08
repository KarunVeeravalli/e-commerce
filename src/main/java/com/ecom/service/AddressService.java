package com.ecom.service;

import java.security.Principal;
import java.util.List;

import com.ecom.exceptions.AddressException;
import com.ecom.exceptions.UsersException;
import com.ecom.model.Address;

public interface AddressService {
	

	Address addAddress(Address address,Integer userId,Principal user) throws UsersException,AddressException;
	
	Address updateAddress(Address address, Integer addressId,Integer userId,Principal user) throws AddressException, UsersException;
	
	Address deleteAddress(Integer addressId,Integer userId,Principal user) throws AddressException,UsersException;
	
	Address getAddressById(Integer addressId,Integer userId,Principal user) throws AddressException,UsersException;
	
	List<Address> getAllAddressByUserId(Integer userId,Principal user) throws AddressException,UsersException;
	
	List<Address> getAllAddressByStateAndUserId(Integer userId,String state,Principal user) throws AddressException,UsersException;
	
	List<Address> getAllAddressByPinAndUserId(Integer userId,Integer pin,Principal user) throws AddressException,UsersException;

}
