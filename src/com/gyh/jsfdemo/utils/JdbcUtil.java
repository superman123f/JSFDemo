package com.gyh.jsfdemo.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtil {
	
	private static Connection conn = null;
	private static String url = "jdbc:oracle:thin:@127.0.0.1:1521:ORCL";
	private static String username = "scott";
//	private static String url = "jdbc:oracle:thin:@127.0.0.1:1522:TEST";
//	private static String username = "jsf";
	private static String password = "oracle";
	
	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(ResultSet result, PreparedStatement pst, Connection conn) {
		try {
			if(result != null) {
				result.close();
				result = null;
			}
			if(pst != null) {
				pst.close();
				pst = null;
			}
			if(conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
