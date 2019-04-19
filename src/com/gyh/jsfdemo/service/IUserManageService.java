package com.gyh.jsfdemo.service;

import java.util.List;

import com.gyh.jsfdemo.pojo.User;

public interface IUserManageService {
	public int checkLogin(User user);
	public List<User> queryAllUsers();
	boolean addUser(User user);
	public boolean deleteUser(String userId);
	public boolean updateUser(User user) ;
	public User findUserByUserId(String userId);
}
