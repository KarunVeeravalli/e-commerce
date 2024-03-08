package com.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.model.Users;

public interface UsersRepo extends JpaRepository<Users, Integer>  {

	public Users findByEmail(String mail);

}
