package com.ecom.service.Imp;

import java.security.Principal;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.exceptions.CartException;
import com.ecom.exceptions.UsersException;
import com.ecom.model.Cart;
import com.ecom.model.Users;
import com.ecom.repoHelper.UtilityHelper;
import com.ecom.repository.CartRepo;
import com.ecom.service.CartService;
import com.ecom.service.UsersService;


@Service
public class CartServiceImp implements CartService{
	
	@Autowired
	CartRepo cartRepo;
	
	@Autowired
	UtilityHelper utilityHelper;
	
	@Autowired
	UsersService usersService;

	@Override
	public Cart addCart(Cart cart, Integer userId, Principal user) throws UsersException, CartException {
		Users users = usersService.getUserById(userId, user);
		cart.setUsers(users);
		cartRepo.save(cart);
		return cart;
	}

	@Override
	public Cart updateCart(Cart cart, Integer cartId, Integer userId, Principal user)
			throws UsersException, CartException {
		Cart oldCart = getCartById(cartId, userId, user);
		BeanUtils.copyProperties(cart, oldCart, utilityHelper.getNullPropertyNames(cart));
		return cartRepo.save(oldCart);
	}

	@Override
	public Cart deleteCart(Integer cartId, Integer userId, Principal user) throws UsersException, CartException {
		Cart cart = cartRepo.findById(cartId).get();
		cartRepo.deleteById(cartId);
		return  cart;
	}

	@Override
	public Cart getCartById(Integer cartId, Integer userId, Principal user) throws UsersException, CartException {
		Cart cart = cartRepo.findById(cartId).get();
		return cart;
	}

	@Override
	public Cart getCartByUserId(Integer userId, Principal user) throws UsersException, CartException {
		Cart cart = cartRepo.findByUsersId(userId);
		return cart;
	}

}
