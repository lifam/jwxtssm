package com.jwxtssm.pojo;

//评教记录
public class CourseJugdeRecords {
	//课程id
	private int courseId;
	//老师/助教id
	private int basicIdTe;
	//学生id
	private int basicIdSt;
	//最终成绩
	private int finalScore;
	//状态，32th-bit：已审核/未审核(审核后锁定,不可再修改)
	private int state;

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getBasicIdTe() {
		return basicIdTe;
	}

	public void setBasicIdTe(int basicIdTe) {
		this.basicIdTe = basicIdTe;
	}

	public int getBasicIdSt() {
		return basicIdSt;
	}

	public void setBasicIdSt(int basicIdSt) {
		this.basicIdSt = basicIdSt;
	}

	public int getFinalScore() {
		return finalScore;
	}

	public void setFinalScore(int finalScore) {
		this.finalScore = finalScore;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
}
