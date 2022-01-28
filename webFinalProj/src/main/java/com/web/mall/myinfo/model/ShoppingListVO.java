package com.web.mall.myinfo.model;

public class ShoppingListVO {
	private int shopping_list_id;
	private String account_id;
	private int item_id;
	private int amount;
	private int item_option_id;
	public int getShopping_list_id() {
		return shopping_list_id;
	}
	public void setShopping_list_id(int shopping_list_id) {
		this.shopping_list_id = shopping_list_id;
	}
	public String getAccount_id() {
		return account_id;
	}
	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getItem_option_id() {
		return item_option_id;
	}
	public void setItem_option_id(int item_option_id) {
		this.item_option_id = item_option_id;
	}
	@Override
	public String toString() {
		return "ShoppingListVO [shopping_list_id=" + shopping_list_id + ", account_id=" + account_id + ", item_id="
				+ item_id + ", amount=" + amount + ", item_option_id=" + item_option_id + "]";
	}
	
	
}
