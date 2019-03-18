package com.jwxtssm.dto;

import java.sql.Date;
import java.util.Arrays;

public class DocsQueryExecution {
	private String[] docNames;
	private int[] docIds;
	private Date[] publishDates;
	private int[] docSizes;

	public DocsQueryExecution() {
	}

	public DocsQueryExecution(String[] docNames, int[] docIds, Date[] publishDates, int[] docSizes) {
		this.docNames = docNames;
		this.docIds = docIds;
		this.publishDates = publishDates;
		this.docSizes = docSizes;
	}

	public String[] getDocNames() {
		return docNames;
	}

	public void setDocNames(String[] docNames) {
		this.docNames = docNames;
	}

	public int[] getDocIds() {
		return docIds;
	}

	public void setDocIds(int[] docIds) {
		this.docIds = docIds;
	}

	public Date[] getPublishDates() {
		return publishDates;
	}

	public void setPublishDates(Date[] publishDates) {
		this.publishDates = publishDates;
	}

	public int[] getDocSizes() {
		return docSizes;
	}

	public void setDocSizes(int[] docSizes) {
		this.docSizes = docSizes;
	}

	@Override
	public String toString() {
		return "DocsQueryExecution{" + "docNames=" + Arrays.toString(docNames) + ", docIds=" + Arrays.toString(docIds)
				+ ", publishDates=" + Arrays.toString(publishDates) + ", docSizes=" + Arrays.toString(docSizes) + '}';
	}
}
