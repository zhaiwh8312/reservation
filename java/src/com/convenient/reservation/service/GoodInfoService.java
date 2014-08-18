package com.convenient.reservation.service;

import com.convenient.reservation.persistent.model.GoodInfo;

public interface GoodInfoService {
	/**
	 * 根据商品ID获取商品信息
	 * @param goodId
	 * @return
	 * @throws RuntimeException
	 * @throws Exception
	 */
	public GoodInfo getGoodInfoByGoodId(String goodId) throws RuntimeException, Exception;
}
