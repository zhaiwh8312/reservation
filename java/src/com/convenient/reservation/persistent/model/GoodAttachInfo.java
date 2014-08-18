package com.convenient.reservation.persistent.model;

/**
 * 商品附件
 * 
 * @author zhaiwh
 * 
 */
public class GoodAttachInfo {
	private String attachId;
	private String goodId;
	private String attachName;
	private String attachStatus;

	public String getAttachId() {
		return attachId;
	}

	public void setAttachId(String attachId) {
		this.attachId = attachId;
	}

	public String getGoodId() {
		return goodId;
	}

	public void setGoodId(String goodId) {
		this.goodId = goodId;
	}

	public String getAttachName() {
		return attachName;
	}

	public void setAttachName(String attachName) {
		this.attachName = attachName;
	}

	public String getAttachStatus() {
		return attachStatus;
	}

	public void setAttachStatus(String attachStatus) {
		this.attachStatus = attachStatus;
	}

}
