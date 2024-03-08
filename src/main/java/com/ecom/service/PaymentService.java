package com.ecom.service;

import java.security.Principal;

import com.ecom.exceptions.PaymentException;
import com.ecom.exceptions.UsersException;
import com.ecom.model.Payment;

public interface PaymentService {
	
	Payment addPayment(Payment payment,Integer userId,Principal user) throws UsersException,PaymentException;
	
	Payment updatePayment(Payment payment,Integer paymentId,Integer userId,Principal user) throws UsersException,PaymentException;
	
	Payment getPaymentById(Integer paymentId,Integer userId,Principal user) throws UsersException,PaymentException;
	
	Payment deletePayment(Integer paymentId,Integer userId,Principal user) throws UsersException,PaymentException;
	
	
	

}
