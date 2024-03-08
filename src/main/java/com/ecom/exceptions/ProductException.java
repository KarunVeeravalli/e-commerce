package com.ecom.exceptions;

public class ProductException extends Exception{
	
	private static final long serialVersionUID = 6959376221635013737L;

	public ProductException() {
	}
	
	public ProductException(String msg) {
		super(msg);
	}
}
