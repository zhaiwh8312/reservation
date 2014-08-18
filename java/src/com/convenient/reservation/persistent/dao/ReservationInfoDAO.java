package com.convenient.reservation.persistent.dao;

import java.util.List;
import java.util.Map;

import com.convenient.reservation.persistent.model.ReservationInfo;

/**
 * 预订单
 * @author zhaiwh
 *
 */
public interface ReservationInfoDAO {
	/**
	 * 获取当前可以生成订单的预订单
	 * @return
	 * @throws RuntimeException
	 */
	public List<ReservationInfo> queryReservationListForReadyToBook(Map<String, String> condition) throws RuntimeException;
}
