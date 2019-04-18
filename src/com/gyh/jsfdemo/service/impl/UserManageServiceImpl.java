package com.gyh.jsfdemo.service.impl;

import java.sql.ResultSet;
import java.sql.Statement;

import com.gyh.jsfdemo.service.IUserManageService;
import com.gyh.jsfdemo.utils.JdbcUtil;

public class UserManageServiceImpl implements IUserManageService{

	@Override
	public int login() {
		Statement stm = null;
		ResultSet rs = null;
		String sql = "select ";
		JdbcUtil.getConnection();
		return 0;
	}
	
}
