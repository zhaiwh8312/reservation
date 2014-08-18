package com.convenient.reservation.persistent.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.convenient.base.dao.BaseDAO;
import com.convenient.reservation.persistent.dao.OrderDetailInfoDAO;
import com.convenient.reservation.persistent.model.OrderDetailInfo;

@Repository(value="orderDetailInfoDAO")
public class OrderDetailInfoDAOImpl extends BaseDAO implements
		OrderDetailInfoDAO {

	@Override
	public int execInsertOrderDetailInfo(OrderDetailInfo orderDetailInfo)
			throws RuntimeException {
		return this.getSqlSession().insert("OrderDetailInfo.execInsertOrderDetailInfo", orderDetailInfo);
	}

	@Override
	public List<OrderDetailInfo> queryOrderDetailInfoListByOrderId(String orderId) throws RuntimeException {
		return this.getSqlSession().selectList("OrderDetailInfo.queryOrderDetailInfoListByOrderId", orderId);
	}

	@Override
	public int execUpdateOrderDetailInfoForIsPay(Map<String, String> condition) throws RuntimeException {
		return this.getSqlSession().update("OrderDetailInfo.execUpdateOrderDetailInfoForIsPay", condition);
	}

}
