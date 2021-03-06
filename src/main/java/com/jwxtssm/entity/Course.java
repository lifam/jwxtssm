package com.jwxtssm.entity;

import java.sql.Date;

//开课记录
public class Course {
	private int courseId;
	//开课老师
	private int basicId;
	//课程类型，1-专必MC/2-专选ME/3-公必PC/4-公选PE
	private int type;
	//课程学分
	private int score;
	//课程名称
	private String name;
	//课程介绍/说明
	private String intro;
	//课程开始时间
	private Date validFrom;
	//课程结束时间
	private Date validTo;
	//状态，0-默认值, 1-可以选课/2-停止选课/3-有效期内/4-课程失效，32th-bit：已审核/未审核，31th-bit：锁定/未锁定
	private int state;

	public Course() {
	}

	public Course(int courseId, int basicId, int type, int score, String name, String intro, Date
			validFrom, Date validTo, int state) {
		this.courseId = courseId;
		this.basicId = basicId;
		this.type = type;
		this.score = score;
		this.name = name;
		this.intro = intro;
		this.validFrom = validFrom;
		this.validTo = validTo;
		this.state = state;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getBasicId() {
		return basicId;
	}

	public void setBasicId(int basicId) {
		this.basicId = basicId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
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

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Course{" + "courseId=" + courseId + ", basicId=" + basicId + ", type=" + type + ", score=" + score +
				", name='" + name + '\'' + ", intro='" + intro + '\'' + ", " +
				"" + "validFrom=" + validFrom + ", validTo=" + validTo + ", state=" + state + '}';
	}
}
