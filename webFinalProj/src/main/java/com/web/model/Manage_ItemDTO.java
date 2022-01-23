package com.web.model;

public class Manage_ItemDTO {
	private String ID;
	private String Category;
	private String Name;
	private String Content;
	private int Price;
	private String ItemSize;
	private String Color;
	private int Amount;
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public String getItemSize() {
		return ItemSize;
	}
	public void setItemSize(String itemSize) {
		ItemSize = itemSize;
	}
	public String getColor() {
		return Color;
	}
	public void setColor(String color) {
		Color = color;
	}
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}
	@Override
	public String toString() {
		return "Manage_ItemDTO [ID=" + ID + ", Category=" + Category + ", Name=" + Name + ", Content=" + Content
				+ ", Price=" + Price + ", ItemSize=" + ItemSize + ", Color=" + Color + ", Amount=" + Amount + "]";
	}
}
