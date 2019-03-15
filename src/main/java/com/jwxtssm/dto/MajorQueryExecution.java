package com.jwxtssm.dto;

import java.util.Arrays;

public class MajorQueryExecution {
	private String[] majorNames;
	private int[] majorIds;

	public MajorQueryExecution() {
	}

	public MajorQueryExecution(String[] majorNames, int[] majorIds) {
		this.majorNames = majorNames;
		this.majorIds = majorIds;
	}

	public String[] getMajorNames() {
		return majorNames;
	}

	public void setMajorNames(String[] majorNames) {
		this.majorNames = majorNames;
	}

	public int[] getMajorIds() {
		return majorIds;
	}

	public void setMajorIds(int[] majorIds) {
		this.majorIds = majorIds;
	}

	@Override
	public String toString() {
		return "MajorQueryExecution{" + "majorNames=" + Arrays.toString(majorNames) + ", majorIds=" + Arrays.toString
				(majorIds) + '}';
	}
}
