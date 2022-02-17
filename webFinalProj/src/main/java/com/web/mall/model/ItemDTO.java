package com.web.mall.model;

public class ItemDTO {
	private int item_id;
	private int item_category_id;
	private String name;
	private String content;
	private int price;
	private int image_id;//승원 작업
	private String file_name;
	private String file_url;
	private int page_num;
	
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
	public int getImage_id() {
		return image_id;
	}
	public void setImage_id(int image_id) {
		this.image_id = image_id;
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
	public String getFileNameExtension() {
		return file_name.substring(file_name.lastIndexOf(".") + 1);
	}
	public String getDownloadPath() {
		return file_url + "/" + image_id + "." + getFileNameExtension();
	}
	public int getPage_num() {
		return page_num;
	}
	public void setPage_num(int page_num) {
		this.page_num = page_num;
	}
	@Override
	public String toString() {
		return "ItemDTO [item_id=" + item_id + ", item_category_id=" + item_category_id + ", name=" + name
				+ ", content=" + content + ", price=" + price + ", image_id=" + image_id + ", file_name=" + file_name
				+ ", file_url=" + file_url + ", page_num=" + page_num + "]";
	}
}
