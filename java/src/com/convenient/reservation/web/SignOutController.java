package com.convenient.reservation.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.convenient.reservation.constant.SessionKey;

@Controller
@Scope("prototype")
public class SignOutController {

	@RequestMapping(value="/auth/signout.json", method = RequestMethod.POST)
	public void doSignOut(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (null != request.getSession() && null != request.getSession().getAttribute(SessionKey.SESSION_USER)) {
			request.getSession().removeAttribute(SessionKey.SESSION_USER);
		}
		
		System.out.println("====== sign out");
		
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().write("success");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
