package com.jwxtssm.pojo.mapper;

//课程作业/考试记录
public class HomeworkExamScore {
	private int homeworkExamId;
	//学生id
	private int basicId;
	//作业/考试成绩
	private int score;
	//评分说明
	private String info;
	//状态，32th-bit：已审核/未审核(审核后锁定,不可再修改)
	private int state;

	public HomeworkExamScore() {
	}

	public HomeworkExamScore(int homeworkExamId, int basicId, int score, String info, int state) {
		this.homeworkExamId = homeworkExamId;
		this.basicId = basicId;
		this.score = score;
		this.info = info;
		this.state = state;
	}

	public int getHomeworkExamId() {
		return homeworkExamId;
	}

	public void setHomeworkExamId(int homeworkExamId) {
		this.homeworkExamId = homeworkExamId;
	}

	public int getBasicId() {
		return basicId;
	}

	public void setBasicId(int basicId) {
		this.basicId = basicId;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "HomeworkExamScore{" + "homeworkExamId=" + homeworkExamId + ", basicId=" + basicId + ", score=" + score
				+ ", info='" + info + '\'' + ", state=" + state + '}';
	}
}
