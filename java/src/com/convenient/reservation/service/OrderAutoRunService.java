package com.convenient.reservation.service;

/**
 * 自动生成订单和自动关闭订单
 * @author zhaiwh
 *
 */
public interface OrderAutoRunService {
	/**
	 * 自动生成订单（类似团购业务）
	 * @throws RuntimeException
	 * @throws Exception
	 */
	public void createOrderAutomatic() throws RuntimeException, Exception;
	/**
	 * 自动关闭订单（类似团购业务）
	 * @throws RuntimeException
	 * @throws Exception
	 */
	public void stopOrderAutomatic() throws RuntimeException, Exception;
}
