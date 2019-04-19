package com.gyh.jsfdemo.servlet;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.webapp.FacesServlet;
import javax.servlet.http.HttpServletRequest;

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
		Date date = new Date();
		
		User user = new User();
		user.setUserId(userId);
		user.setUsername(this.username);
		user.setPassword(this.password);
		
		boolean flag = new UserManageServiceImpl().addUser(user);
		if(flag) {
			System.out.println("add user success");
		} else {
			System.out.println("add user error");
		}
		outcome = "add";
	}
	
	// find user information
	public String findUserByUserId() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest)facesContext.getExternalContext().getRequest();
		String userId = request.getParameter("userId");
		
		User user = new UserManageServiceImpl().findUserByUserId(userId);
		
		this.userId = user.getUserId();
		this.username = user.getUsername();
		this.password = user.getPassword();
		
		System.out.println("find user information");
		
		return "toEditPage";
	}
	// update user
	public String updateUser() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest)facesContext.getExternalContext().getRequest();
		request.getParameter("userId");
		
		User user = new User();
		user.setUserId(this.userId);
		user.setUsername(this.username);
		user.setPassword(this.password);
		
		boolean flag = new UserManageServiceImpl().updateUser(user);
		if(flag) {
			System.out.println("update user success");
		} else {
			System.out.println("update user error");
		}
		
		return "update";
	}
	
	// delete user
	public String deleteUser() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest)facesContext.getExternalContext().getRequest();
		String userId = request.getParameter("userId");
		System.out.println("the user's userId = " + userId);
		
		boolean flag = new UserManageServiceImpl().deleteUser(userId);
		if(flag) {
			System.out.println("delete user success");
		} else {
			System.out.println("delete user error");
		}
		return "success";
	}
	
	// clean data
	public String cleanData() {
		this.username = "";
		this.password = "";
		return "add";
	}
	
	// return view
	public String outcome() {
		return outcome;
	}
	
	// exit
	public String exit() {
		username = "";
		errMessage = "";
		return "exit";
	}
}
