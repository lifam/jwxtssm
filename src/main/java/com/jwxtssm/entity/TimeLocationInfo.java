package com.jwxtssm.entity;

public class TimeLocationInfo {
	private int locationId;
	private int courseId;
	//	周次/星期/节次, 1~20/0~6/1~10
	private int time;

	public TimeLocationInfo() {
	}

	public TimeLocationInfo(int locationId, int courseId, int time) {
		this.locationId = locationId;
		this.courseId = courseId;
		this.time = time;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "TimeLocationInfo{" + "locationId=" + locationId + ", courseId=" + courseId + ", time=" + time + '}';
	}
}
