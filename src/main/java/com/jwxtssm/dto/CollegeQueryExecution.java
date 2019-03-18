package com.jwxtssm.dto;

import java.util.Arrays;

public class CollegeQueryExecution {
	private String[] collegeNames;
	private int[] collegeIds;

	public CollegeQueryExecution() {
	}

	public CollegeQueryExecution(String[] collegeNames, int[] collegeIds) {
		this.collegeNames = collegeNames;
		this.collegeIds = collegeIds;
	}

	public String[] getCollegeNames() {
		return collegeNames;
	}

	public void setCollegeNames(String[] collegeNames) {
		this.collegeNames = collegeNames;
	}

	public int[] getCollegeIds() {
		return collegeIds;
	}

	public void setCollegeIds(int[] collegeIds) {
		this.collegeIds = collegeIds;
	}

	@Override
	public String toString() {
		return "CollegeQueryExecution{" + "collegeNames=" + Arrays.toString(collegeNames) + ", collegeIds=" + Arrays
				.toString(collegeIds) + '}';
	}
}
