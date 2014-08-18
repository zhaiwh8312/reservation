package com.convenient.reservation.service;

import com.convenient.reservation.bean.ServiceResultBean;

/**
 * 登录
 * @author zhaiwh
 *
 */
public interface SignInService {
	/**
	 * 验证登录人
	 * @param userId
	 * @param pwd
	 * @throws RuntimeException
	 * @throws Exception
	 */
	public ServiceResultBean saveSignInUser(String userId, String pwd) throws RuntimeException, Exception;
}
