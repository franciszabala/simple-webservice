package com.franciszabala.simplewebservice.exception;

public class NoPlanFoundException extends Exception {

	private String message;
	
	public NoPlanFoundException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
