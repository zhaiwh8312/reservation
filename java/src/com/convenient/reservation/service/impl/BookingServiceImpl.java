package com.convenient.reservation.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.convenient.base.tools.GenerateUUID;
import com.convenient.reservation.persistent.dao.OrderDetailInfoDAO;
import com.convenient.reservation.persistent.dao.OrderInfoDAO;
import com.convenient.reservation.persistent.model.OrderDetailInfo;
import com.convenient.reservation.persistent.model.OrderInfo;
import com.convenient.reservation.service.BookingService;

@Service(value="bookingService")
public class BookingServiceImpl implements BookingService {

	@Resource
	private OrderInfoDAO orderInfoDAO;
	@Resource
	private OrderDetailInfoDAO orderDetailInfoDAO;
	
	@Override
	public String addBookTheOrder(String orderId, String userId, int copy, String demand) throws RuntimeException,
			Exception {
		/**
		 * 查询订单是否正常，如果正常则可以下订单，如果订单已经关闭则不可以下订单
		 * 
		 * 
		 */
		OrderInfo order = orderInfoDAO.queryOrderInfoByOrderId(orderId);
		
		if (null != order) {
			// 订单状态正常
			if (order.getOrder_status().equals("1")) {
//				double orderAmount = order.getOrder_amount();
//				orderAmount += 10 * copy;
//				order.setOrder_amount(orderAmount);
//				orderInfoDAO.execUpdateOrderInfo(order);
				
				Map<String, Object> condition = new HashMap<String, Object>();
				
				condition.put("money", 10 * copy);
				condition.put("orderId", order.getOrder_id());
				
				orderInfoDAO.execUpdateOrderInfoForAmount(condition);
				
				OrderDetailInfo orderDetail = new OrderDetailInfo();
				orderDetail.setDetail_id(GenerateUUID.getInstance().getUUID());
				orderDetail.setOrder_id(order.getOrder_id());
				orderDetail.setUser_id(userId);
				orderDetail.setCopy(copy);
				orderDetail.setBook_time(new Date().toLocaleString());
				orderDetail.setDemand(demand);
				orderDetail.setIs_pay("0");
				
				orderDetailInfoDAO.execInsertOrderDetailInfo(orderDetail);
				
				return "SUCCESS";
			} else {
				return "FAIL";
			}
		} else {
			return "FAIL";
		}
	}
}
