package com.jwxtssm.entity;

//专业
public class Major {
	private int majorId;
	//所属学院
	private int collegeId;
	//学制，1-全日制4年/2-全日制5年
	private int type;
	//专业名称
	private String name;
	//专业介绍
	private String intro;
	//专必学分
	private int majorCompulsoryGrades;
	//专选学分
	private int majorElectiveGrades;
	//公必学分
	private int publicCompulsoryGrades;
	//公选学分
	private int publicElectiveGrades;

	public Major() {
	}

	public Major(int majorId, int collegeId, int type, String name, String intro, int majorCompulsoryGrades, int
			majorElectiveGrades, int publicCompulsoryGrades, int publicElectiveGrades) {
		this.majorId = majorId;
		this.collegeId = collegeId;
		this.type = type;
		this.name = name;
		this.intro = intro;
		this.majorCompulsoryGrades = majorCompulsoryGrades;
		this.majorElectiveGrades = majorElectiveGrades;
		this.publicCompulsoryGrades = publicCompulsoryGrades;
		this.publicElectiveGrades = publicElectiveGrades;
	}

	public int getMajorId() {
		return majorId;
	}

	public void setMajorId(int majorId) {
		this.majorId = majorId;
	}

	public int getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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

	public int getMajorCompulsoryGrades() {
		return majorCompulsoryGrades;
	}

	public void setMajorCompulsoryGrades(int majorCompulsoryGrades) {
		this.majorCompulsoryGrades = majorCompulsoryGrades;
	}

	public int getMajorElectiveGrades() {
		return majorElectiveGrades;
	}

	public void setMajorElectiveGrades(int majorElectiveGrades) {
		this.majorElectiveGrades = majorElectiveGrades;
	}

	public int getPublicCompulsoryGrades() {
		return publicCompulsoryGrades;
	}

	public void setPublicCompulsoryGrades(int publicCompulsoryGrades) {
		this.publicCompulsoryGrades = publicCompulsoryGrades;
	}

	public int getPublicElectiveGrades() {
		return publicElectiveGrades;
	}

	public void setPublicElectiveGrades(int publicElectiveGrades) {
		this.publicElectiveGrades = publicElectiveGrades;
	}

	@Override
	public String toString() {
		return "Major{" + "majorId=" + majorId + ", collegeId=" + collegeId + ", type=" + type + ", name='" + name +
				'\'' + ", intro='" + intro + '\'' + ", majorCompulsoryGrades=" + majorCompulsoryGrades + ", " +
				"majorElectiveGrades=" + majorElectiveGrades + ", publicCompulsoryGrades=" + publicCompulsoryGrades +
				", publicElectiveGrades=" + publicElectiveGrades + '}';
	}
}
