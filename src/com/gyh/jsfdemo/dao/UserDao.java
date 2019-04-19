package com.gyh.jsfdemo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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
		sql = "select username from s_user where username = '" + user.getUsername() + "' and password = '" + user.getPassword()+"'";
		int i = 0;
		
		try {
			conn = JdbcUtil.getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery(sql);
			
			if(rs.next()) {
				i = 1;
			} else {
				i = 0;
			}
			
			JdbcUtil.close(rs, pst, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	// query all users
	public List<User> queryAllUsers() {
		sql = "select userid, username, password, createtime from s_user order by createtime desc";
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
				user.setCreateTime(rs.getTimestamp("createTime"));
				
				userList.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return userList;
	}
	
	// add user
	public boolean addUser(User user) {
//		sql = "insert into s_user(userid, username, password) values('" + user.getUserId()+ "', '" + user.getUsername()+ "', '" + user.getPassword()+ "')";
		sql = "insert into s_user(userid, username, password, createtime) values(?, ?, ?, ?)";
		boolean flag = false;
		try {
			conn = JdbcUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, user.getUserId());
			pst.setString(2, user.getUsername());
			pst.setString(3, user.getPassword());
//			pst.setDate(4, user.getCreateTime()); // 只有日期
			pst.setTimestamp(4, new Timestamp(new java.util.Date().getTime())); // 日期 + 时间
			flag = pst.execute();
			
			JdbcUtil.close(null, pst, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	// find user information
	public User findUserByUserId(String userId) {
		User user = new User();
		sql = "select userId, username, password from s_user where userid = ?";
		try {
			conn = JdbcUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, userId);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				user.setUserId(rs.getString("userId"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			}
			
			JdbcUtil.close(null, pst, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	// update user
	public boolean updateUser(User user) {
		sql = "update s_user set username = ?, password = ? where userid = ?";
		boolean flag = false;
		try {
			conn = JdbcUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getUserId());
			flag = pst.execute();
			
			JdbcUtil.close(null, pst, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	// delete user
	public boolean deleteUser(String userId) {
		sql = "delete from s_user where userid = ?";
		boolean flag = false;
		try {
			conn = JdbcUtil.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, userId);
			flag = pst.execute();
			
			JdbcUtil.close(null, pst, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
}
