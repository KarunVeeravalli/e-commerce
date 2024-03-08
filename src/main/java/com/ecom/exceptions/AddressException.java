package com.ecom.exceptions;

public class AddressException extends Exception {
	private static final long serialVersionUID = 6959376221635013737L;

	public AddressException() {
	}
	
	public AddressException(String msg) {
		super(msg);
	}
}
