package com.web.model;

public class Manage_ItemCategoryDTO {
	protected int ItemCategoryID;
	protected String ItemCategoryName;
	protected char NavShow;
	
	public int getItemCategoryID() {
		return ItemCategoryID;
	}
	public void setItemCategoryID(int itemCategoryID) {
		ItemCategoryID = itemCategoryID;
	}
	public String getItemCategoryName() {
		return ItemCategoryName;
	}
	public void setItemCategoryName(String itemCategoryName) {
		ItemCategoryName = itemCategoryName;
	}
	public char getNavShow() {
		return NavShow;
	}
	public String getNavShowStr() {
		if (NavShow == 'T') {
			return "표시";
		} else if (NavShow == 'F') {
			return "숨김";
		} else {
			return "error";
		}
	}
	public void setNavShow(char navShow) {
		NavShow = navShow;
	}
	
	@Override
	public String toString() {
		return "Manage_ItemCategoryDTO [ItemCategoryID=" + ItemCategoryID + 
				", ItemCategoryName=" + ItemCategoryName + ", NavShow=" + NavShow + "]";
	}
}
