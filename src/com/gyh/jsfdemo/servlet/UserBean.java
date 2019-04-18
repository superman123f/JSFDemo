package com.gyh.jsfdemo.servlet;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.faces.event.ActionEvent;

import com.gyh.jsfdemo.pojo.User;
import com.gyh.jsfdemo.service.impl.UserManageServiceImpl;

public class UserBean {
	private String userId;
	private String username;
	private String password;
	private String errMessage;
	private Card card;
	private Date createTime = new Date();
	private String outcome;
	private String image="/images/1.jpg";
	private List<User> userList;
	
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
	public String getOutcome() {
		return outcome;
	}
	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getErrMessage() {
		return errMessage;
	}
	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public List<User> getUserList() {
		userList = new UserManageServiceImpl().queryAllUsers();
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	// verify
	public void verify(ActionEvent e) {
		if(!username.equals("zhangsan") || !password.equals("123456")) {
			errMessage = "userName or password is wrong:" + e.getSource();
			outcome = "faliure";
		} else {
			outcome = "success";
		}
		System.out.println("verifying...");
	}
	
	// login
	public void login(ActionEvent e) {
		System.out.println("insert login servlet");
		User user = new User();
		user.setUsername(this.username);
		user.setPassword(this.password);
		int i = new UserManageServiceImpl().checkLogin(user);
		if(i > 0) {
			errMessage = "login success.";
			outcome = "success";
		} else {
			errMessage = "username or password is wrong.";
			outcome = "faliure";
		}
	}
	
	// add new user	
	public void addUser(ActionEvent e) {
		System.out.println("add a new user...");
		String userId =  UUID.randomUUID().toString().replaceAll("\\-", "");
	
		User user = new User();
		user.setUserId(userId);
		user.setUsername(this.username);
		user.setPassword(this.password);
		
		boolean flag = new UserManageServiceImpl().addUser(user);
		if(flag) {
			errMessage = "add user success";
		} else {
			errMessage = "add user error";
		}
		outcome = "add";
	}
	
	// clean data
	public void cleanData() {
		this.username = "";
		this.password = "";
	}
	
	// return view
	public String outcome() {
		return outcome;
	}
}
