package com.web.mall.model;

public class ItemOptionSpecVO {
	private String size;
	private String color;
	private int item_id;
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "ItemOptionSpecVO [size=" + size + ", color=" + color + ", item_id=" + item_id + "]";
	}
}
