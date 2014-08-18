package com.convenient.reservation.web;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.convenient.reservation.persistent.model.OrderDetailInfo;
import com.convenient.reservation.persistent.model.OrderInfo;
import com.convenient.reservation.service.OrderInfoService;

@Controller
@Scope("prototype")
public class OrderController {
	
	@Resource
	private OrderInfoService orderInfoService;
	
	@RequestMapping(value="/order/index")
	public ModelAndView doIndex(HttpServletRequest request) throws Exception { 
		ModelAndView mav = new ModelAndView();
		
		List<OrderInfo> list = orderInfoService.getOrderInfoListIsNotDone();
		
		request.setAttribute("list", list);
		
		mav.setViewName("view/order/index.jsp");
		
		return mav;
	}
	
	
	@RequestMapping(value="/order/{orderId}")
	public ModelAndView doShowDetail(HttpServletRequest request, @PathVariable String orderId) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		OrderInfo orderInfo = orderInfoService.getOrderInfoByOrderId(orderId);
		
		List<OrderDetailInfo> list = orderInfoService.getOrderDetailListByOrderId(orderId);
		
		request.setAttribute("orderInfo", orderInfo);
		request.setAttribute("list", list);
		
		mav.setViewName("view/order/detail.jsp");
		
		return mav;
	}
	
	@RequestMapping(value="/order/pay.json")
	public void doPayOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String detailId = null == request.getParameter("detailId") ? "" : request.getParameter("detailId").toString();
	
		int count = orderInfoService.updateOrderDetailInfoForIsPay(detailId);
		
		try {
			response.getWriter().write(String.valueOf(count));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	@RequestMapping(value="/order/done.json")
	public void doDoneOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String orderId = null == request.getParameter("orderId") ? "" : request.getParameter("orderId").toString();
		
		int count = orderInfoService.updateOrderInfoForIsDone(orderId);
		
		try {
			response.getWriter().write(String.valueOf(count));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	@RequestMapping(value="/order/create.json")
	public void doCreateOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int count = orderInfoService.createOrderAutomatic();
		
		try {
			response.getWriter().write(String.valueOf(count));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
