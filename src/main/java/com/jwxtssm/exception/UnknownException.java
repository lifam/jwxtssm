package com.jwxtssm.exception;

public class UnknownException extends JWXTException {
	public UnknownException(){super();}
	public UnknownException(String message) {
		super(message);
	}
	public UnknownException(String message, Throwable cause) {
		super(message, cause);
	}
	public UnknownException(Throwable cause) {
		super(cause);
	}
}
