package com.web.mall.model;

import java.sql.Date;

public class SocialAccountVO {
	private String social_account_id; 
	private String rand_id; //The unique ID of the user's Google Account
	private String name;
	private String phone;
	private String email;
	private String address;
	private String address_no;
	private String nickname;
	private int login_type;
	private Date joindate;
	private char is_banned;
	
	public String getSocial_account_id() {
		return social_account_id;
	}
	public void setSocial_account_id(String social_account_id) {
		this.social_account_id = social_account_id;
	}
	public String getRand_id() {
		return rand_id;
	}
	public void setRand_id(String rand_id) {
		this.rand_id = rand_id;
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
	public int getLogin_type() {
		return login_type;
	}
	public void setLogin_type(int login_type) {
		this.login_type = login_type;
	}
	public Date getJoindate() {
		return joindate;
	}
	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}
	public char getIs_banned() {
		return is_banned;
	}
	public void setIs_banned(char is_banned) {
		this.is_banned = is_banned;
	}
	@Override
	public String toString() {
		return "SocialAccountVO [social_account_id=" + social_account_id + ", rand_id=" + rand_id + ", name=" + name
				+ ", phone=" + phone + ", email=" + email + ", address=" + address + ", address_no=" + address_no
				+ ", nickname=" + nickname + ", login_type=" + login_type + ", joindate=" + joindate + ", is_banned=" + is_banned + "]";
	}
}
