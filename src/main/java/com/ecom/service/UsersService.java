package com.ecom.service;

import java.security.Principal;
import java.util.List;

import com.ecom.exceptions.UsersException;
import com.ecom.model.Users;

public interface UsersService {

	Users addUser(Users users,Integer userId,Principal user) throws UsersException;
	
	Users updateUser(Users users,Integer userId,Principal user) throws UsersException;
	
	Users getUserById(Integer userId,Principal user) throws UsersException;
	
	Users deleteUser(Integer userId,Principal user) throws UsersException;
	
	List<Users> getAllUsers(Integer userId,Principal user) throws UsersException;
	
	Users getUserByEmail(String mail,Integer userId,Principal user) throws UsersException;
	
}
