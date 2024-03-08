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
import com.ecom.exceptions.UsersException;
import com.ecom.model.Users;
import com.ecom.service.UsersService;



@RestController
@RequestMapping("/users")
@CrossOrigin
public class UsersController {
	

	@Autowired
	UsersService usersService;
	
	@PutMapping("updateUser/{userId}")
	ResponseEntity<GeneralResponse> updateUser(@RequestBody Users users,@PathVariable Integer userId, Principal user) throws UsersException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("User updated by user Id : " + userId);
		generalResponse.setData(usersService.updateUser( users, userId, user));
		return ResponseEntity.ok(generalResponse);
	}
	

	@PostMapping("addUser/{userId}")
	ResponseEntity<GeneralResponse> addUser(@RequestBody Users users,@PathVariable Integer userId, Principal user) throws UsersException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("User added by user Id : " + userId);
		generalResponse.setData(usersService.addUser(  users,userId, user));
		return ResponseEntity.ok(generalResponse);
	}
	

	@DeleteMapping("deleteUser/{userId}")
	ResponseEntity<GeneralResponse> deleteUser(@PathVariable Integer userId, Principal user) throws UsersException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("User deleted by user Id : " + userId);
		generalResponse.setData(usersService.deleteUser(  userId, user));
		return ResponseEntity.ok(generalResponse);
	}
	
	
	@GetMapping("getUserByEmail/{userId}/{mail}")
	ResponseEntity<GeneralResponse> getUserByEmail(@PathVariable String mail,@PathVariable Integer userId, Principal user) throws UsersException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("User found by mail : " + mail);
		generalResponse.setData(usersService.getUserByEmail(mail,userId, user));
		return ResponseEntity.ok(generalResponse);
	}
	
	@GetMapping("getUserById/{userId}")
	ResponseEntity<GeneralResponse> getUserById(@PathVariable Integer userId, Principal user) throws UsersException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("User found by user Id : " + userId);
		generalResponse.setData(usersService.getUserById(userId, user));
		return ResponseEntity.ok(generalResponse);
	}
	
	@GetMapping("getAllUsers/{userId}")
	ResponseEntity<GeneralResponse> getAllUsers(@PathVariable Integer userId, Principal user) throws UsersException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("All Users found by user Id : " + userId);
		generalResponse.setData(usersService.getAllUsers(  userId, user));
		return ResponseEntity.ok(generalResponse);
	}
	

}
