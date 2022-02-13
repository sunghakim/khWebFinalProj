package com.web.mall.model;

public class ItemDTO {
	private int item_id;
	private int item_category_id;
	private String name;
	private String content;
	private int price;
	private String file_name;
	private String file_url;
	
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public int getItem_category_id() {
		return item_category_id;
	}
	public void setItem_category_id(int item_category_id) {
		this.item_category_id = item_category_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getFile_url() {
		return file_url;
	}
	public void setFile_url(String file_url) {
		this.file_url = file_url;
	}
	@Override
	public String toString() {
		return "ItemDTO [item_id=" + item_id + ", item_category_id=" + item_category_id + ", name=" + name + ", content="
				+ content + ", price=" + price + "]";
	}
	
	
}
