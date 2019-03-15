package com.jwxtssm.entity;

public class LocationInfo {
	private int locationId;
	//	校区
	private String campus;
	//	教学楼
	private String location;
	//	课室号
	private int room;

	public LocationInfo() {
	}

	public LocationInfo(int locationId, String campus, String location, int room) {
		this.locationId = locationId;
		this.campus = campus;
		this.location = location;
		this.room = room;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	@Override
	public String toString() {
		return "LocationInfo{" + "locationId=" + locationId + ", campus='" + campus + '\'' + ", location='" + location
				+ '\'' + ", room=" + room + '}';
	}
}
