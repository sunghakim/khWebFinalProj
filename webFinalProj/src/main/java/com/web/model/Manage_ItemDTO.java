package com.web.model;

public class Manage_ItemDTO extends Manage_ItemCategoryDTO{
	//Item
	private int ItemID;
	private String Name;
	private String Content;
	private int Price;
	//Item_Option
	private int ItemOptionID;
	private String ItemSize;
	private String Color;
	private int Amount;
	
	public int getItemID() {
		return ItemID;
	}

	public void setItemID(int itemID) {
		ItemID = itemID;
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

	public int getItemOptionID() {
		return ItemOptionID;
	}

	public void setItemOptionID(int itemOptionID) {
		ItemOptionID = itemOptionID;
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
		return "Manage_ItemDTO [ItemID=" + ItemID + ", Name=" + Name + ", Content=" + Content + ", Price=" + Price + 
				", ItemOptionID=" + ItemOptionID + ", ItemSize=" + ItemSize + ", Color=" + Color + 
				", Amount="	+ Amount + "ItemCategoryID=" + ItemCategoryID + ", ItemCategoryName=" + ItemCategoryName + 
				", NavShow=" + NavShow + "]";
	}
}
