package com.gyh.jsfdemo.pojo;

import java.sql.Timestamp;

public class User {
	private String userId;
	private String username;
	private String password;
	private Timestamp createTime;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp timestamp) {
		this.createTime = timestamp;
	}
		
}
