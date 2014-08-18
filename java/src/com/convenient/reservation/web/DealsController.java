package com.convenient.reservation.web;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.convenient.reservation.bean.ServiceResultBean;
import com.convenient.reservation.persistent.model.OrderInfo;
import com.convenient.reservation.service.DealsShowService;
import com.convenient.reservation.service.OrderInfoService;

@Controller
@Scope("prototype")
public class DealsController {
	
	@Resource
	private DealsShowService dealsShowService;

//	@RequestMapping(value="/deals/show.json", method = RequestMethod.GET)
//	public void doShowDeals(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		ServiceResultBean resultBean = dealsShowService.getOrderInfoListForSaleing();
//		
//		response.setContentType("text/html;charset=UTF-8");
//		
//		JSONObject jsObj = JSONObject.fromObject(resultBean);
//		
//		try {
//			response.getWriter().write(jsObj.toString());
//		} catch (IOException ex) {
//			ex.printStackTrace();
//		}
//	}
}
