package com.convenient.reservation.persistent.dao;

import java.util.List;
import java.util.Map;

import com.convenient.reservation.persistent.model.GoodInfo;

public interface GoodInfoDAO {
	/**
	 * 获取当前可以生成预定订单的商品
	 * @return
	 * @throws RuntimeException
	 */
	public List<GoodInfo> queryGoodListForReadToBook(Map<String, String> condition) throws RuntimeException;

	/**
	 * 根据商品ID获取商品信息
	 * @param goodId
	 * @return
	 * @throws RuntimeException
	 */
	public GoodInfo queryGoodInfoByGoodId(String goodId) throws RuntimeException;
}
