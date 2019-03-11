package com.jwxtssm.entity;

import java.sql.Date;

//学习讨论记录
public class StudyTalkingHistory {
	private int messageId;
	//所属话题id
	private int talkId;
	//发表人
	private int basicId;
	//课程id
	private int courseId;
	//讨论内容
	private String content;
	//发表日期
	private Date publishDate;
	//第几条讨论
	private int indexCount;
	//类型，暂未定义
	private int type;
	//状态，1-有效/2-无效
	private int state;

	public StudyTalkingHistory() {
	}

	public StudyTalkingHistory(int messageId, int talkId, int basicId, int courseId, String content, Date publishDate,
							   int indexCount, int type, int state) {
		this.messageId = messageId;
		this.talkId = talkId;
		this.basicId = basicId;
		this.courseId = courseId;
		this.content = content;
		this.publishDate = publishDate;
		this.indexCount = indexCount;
		this.type = type;
		this.state = state;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public int getIndexCount() {
		return indexCount;
	}

	public void setIndexCount(int indexCount) {
		this.indexCount = indexCount;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "StudyTalkingHistory{" + "messageId=" + messageId + ", talkId=" + talkId + ", basicId=" + basicId + ", " +
				"" + "courseId=" + courseId + ", content='" + content + '\'' + ", publishDate=" + publishDate + ", " +
				"indexCount=" + indexCount + ", type=" + type + ", state=" + state + '}';
	}
}
