package com.web.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Manage_CouponDTO {
	private int CouponID;
	private String Name;
	private Date StartDate;
	private Date EndDate;
	private int Discount;
	private int Amount;
	private SimpleDateFormat form = new SimpleDateFormat("yy.MM.dd");
	
	public int getCouponID() {
		return CouponID;
	}
	public void setCouponID(int couponID) {
		CouponID = couponID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public Date getStartDate() {
		return StartDate;
	}
	public String getStartDateStr() {
		return form.format(StartDate);
	}
	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}
	public Date getEndDate() {
		return EndDate;
	}
	public String getEndDateStr() {
		return form.format(EndDate);
	}
	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}
	public int getDiscount() {
		return Discount;
	}
	public void setDiscount(int discount) {
		Discount = discount;
	}
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}
	@Override
	public String toString() {
		return "Manage_CouponDTO [CouponID=" + CouponID + ", Name=" + Name + ", StartDate=" + StartDate + ", EndDate="
				+ EndDate + ", Discount=" + Discount + ", Amount=" + Amount + "]";
	}
}
