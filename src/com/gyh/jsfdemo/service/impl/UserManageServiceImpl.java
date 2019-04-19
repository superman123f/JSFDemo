package com.gyh.jsfdemo.service.impl;

import java.util.List;

import com.gyh.jsfdemo.dao.UserDao;
import com.gyh.jsfdemo.pojo.User;
import com.gyh.jsfdemo.service.IUserManageService;

public class UserManageServiceImpl implements IUserManageService{

	@Override
	public int checkLogin(User user) {
		return new UserDao().checkLogin(user);
	}

	@Override
	public List<User> queryAllUsers() {
		return new UserDao().queryAllUsers();
	}

	@Override
	public boolean addUser(User user) {
		return new UserDao().addUser(user);
	}

	@Override
	public boolean deleteUser(String userId) {
		return new UserDao().deleteUser(userId);
	}

	@Override
	public boolean updateUser(User user) {
		return new UserDao().updateUser(user);
	}

	@Override
	public User findUserByUserId(String userId) {
		return new UserDao().findUserByUserId(userId);
	}
	
}
