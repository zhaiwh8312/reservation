package com.convenient.reservation.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.convenient.reservation.bean.ServiceResultBean;
import com.convenient.reservation.constant.ExecResultEnum;
import com.convenient.reservation.constant.SignInErrorCode;
import com.convenient.reservation.persistent.dao.BaseUserDAO;
import com.convenient.reservation.persistent.model.BaseUser;
import com.convenient.reservation.service.SignInService;

@Service(value="signInService")
public class SignInServiceImpl implements SignInService {

	@Resource
	private BaseUserDAO baseUserDAO;
	
	@Override
	public ServiceResultBean saveSignInUser(String userId, String pwd) throws RuntimeException, Exception {
		BaseUser baseUser = baseUserDAO.queryBaseUserByUserId(userId);
		
		ServiceResultBean resultBean = new ServiceResultBean();
		
		if (null == baseUser) {
			// 用户不存在
			resultBean.setResult(ExecResultEnum.FAILURE.getName());
			resultBean.setMsg(SignInErrorCode.ERR_NONE_USER);
		} else if (baseUser.getUser_state().equals("0")) {
			// 用户已经停用
			resultBean.setResult(ExecResultEnum.FAILURE.getName());
			resultBean.setMsg(SignInErrorCode.ERR_UNABLED_USER);
		} else if (!baseUser.getUser_pwd().toLowerCase().equals(pwd.toLowerCase())) {
			// 密码错误
			resultBean.setResult(ExecResultEnum.FAILURE.getName());
			resultBean.setMsg(SignInErrorCode.ERR_WROND_PWD);
		} else {
			// 正常
			resultBean.setResult(ExecResultEnum.SUCCESS.getName());
			resultBean.setObj(baseUser);
		}
		
		return resultBean;
	}

}
