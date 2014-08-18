package com.convenient.reservation.persistent.model;

/**
 * 后台 角色菜单对应关系
 * 
 * @author zhaiwh
 * 
 */
public class BaseRoleResource {
	private String roleId;
	private String resourceId;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

}
