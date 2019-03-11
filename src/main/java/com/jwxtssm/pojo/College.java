package com.jwxtssm.pojo;

//学院
public class College {
	private int collegeId;
	//学院名称
	private String name;
	//学院介绍
	private String intro;
	//学院地点
	private String address;

	public College() {
	}

	public College(int collegeId, String name, String intro, String address) {
		this.collegeId = collegeId;
		this.name = name;
		this.intro = intro;
		this.address = address;
	}

	public int getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "College{" + "collegeId=" + collegeId + ", name='" + name + '\'' + ", intro='" + intro + '\'' + ", " +
				"address='" + address + '\'' + '}';
	}
}
