package com.lucatic.grupo2.app.users.exceptions;

public class EmptyListException extends UserException {

	private static final long serialVersionUID = 1L;


	public EmptyListException(String message) {
		super(message);
	}

	
	public EmptyListException(String message, Throwable cause) {
		super(message, cause);
	}
}
