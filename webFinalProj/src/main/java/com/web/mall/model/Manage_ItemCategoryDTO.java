package com.web.mall.model;

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
			return "νμ";
		} else if (NavShow == 'F') {
			return "μ¨κΉ";
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
