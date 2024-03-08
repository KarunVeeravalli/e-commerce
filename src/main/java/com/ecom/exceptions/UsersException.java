package com.ecom.exceptions;

public class UsersException extends Exception {
	private static final long serialVersionUID = 6959376221635013737L;

	public UsersException() {
	}
	
	public UsersException(String msg) {
		super(msg);
	}
}
