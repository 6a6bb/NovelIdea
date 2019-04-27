package com.huang.util;

import java.sql.*;
//连接数据库
public class DbUtil {
	private static String url = "jdbc:mysql://localhost:3306/db_user?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF8";
	private static String username = "root";
	private static String password = "123456";
	private static String jdbcname = "com.mysql.cj.jdbc.Driver";
	public Connection getCon() {
		try {
			Class.forName(jdbcname);

		} catch (ClassNotFoundException e) {
			System.out.println("加载数据库连接失败");
			e.printStackTrace();
		}
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public void close(PreparedStatement pstmt, Connection conn) {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
