package com.jwxtssm.pojo.mapper;

import java.sql.Date;

//教务通知
public class EduMessage {
	private int eduMessageId;
	//教务员id
	private int basicId;
	//附件
	private int attachDocId;
	//标题
	private String title;
	//内容
	private String content;
	//类型，1-普通通知/2-通知全体教职人员/3-通知全体学生/4-通知全体人员
	private int type;
	//发布日期
	private Date publishDate;
	//状态，1-有效/2-已失效
	private int state;
	//优先级，1<2<3<...
	private int priority;

	public EduMessage() {
	}

	public EduMessage(int eduMessageId, int basicId, int attachDocId, String title, String content, int type, Date
			publishDate, int state, int priority) {
		this.eduMessageId = eduMessageId;
		this.basicId = basicId;
		this.attachDocId = attachDocId;
		this.title = title;
		this.content = content;
		this.type = type;
		this.publishDate = publishDate;
		this.state = state;
		this.priority = priority;
	}

	public int getEduMessageId() {
		return eduMessageId;
	}

	public void setEduMessageId(int eduMessageId) {
		this.eduMessageId = eduMessageId;
	}

	public int getBasicId() {
		return basicId;
	}

	public void setBasicId(int basicId) {
		this.basicId = basicId;
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		return "EduMessage{" + "eduMessageId=" + eduMessageId + ", basicId=" + basicId + ", attachDocId=" +
				attachDocId + ", title='" + title + '\'' + ", content='" + content + '\'' + ", type=" + type + ", " +
				"publishDate=" + publishDate + ", state=" + state + ", priority=" + priority + '}';
	}
}
