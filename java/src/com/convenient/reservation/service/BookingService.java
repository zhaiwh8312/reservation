package com.convenient.reservation.service;

public interface BookingService {
	public String addBookTheOrder(String orderId, String userId, int copy, String demand) throws RuntimeException, Exception;
}
