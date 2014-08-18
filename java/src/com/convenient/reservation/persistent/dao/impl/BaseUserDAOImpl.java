package com.convenient.reservation.persistent.dao.impl;

import org.springframework.stereotype.Repository;

import com.convenient.base.dao.BaseDAO;
import com.convenient.reservation.persistent.dao.BaseUserDAO;
import com.convenient.reservation.persistent.model.BaseUser;

@Repository(value="baseUserDAO")
public class BaseUserDAOImpl extends BaseDAO implements BaseUserDAO {

	@Override
	public BaseUser queryBaseUserByUserId(String userId)
			throws RuntimeException {
		return this.getSqlSession().selectOne("BaseUser.queryBaseUserByUserId", userId);
	}

}
