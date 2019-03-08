package com.jwxtssm.pojo;

import java.sql.Date;

//课内讨论
public class StudyTalking {
	//话题id
	private int talkId;
	//话题发起人
	private int basicId;
	//课程id
	private int courseId;
	//附件
	private int attachDocId;
	//标题
	private String title;
	//讨论说明
	private String content;
	//热度
	private float hot;
	//状态，1-有效/2-无效
	private int state;
	//发布日期
	private Date publishDate;
	//讨论记录数
	private int historyCount;

	public int getTalkId() {
		return talkId;
	}

	public void setTalkId(int talkId) {
		this.talkId = talkId;
	}

	public int getBasicId() {
		return basicId;
	}

	public void setBasicId(int basicId) {
		this.basicId = basicId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getAttachDocId() {
		return attachDocId;
	}

	public void setAttachDocId(int attachDocId) {
		this.attachDocId = attachDocId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public float getHot() {
		return hot;
	}

	public void setHot(float hot) {
		this.hot = hot;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public int getHistoryCount() {
		return historyCount;
	}

	public void setHistoryCount(int historyCount) {
		this.historyCount = historyCount;
	}
}
