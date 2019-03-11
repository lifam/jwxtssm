package com.jwxtssm.entity;

//选课记录
public class CourseRecords {
	//课程id
	private int courseId;
	//学生id
	private int basicId;
	//最终成绩
	private int finalScore;
	//状态，1-正常/2-缓考/3-重考1/4-重考2/5-重考3/6-评教，32th-bit：已审核/未审核(审核后锁定,不可再修改)
	private int state;

	public CourseRecords() {
	}

	public CourseRecords(int courseId, int basicId, int finalScore, int state) {
		this.courseId = courseId;
		this.basicId = basicId;
		this.finalScore = finalScore;
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

	@Override
	public String toString() {
		return "CourseRecords{" + "courseId=" + courseId + ", basicId=" + basicId + ", finalScore=" + finalScore + ", " +
				"" + "state=" + state + '}';
	}
}
