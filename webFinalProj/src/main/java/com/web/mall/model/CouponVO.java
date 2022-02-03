package com.web.mall.model;

import java.sql.Date;

public class CouponVO {
	private int coupon_id;
	private String name;
	private Date start_date;
	private Date end_date;
	private int discount;
	private int amount;
	public int getCoupon_id() {
		return coupon_id;
	}
	public void setCoupon_id(int coupon_id) {
		this.coupon_id = coupon_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "CouponVO [coupon_id=" + coupon_id + ", name=" + name + ", start_date=" + start_date + ", end_date="
				+ end_date + ", discount=" + discount + ", amount=" + amount + "]";
	}
	
	
}
