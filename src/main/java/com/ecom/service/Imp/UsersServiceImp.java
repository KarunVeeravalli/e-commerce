package com.ecom.service.Imp;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.exceptions.UsersException;
import com.ecom.model.Users;
import com.ecom.repoHelper.UtilityHelper;
import com.ecom.repository.UsersRepo;
import com.ecom.service.UsersService;

@Service
public class UsersServiceImp implements UsersService{
	
	@Autowired
	UtilityHelper utilityHelper;
	
	@Autowired
	UsersRepo usersRepo;

	@Override
	public Users addUser(Users users, Integer userId, Principal user) throws UsersException {
		return usersRepo.save(users);
	}

	@Override
	public Users updateUser(Users users, Integer userId, Principal user) throws UsersException {
		Users oldUsers = getUserById(userId, user);
		BeanUtils.copyProperties(users, oldUsers, utilityHelper.getNullPropertyNames(users));
		
		return usersRepo.save(oldUsers);
	}

	@Override
	public Users getUserById(Integer userId, Principal user) throws UsersException {
		
		return usersRepo.findById(userId).get();
	}

	@Override
	public Users deleteUser(Integer userId, Principal user) throws UsersException {
		Users users = getUserByEmail(null, userId, user);
		usersRepo.deleteById(userId);
		return users;
	}

	@Override
	public List<Users> getAllUsers(Integer userId, Principal user) throws UsersException {
		return usersRepo.findAll();
	}

	@Override
	public Users getUserByEmail(String mail, Integer userId, Principal user) throws UsersException {
		return usersRepo.findByEmail(mail);
	}

}
