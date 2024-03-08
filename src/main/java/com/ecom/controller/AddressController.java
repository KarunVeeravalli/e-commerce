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
import com.ecom.exceptions.AddressException;
import com.ecom.exceptions.UsersException;
import com.ecom.model.Address;
import com.ecom.service.AddressService;

@RestController
@RequestMapping("/address")
@CrossOrigin
public class AddressController {
	
	@Autowired
	AddressService addressService;
	
	@PostMapping("/addAddress/{userId}")
	ResponseEntity<GeneralResponse> addAddress(@PathVariable Integer userId,@RequestBody Address address,Principal user) throws UsersException,AddressException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("Address added by user Id : " + userId);
		generalResponse.setData(addressService.addAddress(address,userId,user));
		return ResponseEntity.ok(generalResponse);
	}
	
	@PutMapping("updateAddress/{userId}/{addressId}")
	ResponseEntity<GeneralResponse> updateAddress(@RequestBody Address address,@PathVariable Integer userId,@PathVariable Integer addressId, Principal user) throws UsersException,AddressException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("Address updated by user Id : " + userId);
		generalResponse.setData(addressService.updateAddress(address, addressId, userId, user));
		return ResponseEntity.ok(generalResponse);
	}
	
	
	@DeleteMapping("deleteAddress/{userId}/{addressId}")
	ResponseEntity<GeneralResponse> deleteAddress(@PathVariable Integer userId,@PathVariable Integer addressId, Principal user) throws UsersException,AddressException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("Address deleted by user Id : " + userId);
		generalResponse.setData(addressService.deleteAddress( addressId, userId, user));
		return ResponseEntity.ok(generalResponse);
	}
	
	
	@GetMapping("getAddressById/{userId}/{addressId}")
	ResponseEntity<GeneralResponse> getAddressById(@PathVariable Integer userId,@PathVariable Integer addressId, Principal user) throws UsersException,AddressException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("Address found by user Id : " + userId);
		generalResponse.setData(addressService.getAddressById( addressId, userId, user));
		return ResponseEntity.ok(generalResponse);
	}
	
	@GetMapping("getAllAddressByUserId/{userId}")
	ResponseEntity<GeneralResponse> getAllAddressByUserId(@PathVariable Integer userId, Principal user) throws UsersException,AddressException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("All Address found by user Id : " + userId);
		generalResponse.setData(addressService.getAllAddressByUserId(  userId, user));
		return ResponseEntity.ok(generalResponse);
	}
	
	
	@GetMapping("getAllAddressByStateAndUserId/{userId}/{state}")
	ResponseEntity<GeneralResponse> getAllAddressByStateAndUserId(@PathVariable Integer userId,@PathVariable String state, Principal user) throws UsersException,AddressException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("All Address found by state of user Id : " + userId);
		generalResponse.setData(addressService.getAllAddressByStateAndUserId(  userId,state, user));
		return ResponseEntity.ok(generalResponse);
	}
	
	@GetMapping("getAllAddressByPinAndUserId/{userId}/{pin}")
	ResponseEntity<GeneralResponse> getAllAddressByPinAndUserId(@PathVariable Integer userId,@PathVariable Integer pin, Principal user) throws UsersException,AddressException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("All Address found by pin and user Id : " + userId);
		generalResponse.setData(addressService.getAllAddressByPinAndUserId(  userId,pin, user));
		return ResponseEntity.ok(generalResponse);
	}
	

}



