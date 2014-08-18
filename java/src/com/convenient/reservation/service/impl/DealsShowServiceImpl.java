package com.convenient.reservation.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.convenient.reservation.bean.ServiceResultBean;
import com.convenient.reservation.constant.ExecResultEnum;
import com.convenient.reservation.persistent.dao.OrderInfoDAO;
import com.convenient.reservation.persistent.model.OrderInfo;
import com.convenient.reservation.service.DealsShowService;

@Service(value="dealsShowService")
public class DealsShowServiceImpl implements DealsShowService {

	@Resource
	private OrderInfoDAO orderInfoDAO;
	
	@Override
	public List<OrderInfo> getAllDealsListForSaleing() throws RuntimeException, Exception {
		Map<String, String> condition = new HashMap<String, String>();
		
		condition.put("orderStatus", "1");
		
		return orderInfoDAO.queryOrderInfoListByOrderStatus("1");
	}

}
