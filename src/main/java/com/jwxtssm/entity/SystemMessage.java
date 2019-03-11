package com.jwxtssm.entity;

import java.sql.Date;

//系统通知
public class SystemMessage {
	private int systemMessageId;
	//通知对象
	private int basicId;
	//通知类型，1-教务通知/2-课程通知(作业发布/成绩发布等)/3-课内讨论(被@时通知)
	private int type;
	//通知内容
	private String content;
	//通知发布日期
	private Date publishDate;
	//通知优先级, 0-默认值
	private int priority;
	//通知状态，1-未读/2-已读/3-无效
	private int state;

	public SystemMessage() {
	}

	public SystemMessage(int systemMessageId, int basicId, int type, String content, Date publishDate, int priority,
						 int state) {
		this.systemMessageId = systemMessageId;
		this.basicId = basicId;
		this.type = type;
		this.content = content;
		this.publishDate = publishDate;
		this.priority = priority;
		this.state = state;
	}

	public int getSystemMessageId() {
		return systemMessageId;
	}

	public void setSystemMessageId(int systemMessageId) {
		this.systemMessageId = systemMessageId;
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

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "SystemMessage{" + "systemMessageId=" + systemMessageId + ", basicId=" + basicId + ", type=" + type +
				", content='" + content + '\'' + ", publishDate=" + publishDate + ", priority=" + priority + ", " +
				"state=" + state + '}';
	}
}
