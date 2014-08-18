package com.convenient.reservation.persistent.model;

import java.io.Serializable;

/**
 * 后台 会员角色对应关系
 * 
 * @author zhaiwh
 * 
 */
public class BaseUserRole implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userId;
	private String roleId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

}
