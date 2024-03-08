package com.ecom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.model.Address;


public interface AddressRepo extends JpaRepository<Address, Integer>{

	public List<Address> findAllAddressesByUsersId(Integer userId);
	
	public List<Address> findByUsersIdAndState(Integer userId,String state);
	
	public List<Address> findByUsersIdAndPin(Integer userId,Integer pin);

}