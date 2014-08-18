package com.convenient.reservation.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.convenient.base.tools.DateUtil;
import com.convenient.base.tools.GenerateUUID;
import com.convenient.reservation.persistent.dao.GoodInfoDAO;
import com.convenient.reservation.persistent.dao.OrderInfoDAO;
import com.convenient.reservation.persistent.dao.ReservationInfoDAO;
import com.convenient.reservation.persistent.model.OrderInfo;
import com.convenient.reservation.persistent.model.ReservationInfo;
import com.convenient.reservation.service.OrderAutoRunService;

@Service(value="orderAutoRunService")
public class OrderAutoRunServiceImpl implements OrderAutoRunService {

	@Resource
	private GoodInfoDAO goodInfoDAO;
	@Resource
	private ReservationInfoDAO reservationInfoDAO;
	@Resource
	private OrderInfoDAO orderInfoDAO;
	
	@Override
	public void createOrderAutomatic() throws RuntimeException, Exception {
		/**
		 * 查询预定单设置信息，获取可以生成订单的预订单列表
		 * 可以生成订单的预定单必须符合以下要求：
		 * 1.商品可以正常上架（状态正常）
		 * 2.预订单状态正常
		 * 3.符合条件2的预订单没有生成订单（在此订单未关闭的情况下，不再生成新的订单）
		 * 
		 */
		Map<String, String> condition = new HashMap<String, String>();
		
		condition.put("reservationStatus", "1");
		condition.put("nowTime", DateUtil.getCurrentDateTime());
		condition.put("orderStatus", "1");
		
		List<ReservationInfo> list = reservationInfoDAO.queryReservationListForReadyToBook(condition);
		
		for (ReservationInfo reservation : list) {
			OrderInfo orderInfo = new OrderInfo();
			
			orderInfo.setOrder_id(GenerateUUID.getInstance().getUUID());
			orderInfo.setOrder_name(reservation.getReservation_title());
			orderInfo.setReservation_id(reservation.getReservation_id());
			orderInfo.setGood_id(reservation.getGood_id());
			orderInfo.setOrder_create_time(DateUtil.getCurrentDateTime());
			orderInfo.setOrder_amount(0.0d);
			orderInfo.setOrder_status("1");
			
			orderInfoDAO.execInsertOrderInfo(orderInfo);
		}
		
	}

	@Override
	public void stopOrderAutomatic() throws RuntimeException, Exception {
		/**
		 * 查询出订单到期的订单号，将订单状态修改为关闭
		 * 可以关闭的订单必须符合以下要求：
		 * 1.订单的关闭时间小于当前时间
		 * 
		 */
		Map<String, String> condition = new HashMap<String, String>();
		
		condition.put("nowTime", DateUtil.getCurrentDateTime());
		condition.put("orderStatus", "1");
		
		List<OrderInfo> list = orderInfoDAO.queryOrderInfoForTimeToClose(condition);
		
		for (OrderInfo order : list) {
			order.setOrder_end_time(DateUtil.getCurrentDateTime());
			order.setOrder_status("0");
			
			orderInfoDAO.execUpdateOrderInfo(order);
		}
	}

}
