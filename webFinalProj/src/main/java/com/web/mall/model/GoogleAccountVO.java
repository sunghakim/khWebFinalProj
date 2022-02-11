package com.web.mall.model;

public class GoogleAccountVO {
	private String sub; //The unique ID of the user's Google Account
	private String email;
	private String name;
	private String given_name;
	private String family_name;
	private String access_token;
	private String platform;
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
	public String getGiven_name() {
		return given_name;
	}
	public void setGiven_name(String given_name) {
		this.given_name = given_name;
	}
	public String getFamily_name() {
		return family_name;
	}
	public void setFamily_name(String family_name) {
		this.family_name = family_name;
	}
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	@Override
	public String toString() {
		return "GoogleAccountVO [sub=" + sub + ", email=" + email + ", name=" + name + ", given_name=" + given_name
				+ ", family_name=" + family_name + ", access_token=" + access_token + ", platform=" + platform + "]";
	}
	
}
