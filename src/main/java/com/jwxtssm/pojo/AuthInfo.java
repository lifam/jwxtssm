package com.jwxtssm.pojo;

import java.sql.Date;

//权限信息
public class AuthInfo {
	private int authId;
	//权限码，0-未定义, 1-管理员，2-教务员，3-教师，4-助教，5-学生
	private int authCode;
	//生效日期
	private Date validFrom;
	//失效日期
	private Date validTo;

	public AuthInfo() {
	}

	public AuthInfo(int authId, int authCode, Date validFrom, Date validTo) {
		this.authId = authId;
		this.authCode = authCode;
		this.validFrom = validFrom;
		this.validTo = validTo;
	}

	public int getAuthId() {
		return authId;
	}

	public void setAuthId(int authId) {
		this.authId = authId;
	}

	public int getAuthCode() {
		return authCode;
	}

	public void setAuthCode(int authCode) {
		this.authCode = authCode;
	}

	public Date getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	@Override
	public String toString() {
		return "AuthInfo{" + "authId=" + authId + ", authCode=" + authCode + ", validFrom=" + validFrom + ", validTo="
				+ validTo + '}';
	}
}
