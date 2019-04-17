package com.gyh.jsfdemo.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.gyh.jsfdemo.utils.JdbcUtil;

public class ConnectTest {

	@Test
	public void testConnect() {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet result = null;
		String sql = "select username, password from s_user";
		
		try {
			conn = JdbcUtil.getConnection();
			pst = conn.prepareStatement(sql);
			result = pst.executeQuery();
			
			while(result.next()) {
				System.out.println(result.getString("username") + result.getString("password"));
			}
			
			JdbcUtil.close(result, pst, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
