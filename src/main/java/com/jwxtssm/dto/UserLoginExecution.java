package com.jwxtssm.dto;

public class UserLoginExecution {
	private int basicId;

	public UserLoginExecution() {
	}

	public UserLoginExecution(int basic_id) {
		this.basicId = basic_id;
	}

	public int getBasicId() {
		return basicId;
	}

	public void setBasicId(int basicId) {
		this.basicId = basicId;
	}
}
