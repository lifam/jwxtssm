package com.jwxtssm.exception;

import com.jwxtssm.common.Utils;

public class CustomException extends JWXTException {
	private String message;

	public CustomException(){super();}
	public CustomException(String message) {
		this.message = message;
	}
	public CustomException(String message, Throwable cause) {
		super(message, cause);
	}
	public CustomException(Throwable cause) {
		super(cause);
	}

	@Override
	public String getMessage() {
		return message;
	}
}
