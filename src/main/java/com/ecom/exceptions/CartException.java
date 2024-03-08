package com.ecom.exceptions;

public class CartException extends Exception {
	
	private static final long serialVersionUID = 6959376221635013737L;

	public CartException() {
	}
	
	public CartException(String msg) {
		super(msg);
	}
}
