package com.web.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Manage_AccountDTO {
	private String AccountID;
	private String Password;
	private int UserType;
	private String Name;
	private String Phone;
	private String Email;
	private String EmailNumber;
	private String Address;
	private String NickName;
	private Date JoinDate;
	private SimpleDateFormat form = new SimpleDateFormat("yy.MM.dd HH");
	
	public String getAccountID() {
		return AccountID;
	}

	public void setAccountID(String accountID) {
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
	
	public String getUserTypeStr() {
		switch(UserType) {
		case(0):
			return "관리자";
		case(1):
			return "회원";
		case(2):
			return "비회원";
		default:
			return "";
		}
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

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getEmailNumber() {
		return EmailNumber;
	}

	public void setEmailNumber(String emailNumber) {
		Email = emailNumber;
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

	public Date getJoinDate() {
		return JoinDate;
	}

	public String getJoinDateStr() {
		return form.format(JoinDate);
	}

	public void setJoinDate(Date joinDate) {
		JoinDate = joinDate;
	}

	@Override
	public String toString() {
		return "Manage_AccountDTO [AccountID=" + AccountID + ", Password=" + Password + ", UserType=" + UserType
			+ ", Name=" + Name + ", Phone=" + Phone + ", Email=" + Email + ", EmailNumber=" + EmailNumber
			+ ", Address=" + Address + ", NickName=" + NickName + ", JoinDate=" + JoinDate + "]";
	}
}
