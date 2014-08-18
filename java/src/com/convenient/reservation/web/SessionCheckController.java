package com.convenient.reservation.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.convenient.reservation.constant.SessionKey;
import com.convenient.reservation.persistent.model.BaseUser;

@Controller
@Scope("prototype")
public class SessionCheckController {

	@RequestMapping(value="/auth/session.json", method = RequestMethod.POST)
	public void doSessionCheck(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = "";
		
		if (null != request.getSession() && null != request.getSession().getAttribute("user")) {
			userId = ((BaseUser)request.getSession().getAttribute(SessionKey.SESSION_USER)).getUser_id();
		}
		
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().write(userId);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
