package com.convenient.reservation.persistent.model;

/**
 * 订单用户附件对应
 * 
 * @author zhaiwh
 * 
 */
public class OrderUserAttach {
	private String orderId;
	private String userId;
	private String attachId;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAttachId() {
		return attachId;
	}

	public void setAttachId(String attachId) {
		this.attachId = attachId;
	}

}
