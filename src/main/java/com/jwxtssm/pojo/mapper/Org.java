package com.jwxtssm.pojo.mapper;

//机构/研究所
public class Org {
	private int orgId;
	//所属学院
	private int collegeId;
	//名字
	private String name;
	//介绍
	private String info;

	public Org() {
	}

	public Org(int orgId, int collegeId, String name, String info) {
		this.orgId = orgId;
		this.collegeId = collegeId;
		this.name = name;
		this.info = info;
	}

	public int getOrgId() {
		return orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
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

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "Org{" + "orgId=" + orgId + ", collegeId=" + collegeId + ", name='" + name + '\'' + ", info='" + info +
				'\'' + '}';
	}
}
