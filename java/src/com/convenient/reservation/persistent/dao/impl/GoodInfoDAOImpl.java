package com.convenient.reservation.persistent.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.convenient.base.dao.BaseDAO;
import com.convenient.reservation.persistent.dao.GoodInfoDAO;
import com.convenient.reservation.persistent.model.GoodInfo;

@Repository(value="goodInfoDAO")
public class GoodInfoDAOImpl extends BaseDAO implements GoodInfoDAO {

	@Override
	public List<GoodInfo> queryGoodListForReadToBook(Map<String, String> condition) throws RuntimeException {
		return this.getSqlSession().selectList("GoodInfo.queryGoodListForReadToBook", condition);
	}

	@Override
	public GoodInfo queryGoodInfoByGoodId(String goodId)
			throws RuntimeException {
		return this.getSqlSession().selectOne("GoodInfo.queryGoodInfoByGoodId", goodId);
	}
	
}
