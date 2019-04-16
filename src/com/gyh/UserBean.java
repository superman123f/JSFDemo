package com.gyh;

import java.util.Date;

import javax.faces.event.ActionEvent;

public class UserBean {
	private String name;
	private String password;
	private String errMessage;
	private Card card;
	private Date createTime = new Date();
	private String outcome;
	private String image="/images/1.jpg";
	
	
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
	//	用户名、密码核实
	public void verify(ActionEvent e) {
		if(!name.equals("zhangsan") || !password.equals("123456")) {
			errMessage = "userName or password is wrong:" + e.getSource();
			outcome = "faliure";
		} else {
			outcome = "success";
		}
	}
	public String outcome() {
		return outcome;
	}
}
