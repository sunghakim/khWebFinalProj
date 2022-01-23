package com.web.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Manage_AccountDTO {
	private String AccountID;
	private String Password;
	private int UserType;
	private String Name;
	private String Phone;
	private String Address;
	private String NickName;
	private int LoginType;
	private Date JoinDate;
	private SimpleDateFormat form = new SimpleDateFormat("yy.MM.dd");
	public String getAccountID() {
		return AccountID;
	}
	public void setAccount_ID(String accountID) {
		AccountID = accountID;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public int getUserType() {
		return UserType;
	}
	public void setUserType(int userType) {
		UserType = userType;
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
	public int getLoginType() {
		return LoginType;
	}
	public void setLoginType(int loginType) {
		LoginType = loginType;
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
