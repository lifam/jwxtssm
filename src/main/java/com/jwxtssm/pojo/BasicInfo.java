package com.jwxtssm.pojo;

import java.sql.Date;

//个人基本信息
public class BasicInfo {
	private int basicId;
	//头像，保存在表doc_center中
	private int headImg;
	//副id，用于学生学号，教师职工号等
	private int viceId;
	//名字
	private String  name;
	//密码，使用sha-256
	private String  password;
	//性别
	private int sex;
	//身高/cm
	private float height;
	//体重/kg
	private float weight;
	//出生年月
	private Date birthInfo;
	//家庭住址
	private String homeAddress;
	//身份证号
	private String formalId;
	//表彰信息
	private String rewardInfo;
	//惩罚信息
	private String punishmentInfo;
	//个人信息可见度，1-名字/头像，2-+学号，3-+性别，4+出生年月，5-+身高/体重
	private int infoTransparency;

	public int getBasicId() {
		return basicId;
	}

	public void setBasicId(int basicId) {
		this.basicId = basicId;
	}

	public int getHeadImg() {
		return headImg;
	}

	public void setHeadImg(int headImg) {
		this.headImg = headImg;
	}

	public int getViceId() {
		return viceId;
	}

	public void setViceId(int viceId) {
		this.viceId = viceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public Date getBirthInfo() {
		return birthInfo;
	}

	public void setBirthInfo(Date birthInfo) {
		this.birthInfo = birthInfo;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getFormalId() {
		return formalId;
	}

	public void setFormalId(String formalId) {
		this.formalId = formalId;
	}

	public String getRewardInfo() {
		return rewardInfo;
	}

	public void setRewardInfo(String rewardInfo) {
		this.rewardInfo = rewardInfo;
	}

	public String getPunishmentInfo() {
		return punishmentInfo;
	}

	public void setPunishmentInfo(String punishmentInfo) {
		this.punishmentInfo = punishmentInfo;
	}

	public int getInfoTransparency() {
		return infoTransparency;
	}

	public void setInfoTransparency(int infoTransparency) {
		this.infoTransparency = infoTransparency;
	}
}
