package com.ecom.exceptions;

public class OrdersException extends Exception{
	private static final long serialVersionUID = 6959376221635013737L;

	public OrdersException() {
	}
	
	public OrdersException(String msg) {
		super(msg);
	}
}
