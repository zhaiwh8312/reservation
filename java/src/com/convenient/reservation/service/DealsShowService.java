package com.convenient.reservation.service;

import java.util.List;

import com.convenient.reservation.bean.ServiceResultBean;
import com.convenient.reservation.persistent.model.OrderInfo;

public interface DealsShowService {
	/**
	 * 查询出所有在售的订单
	 * @return
	 * @throws RuntimeException
	 * @throws Exception
	 */
	public List<OrderInfo> getAllDealsListForSaleing() throws RuntimeException, Exception;
}
