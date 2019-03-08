package com.jwxtssm.pojo;

import java.sql.Date;

//文件中心
public class DocCenter {
	private int docId;
	//文件所属人id
	private int basicId;
	//状态，1-可用/2-不可用
	private int state;
	//文件本地地址
	private String address;
	//文件类型，1-头像/2-其它文件
	private int type;
	//上传日期
	private Date publishDate;

	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

	public int getBasicId() {
		return basicId;
	}

	public void setBasicId(int basicId) {
		this.basicId = basicId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
}
