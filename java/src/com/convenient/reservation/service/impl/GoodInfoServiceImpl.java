package com.convenient.reservation.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.convenient.reservation.persistent.dao.GoodInfoDAO;
import com.convenient.reservation.persistent.model.GoodInfo;
import com.convenient.reservation.service.GoodInfoService;

@Service(value="goodInfoService")
public class GoodInfoServiceImpl implements GoodInfoService {
	@Resource
	private GoodInfoDAO goodInfoDAO;
	
	@Override
	public GoodInfo getGoodInfoByGoodId(String goodId) throws RuntimeException,
			Exception {
		if (null == goodId || "".equals(goodId)) {
			return null;
		} else {
			return goodInfoDAO.queryGoodInfoByGoodId(goodId);
		}
	}

}
