package com.convenient.reservation.persistent.dao;

import java.util.List;
import java.util.Map;

import com.convenient.reservation.persistent.model.OrderInfo;

public interface OrderInfoDAO {
	/**
	 * 保存订单主表信息
	 * @param orderInfo
	 * @return
	 * @throws RuntimeException
	 */
	public int execInsertOrderInfo(OrderInfo orderInfo) throws RuntimeException;
	
	/**
	 * 获取当前可以关闭的订单
	 * @param condition
	 * @return
	 * @throws RuntimeException
	 */
	public List<OrderInfo> queryOrderInfoForTimeToClose(Map<String, String> condition) throws RuntimeException;

	/**
	 * 修改订单
	 * @param orderInfo
	 * @return
	 * @throws RuntimeException
	 */
	public int execUpdateOrderInfo(OrderInfo orderInfo) throws RuntimeException;
	
	/**
	 * 根据订单ID查询订单信息
	 * @param orderId
	 * @return
	 * @throws RuntimeException
	 */
	public OrderInfo queryOrderInfoByOrderId(String orderId) throws RuntimeException;
	
	/**
	 * 查询出正在卖的订单
	 * @param condition
	 * @return
	 * @throws RuntimeException
	 */
	public List<OrderInfo> queryOrderInfoListByOrderStatus(String orderStatus) throws RuntimeException; 

	/**
	 * 
	 * @param isDone
	 * @return
	 * @throws RuntimeException
	 */
	public List<OrderInfo> queryOrderInfoListIsDoneStatus(String isDone) throws RuntimeException;
	
	/**
	 * 更新订单金额
	 * @param condition
	 * @return
	 * @throws RuntimeException
	 */
	public int execUpdateOrderInfoForAmount(Map<String, Object> condition) throws RuntimeException;
	
	/**
	 * 查询所有订单
	 * @return
	 * @throws RuntimeException
	 */
	public List<OrderInfo> queryOrderInfoForAll() throws RuntimeException; 
	
	public int execUpdateOrderInfoForIsDone(Map<String, String> condition) throws RuntimeException;
}
