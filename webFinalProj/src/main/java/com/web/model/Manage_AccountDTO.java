package com.web.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Manage_AccountDTO {
	private String Account_ID;
	private String Password;
	private int User_Type;
	private String Name;
	private String Phone;
	private String Address;
	private String NickName;
	private int Login_Type;
	private Date JoinDate;
	private SimpleDateFormat form = new SimpleDateFormat("yy.MM.dd");

	public String getAccount_ID() {
		return Account_ID;
	}

	public void setAccount_ID(String account_ID) {
		Account_ID = account_ID;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public int getUser_Type() {
		return User_Type;
	}

	public void setUser_Type(int user_Type) {
		User_Type = user_Type;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getNickName() {
		return NickName;
	}

	public void setNickName(String nickName) {
		NickName = nickName;
	}

	public int getLogin_Type() {
		return Login_Type;
	}

	public void setLogin_Type(int login_Type) {
		Login_Type = login_Type;
	}

	public Date getJoinDate() {
		return JoinDate;
	}

	public String getJoinDateStr() {
		return form.format(JoinDate);
	}
	
	public void setJoinDate(Date joinDate) {
		JoinDate = joinDate;
	}
	
}
