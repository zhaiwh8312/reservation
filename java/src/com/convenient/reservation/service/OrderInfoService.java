package com.convenient.reservation.service;

import java.util.List;
import java.util.Map;

import com.convenient.reservation.persistent.model.OrderDetailInfo;
import com.convenient.reservation.persistent.model.OrderInfo;

public interface OrderInfoService {
	/**
	 * 获取正在买的订单
	 * @return
	 * @throws RuntimeException
	 * @throws Exception
	 */
	public List<OrderInfo> getOrderInfoListForSaleing() throws RuntimeException, Exception;
	
	/**
	 * 获取所有还未处理完毕的订单
	 * @throws RuntimeException
	 * @throws Exception
	 */
	public List<OrderInfo> getOrderInfoListIsNotDone() throws RuntimeException, Exception;
	
	/**
	 * 获取所有订单
	 * @return
	 * @throws RuntimeException
	 * @throws Exception
	 */
	public List<OrderInfo> getOrderInfoAllList() throws RuntimeException, Exception;
	
	/**
	 * 根据订单ID获取订单信息
	 * @param orderId
	 * @return
	 * @throws RuntimeException
	 * @throws Exception
	 */
	public OrderInfo getOrderInfoByOrderId(String orderId) throws RuntimeException, Exception;
	
	/**
	 * 根据订单ID获取订单详细信息
	 * @param orderId
	 * @return
	 * @throws RuntimeException
	 * @throws Exception
	 */
	public List<OrderDetailInfo> getOrderDetailListByOrderId(String orderId) throws RuntimeException, Exception;

	/**
	 * 
	 * @param detailId
	 * @return
	 * @throws RuntimeException
	 * @throws Exception
	 */
	public int updateOrderDetailInfoForIsPay(String detailId) throws RuntimeException, Exception;
	
	/**
	 * 
	 * @param orderId
	 * @return
	 * @throws RuntimeException
	 * @throws Exception
	 */
	public int updateOrderInfoForIsDone(String orderId) throws RuntimeException, Exception;
	
	/**
	 * 
	 * @return
	 * @throws RuntimeException
	 * @throws Exception
	 */
	public int createOrderAutomatic() throws RuntimeException, Exception;
}
