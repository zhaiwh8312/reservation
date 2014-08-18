package com.convenient.reservation.bean;

import com.convenient.reservation.constant.ExecResultEnum;

public class ServiceResultBean {
	private String result;
	private String msg;
	private Object obj;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
