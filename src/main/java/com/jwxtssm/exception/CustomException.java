package com.jwxtssm.exception;

public class CustomException extends JWXTException {
	public CustomException(){super();}
	public CustomException(String message) {
		super(message);
	}
	public CustomException(String message, Throwable cause) {
		super(message, cause);
	}
	public CustomException(Throwable cause) {
		super(cause);
	}
}
