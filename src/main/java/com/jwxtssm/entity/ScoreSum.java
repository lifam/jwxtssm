package com.jwxtssm.entity;

//学分概况
public class ScoreSum {
	//学生id
	private int basicId;
	//专必绩点
	private float mcScore;
	//专必学分
	private int mcGrade;
	//专选绩点
	private float meScore;
	//专选学分
	private int meGrade;
	//公必绩点
	private float pcScore;
	//公必学分
	private int pcGrade;
	//公选绩点
	private float peScore;
	//公选学分
	private int peGrade;

	public ScoreSum() {
	}

	public ScoreSum(int basicId, float mcScore, int mcGrade, float meScore, int meGrade, float pcScore, int pcGrade,
					float peScore, int peGrade) {
		this.basicId = basicId;
		this.mcScore = mcScore;
		this.mcGrade = mcGrade;
		this.meScore = meScore;
		this.meGrade = meGrade;
		this.pcScore = pcScore;
		this.pcGrade = pcGrade;
		this.peScore = peScore;
		this.peGrade = peGrade;
	}

	public int getBasicId() {
		return basicId;
	}

	public void setBasicId(int basicId) {
		this.basicId = basicId;
	}

	public float getMcScore() {
		return mcScore;
	}

	public void setMcScore(float mcScore) {
		this.mcScore = mcScore;
	}

	public int getMcGrade() {
		return mcGrade;
	}

	public void setMcGrade(int mcGrade) {
		this.mcGrade = mcGrade;
	}

	public float getMeScore() {
		return meScore;
	}

	public void setMeScore(float meScore) {
		this.meScore = meScore;
	}

	public int getMeGrade() {
		return meGrade;
	}

	public void setMeGrade(int meGrade) {
		this.meGrade = meGrade;
	}

	public float getPcScore() {
		return pcScore;
	}

	public void setPcScore(float pcScore) {
		this.pcScore = pcScore;
	}

	public int getPcGrade() {
		return pcGrade;
	}

	public void setPcGrade(int pcGrade) {
		this.pcGrade = pcGrade;
	}

	public float getPeScore() {
		return peScore;
	}

	public void setPeScore(float peScore) {
		this.peScore = peScore;
	}

	public int getPeGrade() {
		return peGrade;
	}

	public void setPeGrade(int peGrade) {
		this.peGrade = peGrade;
	}

	@Override
	public String toString() {
		return "ScoreSum{" + "basicId=" + basicId + ", mcScore=" + mcScore + ", mcGrade=" + mcGrade + ", meScore=" +
				meScore + ", meGrade=" + meGrade + ", pcScore=" + pcScore + ", pcGrade=" + pcGrade + ", peScore=" +
				peScore + ", peGrade=" + peGrade + '}';
	}
}
