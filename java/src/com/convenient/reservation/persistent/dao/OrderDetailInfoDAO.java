package com.convenient.reservation.persistent.dao;

import java.util.List;
import java.util.Map;

import com.convenient.reservation.persistent.model.OrderDetailInfo;

public interface OrderDetailInfoDAO {
	/**
	 * 保存订单详情
	 * @param orderDetailInfo
	 * @return
	 * @throws RuntimeException
	 */
	public int execInsertOrderDetailInfo(OrderDetailInfo orderDetailInfo) throws RuntimeException;
	
	/**
	 * 根据订单ID查询所有的订单详情
	 * @param orderId
	 * @return
	 * @throws RuntimeException
	 */
	public List<OrderDetailInfo> queryOrderDetailInfoListByOrderId(String orderId) throws RuntimeException;

	/**
	 * 
	 * @param condition
	 * @return
	 * @throws RuntimeException
	 */
	public int execUpdateOrderDetailInfoForIsPay(Map<String, String> condition) throws RuntimeException;
}
