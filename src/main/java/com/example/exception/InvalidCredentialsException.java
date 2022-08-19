package com.example.exception;

public class InvalidCredentialsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidCredentialsException(){
		super("You have put in the wrong username and password.");
	}
	
}
