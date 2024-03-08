package com.ecom.exceptions;

public class InventoryException extends Exception {
	private static final long serialVersionUID = 6959376221635013737L;

	public InventoryException() {
	}
	
	public InventoryException(String msg) {
		super(msg);
	}
}
