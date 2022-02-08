package com.web.mall.model;

import java.sql.Date;

public class SoldDetailVO {
	private int sold_detail_id;
	private int item_id;
	private int sold_history_id;
	private int amount;
	private int item_option_id;
	private int is_refund;
	private Date refund_ask_date;
	private String refund_reason;
	private int refund_status;
	private Date refund_end_date;
	
	public int getSold_detail_id() {
		return sold_detail_id;
	}
	public void setSold_detail_id(int sold_detail_id) {
		this.sold_detail_id = sold_detail_id;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public int getSold_history_id() {
		return sold_history_id;
	}
	public void setSold_history_id(int sold_history_id) {
		this.sold_history_id = sold_history_id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getItem_option_id() {
		return item_option_id;
	}
	public void setItem_option_id(int item_option_id) {
		this.item_option_id = item_option_id;
	}
	public int getIs_refund() {
		return is_refund;
	}
	public void setIs_refund(int is_refund) {
		this.is_refund = is_refund;
	}
	public Date getRefund_ask_date() {
		return refund_ask_date;
	}
	public void setRefund_ask_date(Date refund_ask_date) {
		this.refund_ask_date = refund_ask_date;
	}
	public String getRefund_reason() {
		return refund_reason;
	}
	public void setRefund_reason(String refund_reason) {
		this.refund_reason = refund_reason;
	}
	public int getRefund_status() {
		return refund_status;
	}
	public void setRefund_status(int refund_status) {
		this.refund_status = refund_status;
	}
	public Date getRefund_end_date() {
		return refund_end_date;
	}
	public void setRefund_end_date(Date refund_end_date) {
		this.refund_end_date = refund_end_date;
	}
	@Override
	public String toString() {
		return "SoldDetailVO [sold_detail_id=" + sold_detail_id + ", item_id=" + item_id + ", sold_history_id="
				+ sold_history_id + ", amount=" + amount + ", item_option_id=" + item_option_id + ", is_refund="
				+ is_refund + ", refund_ask_date=" + refund_ask_date + ", refund_reason=" + refund_reason
				+ ", refund_status=" + refund_status + ", refund_end_date=" + refund_end_date + "]";
	}
	
	
}
