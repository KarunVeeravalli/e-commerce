package com.ecom.service.Imp;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.exceptions.AddressException;
import com.ecom.exceptions.UsersException;
import com.ecom.model.Address;
import com.ecom.repoHelper.Constans;
import com.ecom.repoHelper.UtilityHelper;
import com.ecom.repository.AddressRepo;
import com.ecom.service.AddressService;
import com.ecom.service.UsersService;


@Service
public class AddressServiceImp implements AddressService{
	
	@Autowired
	AddressRepo addressRepo;
	
	@Autowired
	UsersService usersService;
	
	@Autowired
	UtilityHelper utilityHelper;

	@Override
	public Address addAddress(Address address, Integer userId, Principal user) throws UsersException, AddressException {
		
		address.setUsers(usersService.getUserById(userId, user));
		addressRepo.save(address);
		
		
		return address;
	}
	
	
	@Override
	public Address updateAddress(Address address, Integer addressId, Integer userId, Principal user)
			throws AddressException, UsersException {
		Address oldAddress = getAddressById(addressId, userId, user);
		BeanUtils.copyProperties(address, oldAddress, utilityHelper.getNullPropertyNames(address));
		return addressRepo.save(oldAddress);
		
	}

	@Override
	public Address deleteAddress(Integer addressId, Integer userId, Principal user)
			throws AddressException, UsersException {
		Address address = getAddressById(addressId, userId, user);
		addressRepo.deleteById(addressId);
		return address;
		
	}

	@Override
	public Address getAddressById(Integer addressId, Integer userId, Principal user)
			throws AddressException, UsersException {
		return addressRepo.findById(addressId).orElseThrow(() -> new UsersException(Constans.ADDRESS_NOT_FOUND+ addressId));
	}

	@Override
	public List<Address> getAllAddressByUserId(Integer userId, Principal user) throws AddressException, UsersException {
		return addressRepo.findAllAddressesByUsersId(userId);
	}

	@Override
	public List<Address> getAllAddressByStateAndUserId(Integer userId, String state, Principal user)
			throws AddressException, UsersException {
		
		return addressRepo.findByUsersIdAndState( userId,state);
	}

	@Override
	public List<Address> getAllAddressByPinAndUserId(Integer userId, Integer pin, Principal user)
			throws AddressException, UsersException {
		return addressRepo.findByUsersIdAndPin(userId, pin);
	}

}
