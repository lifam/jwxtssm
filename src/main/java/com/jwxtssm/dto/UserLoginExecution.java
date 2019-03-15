package com.jwxtssm.dto;

import com.jwxtssm.entity.Role;

import java.util.Arrays;

public class UserLoginExecution {
	private int basicId;
	private int[] authCodes;
	private Role[] roles;

	public UserLoginExecution() {
	}

	public UserLoginExecution(int basicId, int[] authCodes, Role[] roles) {
		this.basicId = basicId;
		this.authCodes = authCodes;
		this.roles = roles;
	}

	public int getBasicId() {
		return basicId;
	}

	public void setBasicId(int basicId) {
		this.basicId = basicId;
	}

	public int[] getAuthCodes() {
		return authCodes;
	}

	public void setAuthCodes(int[] authCodes) {
		this.authCodes = authCodes;
	}

	public Role[] getRoles() {
		return roles;
	}

	public void setRoles(Role[] roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "UserLoginExecution{" + "basicId=" + basicId + ", authCodes=" + Arrays.toString(authCodes) + ", roles="
				+ Arrays.toString(roles) + '}';
	}
}
