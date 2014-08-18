package com.convenient.reservation.constant;

public enum ExecResultEnum {
	/**
	 * 成功
	 */
	SUCCESS {
		public String getName() {
			return "success";
		}
	},
	/**
	 * 失败
	 */
	FAILURE {
		public String getName() {
			return "failure";
		}
	};

	public abstract String getName();
}
