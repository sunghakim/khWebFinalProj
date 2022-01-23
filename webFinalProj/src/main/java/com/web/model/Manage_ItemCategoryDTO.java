package com.web.model;

public class Manage_ItemCategoryDTO {
	private int ItemCategoryID;
	private String Name;
	private char NavShow;
	public int getItemCategoryID() {
		return ItemCategoryID;
	}
	public void setItemCategoryID(int itemCategoryID) {
		ItemCategoryID = itemCategoryID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public char isNavShow() {
		return NavShow;
	}
	public void setNavShow(char navShow) {
		NavShow = navShow;
	}
	@Override
	public String toString() {
		return "Manage_ItemCategoryDTO [ItemCategoryID=" + ItemCategoryID + ", Name=" + Name + ", NavShow=" + NavShow + "]";
	}
}
