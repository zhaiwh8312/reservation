package com.convenient.reservation.web;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.convenient.reservation.bean.ServiceResultBean;
import com.convenient.reservation.constant.ExecResultEnum;
import com.convenient.reservation.constant.SessionKey;
import com.convenient.reservation.service.SignInService;

@Controller
@Scope("prototype")
public class SignInController {
	
	@Resource
	private SignInService signInService;
	
	@RequestMapping(value="/auth/signin.json", method = RequestMethod.POST)
	public void doSignIn(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = null == request.getParameter("loginName") ? "" : request.getParameter("loginName").toString();
		String pwd = null == request.getParameter("password") ? "" : request.getParameter("password").toString();
		
		ServiceResultBean resultBean = signInService.saveSignInUser(userId, pwd);
		
		if (ExecResultEnum.SUCCESS.getName().equals(resultBean.getResult())) {
			// 登录成功
			request.getSession().setAttribute(SessionKey.SESSION_USER, resultBean.getObj());
		}
		
		JSONObject jsObj = JSONObject.fromObject(resultBean);
		
		try {
			response.getWriter().write(jsObj.toString());
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
