package com.convenient.reservation.persistent.model;

/**
 * 订单
 * 
 * @author zhaiwh
 * 
 */
public class OrderInfo {
	private String order_id;
	private String order_name;
	private String reservation_id;
	private String good_id;
	private String order_create_time;
	private String order_end_time;
	private double order_amount;
	private String order_status;
	private String is_done;

	private String good_pic_url;
	private String good_description;

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getOrder_name() {
		return order_name;
	}

	public void setOrder_name(String order_name) {
		this.order_name = order_name;
	}

	public String getReservation_id() {
		return reservation_id;
	}

	public void setReservation_id(String reservation_id) {
		this.reservation_id = reservation_id;
	}

	public String getGood_id() {
		return good_id;
	}

	public void setGood_id(String good_id) {
		this.good_id = good_id;
	}

	public String getOrder_create_time() {
		return order_create_time;
	}

	public void setOrder_create_time(String order_create_time) {
		this.order_create_time = order_create_time;
	}

	public String getOrder_end_time() {
		return order_end_time;
	}

	public void setOrder_end_time(String order_end_time) {
		this.order_end_time = order_end_time;
	}

	public double getOrder_amount() {
		return order_amount;
	}

	public void setOrder_amount(double order_amount) {
		this.order_amount = order_amount;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public String getGood_pic_url() {
		return good_pic_url;
	}

	public void setGood_pic_url(String good_pic_url) {
		this.good_pic_url = good_pic_url;
	}

	public String getGood_description() {
		return good_description;
	}

	public void setGood_description(String good_description) {
		this.good_description = good_description;
	}

	public String getIs_done() {
		return is_done;
	}

	public void setIs_done(String is_done) {
		this.is_done = is_done;
	}

}
