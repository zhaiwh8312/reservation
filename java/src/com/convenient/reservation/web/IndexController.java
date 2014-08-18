package com.convenient.reservation.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.convenient.reservation.bean.ServiceResultBean;
import com.convenient.reservation.persistent.model.OrderInfo;
import com.convenient.reservation.service.DealsShowService;

@Controller
@Scope("prototype")
public class IndexController {
	
	@Resource
	private DealsShowService dealsShowService;
	
	@RequestMapping(value="/index")
	public ModelAndView doIndex(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		List<OrderInfo> list = dealsShowService.getAllDealsListForSaleing();
		
		request.setAttribute("list", list);
		
		mav.setViewName("view/reservation/index.jsp");
		
		return mav;
	}
	
}
