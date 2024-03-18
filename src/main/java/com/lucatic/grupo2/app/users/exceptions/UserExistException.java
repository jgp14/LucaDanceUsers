package com.lucatic.grupo2.app.users.exceptions;

public class UserExistException extends UserException{

	private static final long serialVersionUID = 1L;

	public UserExistException(String message) {
		super(message);
	}

	public UserExistException(String message, Throwable cause) {
		super(message, cause);
	}

}
