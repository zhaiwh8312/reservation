package com.convenient.reservation.web;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.convenient.reservation.constant.SessionKey;
import com.convenient.reservation.persistent.model.BaseUser;
import com.convenient.reservation.service.BookingService;

@Controller
@Scope("prototype")
public class BookingController {

	@Resource
	private BookingService bookingService;
	
	@RequestMapping(value="/book/booking.json", method = RequestMethod.POST)
	public void doBooking(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = ((BaseUser)request.getSession().getAttribute(SessionKey.SESSION_USER)).getUser_id();
		String orderId = request.getParameter("orderId").toString();
		String demand = request.getParameter("demand").toString();
		int copy = Integer.parseInt(request.getParameter("copy").toString());
		
		String result = bookingService.addBookTheOrder(orderId, userId, copy, demand);
		
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().write(result);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
