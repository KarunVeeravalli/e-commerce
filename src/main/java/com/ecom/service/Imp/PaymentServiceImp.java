package com.ecom.service.Imp;

import java.security.Principal;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.exceptions.PaymentException;
import com.ecom.exceptions.UsersException;
import com.ecom.model.Payment;
import com.ecom.model.Users;
import com.ecom.repoHelper.UtilityHelper;
import com.ecom.repository.PaymentRepo;
import com.ecom.service.PaymentService;
import com.ecom.service.UsersService;


@Service
public class PaymentServiceImp implements PaymentService{
	
	@Autowired
	UsersService usersService;
	
	@Autowired
	UtilityHelper utilityHelper;
	
	@Autowired
	PaymentRepo paymentRepo;

	@Override
	public Payment addPayment(Payment payment, Integer userId, Principal user)
			throws UsersException, PaymentException {
		Users users = usersService.getUserById(userId, user);
		payment.setUsers(users);
		return paymentRepo.save(payment);
	}

	@Override
	public Payment updatePayment(Payment payment, Integer paymentId, Integer userId,
			Principal user) throws UsersException, PaymentException {
		Payment oldPayment = getPaymentById(paymentId, userId, user);
		BeanUtils.copyProperties(payment, oldPayment, utilityHelper.getNullPropertyNames(payment));
		return paymentRepo.save(oldPayment);
	}

	@Override
	public Payment getPaymentById(Integer paymentId, Integer userId, Principal user)
			throws UsersException, PaymentException {
		
		return paymentRepo.findById(paymentId).get();
	}

	@Override
	public Payment deletePayment(Integer paymentId, Integer userId, Principal user)
			throws UsersException, PaymentException {
		Payment payment = getPaymentById(paymentId, userId, user);
		paymentRepo.deleteById(paymentId);
		return payment;
	}

}
