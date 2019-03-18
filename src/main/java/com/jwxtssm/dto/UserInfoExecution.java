package com.jwxtssm.dto;

import java.sql.Date;
import java.util.Arrays;

public class UserInfoExecution {
	private int viceId;
	private String name;
	private String sex;
	private float height;
	private float weight;
	private Date birthInfo;
	private String homeAddress;
	private String formalId;
	private String rewardInfo;
	private String punishmentInfo;
	private String infoTransparency;
	private String[] types;
	private String[] infoes;

	public UserInfoExecution() {
	}

	public UserInfoExecution(int viceId, String name, String sex, float height, float weight, Date birthInfo, String
			homeAddress, String formalId, String rewardInfo, String punishmentInfo, String infoTransparency, String[]
			type, String[] info) {
		this.viceId = viceId;
		this.name = name;
		this.sex = sex;
		this.height = height;
		this.weight = weight;
		this.birthInfo = birthInfo;
		this.homeAddress = homeAddress;
		this.formalId = formalId;
		this.rewardInfo = rewardInfo;
		this.punishmentInfo = punishmentInfo;
		this.infoTransparency = infoTransparency;
		this.types = type;
		this.infoes = info;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
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

	public String getInfoTransparency() {
		return infoTransparency;
	}

	public void setInfoTransparency(String infoTransparency) {
		this.infoTransparency = infoTransparency;
	}

	public String[] getTypes() {
		return types;
	}

	public void setTypes(String[] types) {
		this.types = types;
	}

	public String[] getInfoes() {
		return infoes;
	}

	public void setInfoes(String[] infoes) {
		this.infoes = infoes;
	}

	@Override
	public String toString() {
		return "UserInfoExecution{" + "viceId=" + viceId + ", name='" + name + '\'' + ", sex='" + sex + '\'' + ", " +
				"height=" + height + ", weight=" + weight + ", birthInfo=" + birthInfo + ", homeAddress='" +
				homeAddress + '\'' + ", formalId='" + formalId + '\'' + ", rewardInfo='" + rewardInfo + '\'' + ", " +
				"punishmentInfo='" + punishmentInfo + '\'' + ", infoTransparency='" + infoTransparency + '\'' + ", " +
				"types=" + Arrays.toString(types) + ", infoes=" + Arrays.toString(infoes) + '}';
	}
}
