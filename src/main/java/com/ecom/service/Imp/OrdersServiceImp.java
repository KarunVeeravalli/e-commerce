package com.ecom.service.Imp;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.exceptions.OrdersException;
import com.ecom.exceptions.UsersException;
import com.ecom.model.Orders;
import com.ecom.model.Users;
import com.ecom.repoHelper.UtilityHelper;
import com.ecom.repository.OrdersRepo;
import com.ecom.service.OrdersService;
import com.ecom.service.UsersService;


@Service
public class OrdersServiceImp implements OrdersService {
	
	@Autowired
	OrdersRepo ordersRepo;
	
	@Autowired
	UtilityHelper utilityHelper;
	
	@Autowired
	UsersService usersService;

	@Override
	public Orders addOrders(Orders orders, Integer userId, Principal user) throws UsersException, OrdersException {
		Users users = usersService.getUserById(userId, user);
		orders.setUsers(users);
		return ordersRepo.save(orders);
	}

	@Override
	public Orders updateOrders(Orders orders,Integer orderId, Integer userId, Principal user) throws UsersException, OrdersException {
		Orders oldOrders = getOrderById(orderId, userId, user);
		BeanUtils.copyProperties(orders, oldOrders, utilityHelper.getNullPropertyNames(orders));
		return ordersRepo.save(oldOrders);
	}

	@Override
	public Orders deleteOrder(Integer orderId, Integer userId, Principal user) throws UsersException, OrdersException {
		Orders orders = getOrderById(orderId, userId, user);
		ordersRepo.deleteById(orderId);
		return orders;
	}

	@Override
	public List<Orders> getAllOrdersByUser(Integer userId, Principal user) throws UsersException, OrdersException {
		
		return ordersRepo.findAllByUsersId(userId);
	}

	@Override
	public Orders getOrderById(Integer orderId, Integer userId, Principal user) throws UsersException, OrdersException {
		
		return ordersRepo.findById(orderId).get();
	}

}
