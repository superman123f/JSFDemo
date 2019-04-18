package com.gyh.jsfdemo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gyh.jsfdemo.pojo.User;
import com.gyh.jsfdemo.utils.JdbcUtil;

public class UserDao {
	
	private Connection conn = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	private String sql = "";
	
	// check login
	public int checkLogin(User user) {
		sql = "select count(1) from s_user where username = '" + user.getUsername() + "' and password = '" + user.getPassword()+"'";
		int i = 0;
		
		try {
			conn = JdbcUtil.getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery(sql);
			
			while(rs.next()) {
				i = 1;
			}
			
			JdbcUtil.close(rs, pst, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	// query all users
	public List<User> queryAllUsers() {
		sql = "select userid, username, password from s_user";
		List<User> userList = new ArrayList<User>();
		
		try {
			conn = JdbcUtil.getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			User user;
			
			while(rs.next()) {
				user = new User();
				user.setUserId(rs.getString("userid"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				
				userList.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return userList;
	}
	
	// add user
	public boolean addUser(User user) {
		sql = "insert into s_user(userid, username, password) values('" + user.getUserId()+ "', '" + user.getUsername()+ "', '" + user.getPassword()+ "')";
		boolean flag = false;
		try {
			conn = JdbcUtil.getConnection();
			pst = conn.prepareStatement(sql);
			flag = pst.execute();
			
			JdbcUtil.close(null, pst, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
}
