package com.convenient.reservation.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.convenient.base.tools.GenerateUUID;
import com.convenient.reservation.persistent.dao.OrderDetailInfoDAO;
import com.convenient.reservation.persistent.dao.OrderInfoDAO;
import com.convenient.reservation.persistent.model.OrderDetailInfo;
import com.convenient.reservation.persistent.model.OrderInfo;
import com.convenient.reservation.service.OrderInfoService;

@Service(value="orderInfoService")
public class OrderInfoServiceImpl implements OrderInfoService {

	@Resource
	private OrderInfoDAO orderInfoDAO;
	@Resource
	private OrderDetailInfoDAO orderDetailInfoDAO;
	
	@Override
	public List<OrderInfo> getOrderInfoListForSaleing() throws RuntimeException, Exception {
		String orderStatus = "1";
		
		return orderInfoDAO.queryOrderInfoListByOrderStatus(orderStatus);
	}

	@Override
	public List<OrderInfo> getOrderInfoListIsNotDone() throws RuntimeException, Exception {
		String isDone = "0";
		
		return orderInfoDAO.queryOrderInfoListIsDoneStatus(isDone);
	}

	@Override
	public OrderInfo getOrderInfoByOrderId(String orderId) throws RuntimeException, Exception {
		return orderInfoDAO.queryOrderInfoByOrderId(orderId);
	}

	@Override
	public List<OrderDetailInfo> getOrderDetailListByOrderId(String orderId)
			throws RuntimeException, Exception {
		return orderDetailInfoDAO.queryOrderDetailInfoListByOrderId(orderId);
	}

	@Override
	public int updateOrderDetailInfoForIsPay(String detailId)
			throws RuntimeException, Exception {
		Map<String, String> condition = new HashMap<String, String>();
		
		condition.put("detailId", detailId);
		condition.put("isPay", "1");
		
		return orderDetailInfoDAO.execUpdateOrderDetailInfoForIsPay(condition);
	}

	@Override
	public int updateOrderInfoForIsDone(String orderId)
			throws RuntimeException, Exception {
		Map<String, String> condition = new HashMap<String, String>();
		
		condition.put("orderId", orderId);
		condition.put("isDone", "1");
		
		return orderInfoDAO.execUpdateOrderInfoForIsDone(condition);
	}

	@Override
	public int createOrderAutomatic() throws RuntimeException, Exception {
		OrderInfo orderInfo = new OrderInfo();
		
		orderInfo.setOrder_id(GenerateUUID.getInstance().getUUID());
		orderInfo.setOrder_name("中午快餐");
		orderInfo.setReservation_id("1");
		orderInfo.setGood_id("1");
		orderInfo.setOrder_create_time(new Date().toLocaleString());
		orderInfo.setOrder_amount(0.0d);
		orderInfo.setOrder_status("1");
		orderInfo.setIs_done("0");
		
		return orderInfoDAO.execInsertOrderInfo(orderInfo);
	}

}
