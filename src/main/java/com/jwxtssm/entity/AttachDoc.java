package com.jwxtssm.entity;

//附件
public class AttachDoc {
	//附件id
	private int attachDocId;
	//文件id
	private int docId;

	public AttachDoc() {
	}

	public AttachDoc(int attachDocId, int docId) {
		this.attachDocId = attachDocId;
		this.docId = docId;
	}

	public int getAttachDocId() {
		return attachDocId;
	}

	public void setAttachDocId(int attachDocId) {
		this.attachDocId = attachDocId;
	}

	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

	@Override
	public String toString() {
		return "AttachDoc{" + "attachDocId=" + attachDocId + ", docId=" + docId + '}';
	}
}
