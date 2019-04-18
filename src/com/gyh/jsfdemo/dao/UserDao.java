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
	
	public int checkLogin(User user) {
//		PreparedStatement pst = null;
//		ResultSet rs = null;
		sql = "select count(1) from s_user where username = '" + user.getName() + "' and password = '" + user.getPassword()+"'";
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	// query all users
	public List<User> queryAllUsers() {
		sql = "select username, password from s_user";
		List<User> userList = new ArrayList<User>();
		
		try {
			conn = JdbcUtil.getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			User user;
			
			while(rs.next()) {
				user = new User();
				user.setName(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				
				userList.add(user);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return userList;
	}
}
