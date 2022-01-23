package com.web.model;

public class Manage_ItemCategoryDTO {
	private int ID;
	private String Name;
	private boolean NavShow = false;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public boolean isNavShow() {
		return NavShow;
	}
	public void setNavShow(boolean navShow) {
		NavShow = navShow;
	}
	
	
}
