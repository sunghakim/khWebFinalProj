package com.web.mall.myinfo.model;

public class GiveCouponVO {
	private int give_coupon_id;
	private int coupon_id;
	private String account_id;
	public int getGive_coupon_id() {
		return give_coupon_id;
	}
	public void setGive_coupon_id(int give_coupon_id) {
		this.give_coupon_id = give_coupon_id;
	}
	public int getCoupon_id() {
		return coupon_id;
	}
	public void setCoupon_id(int coupon_id) {
		this.coupon_id = coupon_id;
	}
	public String getAccount_id() {
		return account_id;
	}
	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}
	@Override
	public String toString() {
		return "GiveCouponVO [give_coupon_id=" + give_coupon_id + ", coupon_id=" + coupon_id + ", account_id="
				+ account_id + "]";
	}
	
	
}
