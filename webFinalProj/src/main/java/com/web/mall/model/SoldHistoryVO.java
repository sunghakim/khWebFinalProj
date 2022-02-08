package com.web.mall.model;

import java.sql.Date;

public class SoldHistoryVO {
	private int sold_history_id;
	private String account_id;
	private String address;
	private String receiver_name;
	private String receiver_phone;
	private Date order_date;
	private int status;
	public int getSold_history_id() {
		return sold_history_id;
	}
	public void setSold_history_id(int sold_history_id) {
		this.sold_history_id = sold_history_id;
	}
	public String getAccount_id() {
		return account_id;
	}
	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getReceiver_name() {
		return receiver_name;
	}
	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
	}
	public String getReceiver_phone() {
		return receiver_phone;
	}
	public void setReceiver_phone(String receiver_phone) {
		this.receiver_phone = receiver_phone;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "SoldHistoryVO [sold_history_id=" + sold_history_id + ", account_id=" + account_id + ", address="
				+ address + ", receiver_name=" + receiver_name + ", receiver_phone=" + receiver_phone + ", order_date="
				+ order_date + ", status=" + status + "]";
	}
	
	
}
