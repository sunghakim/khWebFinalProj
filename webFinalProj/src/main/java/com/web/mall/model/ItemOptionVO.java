package com.web.mall.model;

public class ItemOptionVO {
	private int item_option_id;
	private int item_id;
	private String item_size;
	private String color;
	private int amount;
	public int getItem_option_id() {
		return item_option_id;
	}
	public void setItem_option_id(int item_option_id) {
		this.item_option_id = item_option_id;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getItem_size() {
		return item_size;
	}
	public void setItem_size(String item_size) {
		this.item_size = item_size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "ItemOptionVO [item_option_id=" + item_option_id + ", item_id=" + item_id + ", item_size=" + item_size
				+ ", color=" + color + ", amount=" + amount + "]";
	}
	
	
}
