package com.convenient.reservation.persistent.model;

/**
 * 
 * @author zhaiwh
 * 
 */
public class ReservationInfo {
	private String reservation_id;
	private String reservation_title;
	private String good_id;
	private String book_start_date;
	private String book_end_date;
	private String book_start_time;
	private String book_end_time;
	private int is_repeat;
	private String create_time;
	private String create_user_id;
	private String reservation_status;

	public String getReservation_id() {
		return reservation_id;
	}

	public void setReservation_id(String reservation_id) {
		this.reservation_id = reservation_id;
	}

	public String getReservation_title() {
		return reservation_title;
	}

	public void setReservation_title(String reservation_title) {
		this.reservation_title = reservation_title;
	}

	public String getGood_id() {
		return good_id;
	}

	public void setGood_id(String good_id) {
		this.good_id = good_id;
	}

	public String getBook_start_date() {
		return book_start_date;
	}

	public void setBook_start_date(String book_start_date) {
		this.book_start_date = book_start_date;
	}

	public String getBook_end_date() {
		return book_end_date;
	}

	public void setBook_end_date(String book_end_date) {
		this.book_end_date = book_end_date;
	}

	public String getBook_start_time() {
		return book_start_time;
	}

	public void setBook_start_time(String book_start_time) {
		this.book_start_time = book_start_time;
	}

	public String getBook_end_time() {
		return book_end_time;
	}

	public void setBook_end_time(String book_end_time) {
		this.book_end_time = book_end_time;
	}

	public int getIs_repeat() {
		return is_repeat;
	}

	public void setIs_repeat(int is_repeat) {
		this.is_repeat = is_repeat;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getCreate_user_id() {
		return create_user_id;
	}

	public void setCreate_user_id(String create_user_id) {
		this.create_user_id = create_user_id;
	}

	public String getReservation_status() {
		return reservation_status;
	}

	public void setReservation_status(String reservation_status) {
		this.reservation_status = reservation_status;
	}

}
