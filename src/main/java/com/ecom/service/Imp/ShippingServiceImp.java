package com.ecom.service.Imp;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.exceptions.ShippingException;
import com.ecom.exceptions.UsersException;
import com.ecom.model.Shipping;
import com.ecom.repoHelper.UtilityHelper;
import com.ecom.repository.ShippingRepo;
import com.ecom.service.ShippingService;
import com.ecom.service.UsersService;


@Service
public class ShippingServiceImp implements ShippingService{
	
	@Autowired
	ShippingRepo shippingRepo;
	
	@Autowired
	UtilityHelper utilityHelper;
	
	@Autowired
	UsersService usersService;

	@Override
	public Shipping addShipping(Shipping shipping, Integer userId, Principal user)
			throws UsersException, ShippingException {
		return shippingRepo.save(shipping);
	}

	@Override
	public Shipping updateShipping(Shipping shipping, Integer shippingId, Integer userId, Principal user)
			throws UsersException, ShippingException {
		Shipping oldShipping = getShippingById(shippingId, userId, user);
		BeanUtils.copyProperties(shipping, oldShipping, utilityHelper.getNullPropertyNames(shipping));
		return shippingRepo.save(oldShipping);
	}

	@Override
	public Shipping getShippingById(Integer shippingId, Integer userId, Principal user)
			throws UsersException, ShippingException {
		return shippingRepo.findById(shippingId).get();
	}

	@Override
	public Shipping deleteShipping(Integer shippingId, Integer userId, Principal user)
			throws UsersException, ShippingException {
		Shipping shipping = getShippingById(shippingId, userId, user);
		shippingRepo.deleteById(shippingId);
		return shipping;
	}

	@Override
	public List<Shipping> getAllShipping(Integer userId, Principal user) throws UsersException, ShippingException {
		return shippingRepo.findAllByUserId(userId);
	}

}
