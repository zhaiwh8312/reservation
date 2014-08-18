package com.convenient.reservation.persistent.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.convenient.base.dao.BaseDAO;
import com.convenient.reservation.persistent.dao.ReservationInfoDAO;
import com.convenient.reservation.persistent.model.ReservationInfo;

@Repository(value="reservationInfoDAO")
public class ReservationInfoDAOImpl extends BaseDAO implements ReservationInfoDAO {

	@Override
	public List<ReservationInfo> queryReservationListForReadyToBook(Map<String, String> condition)
			throws RuntimeException {
		return this.getSqlSession().selectList("ReservationInfo.queryReservationListForReadyToBook", condition);
	}

}
