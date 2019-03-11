package com.jwxtssm.pojo;

//联系信息-邮箱/电话/QQ/微信/微博
public class AddressInfo {
	private int addressId;
	private int basicId;
	//1-邮箱/2-电话/3-QQ/4-微信/5-微博
	private int type;
	//联系信息具体值
	private String info;

	public AddressInfo() {
	}

	public AddressInfo(int addressId, int basicId, int type, String info) {
		this.addressId = addressId;
		this.basicId = basicId;
		this.type = type;
		this.info = info;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
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

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "AddressInfo{" + "addressId=" + addressId + ", basicId=" + basicId + ", type=" + type + ", info='" +
                info + '\'' + '}';
	}
}
