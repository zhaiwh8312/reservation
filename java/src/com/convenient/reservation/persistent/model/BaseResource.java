package com.convenient.reservation.persistent.model;

/**
 * 后台 菜单
 * 
 * @author zhaiwh
 * 
 */
public class BaseResource {
	private String resourceId;
	private String resourceTitle;
	private String resourceUrl;
	private String resourceState;
	private int resourceSeq;
	private String parentId;

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getResourceTitle() {
		return resourceTitle;
	}

	public void setResourceTitle(String resourceTitle) {
		this.resourceTitle = resourceTitle;
	}

	public String getResourceUrl() {
		return resourceUrl;
	}

	public void setResourceUrl(String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}

	public String getResourceState() {
		return resourceState;
	}

	public void setResourceState(String resourceState) {
		this.resourceState = resourceState;
	}

	public int getResourceSeq() {
		return resourceSeq;
	}

	public void setResourceSeq(int resourceSeq) {
		this.resourceSeq = resourceSeq;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

}
