package com.web.mall.model;

import java.sql.Date;

public class GoogleAccountVO {
	private String id; 
	//INSERT INTO boards (pid) VALUES ( 'user' || board_seq.nextval );
	//INSERT INTO boards (pid) VALUES ( 'user' || TO_CHAR(board_seq.nextval));
	private String sub; //The unique ID of the user's Google Account
	private String email;
	private String name;
	private String platform;
	private Date joindate;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public Date getJoindate() {
		return joindate;
	}
	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}
	@Override
	public String toString() {
		return "GoogleAccountVO [sub=" + sub + ", email=" + email + ", name=" + name + ", platform=" + platform + ", joindate=" + joindate + "]";
	}
	
}
