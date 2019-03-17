package com.jwxtssm.dto;

import java.util.Arrays;

public class DocsQueryExecution {
	String[] docNames;
	int[] docIds;

	public DocsQueryExecution() {
	}

	public DocsQueryExecution(String[] docNames, int[] docIds) {
		this.docNames = docNames;
		this.docIds = docIds;
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

	@Override
	public String toString() {
		return "DocsQueryExecution{" + "docNames=" + Arrays.toString(docNames) + ", docIds=" + Arrays.toString
				(docIds) + '}';
	}
}
