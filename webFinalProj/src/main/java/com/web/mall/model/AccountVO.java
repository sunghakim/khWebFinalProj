package com.web.mall.model;

import java.sql.Date;

public class AccountVO {
	private String account_id;
	private String password;
	private int user_type; //0:관리자, 1:회원, 2:비회원
	private String name;
	private String phone;
	private String email;
	private String address;
	private String address_no;
	private String nickname;
	private Date joindate;
	public String getAccount_id() {
		return account_id;
	}
	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUser_type() {
		return user_type;
	}
	public void setUser_type(int user_type) {
		this.user_type = user_type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress_no() {
		return address_no;
	}
	public void setAddress_no(String address_no) {
		this.address_no = address_no;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Date getJoindate() {
		return joindate;
	}
	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}
	@Override
	public String toString() {
		return "AccountVO [account_id=" + account_id + ", password=" + password + ", user_type=" + user_type + ", name="
				+ name + ", phone=" + phone + ", email=" + email + ", address=" + address + ", address_no=" + address_no
				+ ", nickname=" + nickname + ", joindate=" + joindate + "]";
	}
	
	
}
