package com.ecom.exceptions;

public class PaymentException extends Exception{
	private static final long serialVersionUID = 6959376221635013737L;

	public PaymentException() {
	}
	
	public PaymentException(String msg) {
		super(msg);
	}
}
