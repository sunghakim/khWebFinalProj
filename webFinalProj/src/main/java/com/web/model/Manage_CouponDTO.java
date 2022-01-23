package com.web.model;

public class Manage_CouponDTO {
	private int Number;
	private String name;
	private String StartDate;
	private String EndDate;
	private int Discount;
	private int Amount;
	
	public int getNumber() {
		return Number;
	}
	public void setNumber(int number) {
		Number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStartDate() {
		return StartDate;
	}
	public void setStartDate(String startDate) {
		StartDate = startDate;
	}
	public String getEndDate() {
		return EndDate;
	}
	public void setEndDate(String endDate) {
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
		return "Manage_CouponDTO [Number=" + Number + ", name=" + name + ", StartDate=" + StartDate + ", EndDate="
				+ EndDate + ", Discount=" + Discount + ", Amount=" + Amount + "]";
	}
}
