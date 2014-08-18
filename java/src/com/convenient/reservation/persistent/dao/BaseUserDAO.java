package com.convenient.reservation.persistent.dao;

import com.convenient.reservation.persistent.model.BaseUser;

public interface BaseUserDAO {
	/**
	 * 根据用户ID获取用户信息
	 * @return
	 * @throws RuntimeException
	 */
	public BaseUser queryBaseUserByUserId(String userId) throws RuntimeException;
}
