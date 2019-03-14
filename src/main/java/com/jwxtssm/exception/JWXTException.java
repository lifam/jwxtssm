package com.jwxtssm.exception;

public class JWXTException extends Exception {
	public JWXTException(){super();}
	public JWXTException(String message) {
		super(message);
	}
	public JWXTException(String message, Throwable cause) {
		super(message, cause);
	}
	public JWXTException(Throwable cause) {
		super(cause);
	}
}
