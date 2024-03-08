package com.ecom.exceptions;

public class ShippingException extends Exception{
	private static final long serialVersionUID = 6959376221635013737L;

	public ShippingException() {
	}
	
	public ShippingException(String msg) {
		super(msg);
	}
}
