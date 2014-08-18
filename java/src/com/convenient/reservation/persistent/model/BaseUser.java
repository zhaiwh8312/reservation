package com.convenient.reservation.persistent.model;

/**
 * 后台 用户
 * 
 * @author zhaiwh
 * 
 */
public class BaseUser {
	private String user_id;
	private String user_name;
	private String user_pwd;
	private int user_sex;
	private String user_email;
	private String user_phone;
	private String uesr_deptId;
	private String user_state;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_pwd() {
		return user_pwd;
	}

	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}

	public int getUser_sex() {
		return user_sex;
	}

	public void setUser_sex(int user_sex) {
		this.user_sex = user_sex;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUesr_deptId() {
		return uesr_deptId;
	}

	public void setUesr_deptId(String uesr_deptId) {
		this.uesr_deptId = uesr_deptId;
	}

	public String getUser_state() {
		return user_state;
	}

	public void setUser_state(String user_state) {
		this.user_state = user_state;
	}

}
