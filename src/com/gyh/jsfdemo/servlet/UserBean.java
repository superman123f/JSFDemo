package com.gyh.jsfdemo.servlet;

import java.util.Date;
import java.util.List;

import javax.faces.event.ActionEvent;

import com.gyh.jsfdemo.pojo.Student;
import com.gyh.jsfdemo.pojo.User;
import com.gyh.jsfdemo.service.impl.UserManageServiceImpl;

public class UserBean {
	private String name;
	private String password;
	private String errMessage;
	private Card card;
	private Date createTime = new Date();
	private String outcome;
	private String image="/images/1.jpg";
	private List<User> userList;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	public void verify(ActionEvent e) {
		String test = "123";
		Student stu = new Student();
		stu.setStuno("111");
		stu.setName("student1");
		if(!name.equals("zhangsan") || !password.equals("123456")) {
			errMessage = "userName or password is wrong:" + e.getSource();
			outcome = "faliure";
		} else {
			outcome = "success";
		}
		Student stu1 = stu;
		System.out.println("student's infos: " + stu1.getStuno() + " " + stu1.getName());
	}
	
	//	µÇÂ¼
//	@Test
	public void login(ActionEvent e) {
		System.out.println("insert login servlet");
		User user = new User();
		user.setName(this.name);
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
	public String outcome() {
		return outcome;
	}
}
