package com.jwxtssm.pojo;

//课程作业/考试
public class HomeworkExam {
	private int homeworkExamId;
	//课程id
	private int courseId;
	//作业/考试说明
	private String info;
	//占总评成绩的比例
	private int percent;
	//状态，32th-bit：已审核/未审核(审核后锁定,不可再修改)
	private int state;

	public int getHomeworkExamId() {
		return homeworkExamId;
	}

	public void setHomeworkExamId(int homeworkExamId) {
		this.homeworkExamId = homeworkExamId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int getPercent() {
		return percent;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
}
