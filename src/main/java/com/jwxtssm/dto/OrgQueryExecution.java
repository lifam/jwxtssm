package com.jwxtssm.dto;

import java.util.Arrays;

public class OrgQueryExecution {
	private String[] orgNames;
	private int[] orgIds;

	public OrgQueryExecution() {
	}

	public OrgQueryExecution(String[] orgNames, int[] orgIds) {
		this.orgNames = orgNames;
		this.orgIds = orgIds;
	}

	public String[] getOrgNames() {
		return orgNames;
	}

	public void setOrgNames(String[] orgNames) {
		this.orgNames = orgNames;
	}

	public int[] getOrgIds() {
		return orgIds;
	}

	public void setOrgIds(int[] orgIds) {
		this.orgIds = orgIds;
	}

	@Override
	public String toString() {
		return "OrgQueryExecution{" + "orgNames=" + Arrays.toString(orgNames) + ", orgIds=" + Arrays.toString
				(orgIds) + '}';
	}
}
