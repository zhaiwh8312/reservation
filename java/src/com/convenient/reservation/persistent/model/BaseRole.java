package com.convenient.reservation.persistent.model;

/**
 * 后台 角色
 * 
 * @author zhaiwh
 * 
 */
public class BaseRole {
	private String roleId;
	private String roleName;
	private String roleState;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleState() {
		return roleState;
	}

	public void setRoleState(String roleState) {
		this.roleState = roleState;
	}

}
