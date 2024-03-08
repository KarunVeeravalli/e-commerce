package com.ecom.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.dto.GeneralResponse;
import com.ecom.exceptions.PaymentException;
import com.ecom.exceptions.UsersException;
import com.ecom.model.Payment;
import com.ecom.service.PaymentService;



@RestController
@RequestMapping("/payments")
@CrossOrigin
public class PaymentsController {
	@Autowired
	PaymentService paymentService;
	
	@PutMapping("updatePayment/{userId}/{paymentId}")
	ResponseEntity<GeneralResponse> updatePayment(@RequestBody Payment payment,@PathVariable Integer userId,@PathVariable Integer paymentId, Principal user) throws UsersException,PaymentException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("Payment updated by user Id : " + userId);
		generalResponse.setData(paymentService.updatePayment( payment,paymentId, userId, user));
		return ResponseEntity.ok(generalResponse);
	}
	

	@PostMapping("addPayment/{userId}")
	ResponseEntity<GeneralResponse> addPayment(@RequestBody Payment payment,@PathVariable Integer userId, Principal user) throws UsersException,PaymentException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("Payment added by user Id : " + userId);
		generalResponse.setData(paymentService.addPayment(  payment,userId, user));
		return ResponseEntity.ok(generalResponse);
	}
	

	@DeleteMapping("deletePayment/{userId}/{paymentId}")
	ResponseEntity<GeneralResponse> deletePayment(@PathVariable Integer userId,@PathVariable Integer paymentId, Principal user) throws UsersException,PaymentException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("Payment deleted by user Id : " + userId);
		generalResponse.setData(paymentService.deletePayment(paymentId,  userId, user));
		return ResponseEntity.ok(generalResponse);
	}
	
	
	@GetMapping("getPaymentById/{userId}/{paymentId}")
	ResponseEntity<GeneralResponse> getPaymentById(@PathVariable Integer userId, @PathVariable Integer paymentId,Principal user) throws UsersException,PaymentException{
		var generalResponse = new GeneralResponse();
		
		generalResponse.setMessage("Payment found by user Id : " + userId);
		generalResponse.setData(paymentService.getPaymentById(paymentId,  userId, user));
		return ResponseEntity.ok(generalResponse);
	}
	
	
	

}
