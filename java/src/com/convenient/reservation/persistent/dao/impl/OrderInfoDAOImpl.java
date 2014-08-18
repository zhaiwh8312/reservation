package com.convenient.reservation.persistent.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.convenient.base.dao.BaseDAO;
import com.convenient.reservation.persistent.dao.OrderInfoDAO;
import com.convenient.reservation.persistent.model.OrderInfo;

@Repository(value="orderInfoDAO")
public class OrderInfoDAOImpl extends BaseDAO implements OrderInfoDAO {

	@Override
	public int execInsertOrderInfo(OrderInfo orderInfo) throws RuntimeException {
		return this.getSqlSession().insert("OrderInfo.execInsertOrderInfo", orderInfo);
	}

	@Override
	public List<OrderInfo> queryOrderInfoForTimeToClose(
			Map<String, String> condition) throws RuntimeException {
		return this.getSqlSession().selectList("OrderInfo.queryOrderInfoForTimeToClose", condition);
	}

	@Override
	public int execUpdateOrderInfo(OrderInfo orderInfo) throws RuntimeException {
		return this.getSqlSession().update("OrderInfo.execUpdateOrderInfo", orderInfo);
	}

	@Override
	public OrderInfo queryOrderInfoByOrderId(String orderId) throws RuntimeException {
		return this.getSqlSession().selectOne("OrderInfo.queryOrderInfoByOrderId", orderId);
	}

	@Override
	public List<OrderInfo> queryOrderInfoListByOrderStatus(String orderStatus) throws RuntimeException {
		return this.getSqlSession().selectList("OrderInfo.queryOrderInfoListByOrderStatus", orderStatus);
	}

	@Override
	public int execUpdateOrderInfoForAmount(Map<String, Object> condition)
			throws RuntimeException {
		return this.getSqlSession().update("OrderInfo.execUpdateOrderInfoForAmount", condition);
	}

	@Override
	public List<OrderInfo> queryOrderInfoForAll() throws RuntimeException {
		return this.getSqlSession().selectList("OrderInfo.queryOrderInfoForAll");
	}

	@Override
	public List<OrderInfo> queryOrderInfoListIsDoneStatus(String isDone) throws RuntimeException {
		return this.getSqlSession().selectList("OrderInfo.queryOrderInfoListIsDoneStatus", isDone);
	}

	@Override
	public int execUpdateOrderInfoForIsDone(Map<String, String> condition)
			throws RuntimeException {
		return this.getSqlSession().update("OrderInfo.execUpdateOrderInfoForIsDone", condition);
	}
	
}
