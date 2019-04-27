package com.huang.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.huang.dao.*;
import com.huang.model.User;
import com.huang.util.DbUtil;


import com.huang.util.AppMD5Util;
public class UserDaoImpl implements UserDao {
	private static DbUtil dbUtil = new DbUtil();
	boolean flat = false;

	public User getUser(String username) {
		final Connection con = dbUtil.getCon();
		PreparedStatement pstmt = null;
		User user=new User();
		try {
			final String sql = "select * from db_user where username=? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			final ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				user.setUsername(rs.getString("username"));
				user.setPhonenumber(rs.getString("phonenumber"));
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.close(pstmt, con);
		}
		return user;
	}
	// 用户登录
	@Override
	public Boolean login(final User user) {			
		final Connection con = dbUtil.getCon();
		PreparedStatement pstmt = null;
		try {
			final String sql = "select * from db_user where username=? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			final ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				if (user.getPassword().equals(rs.getString("password"))) {
					flat = true;
					break;
				}

			}
		} catch (final SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.close(pstmt, con);
		}

		if (flat == true) {
			return true;
		} else {
			return false;
		}
	}
	
	// 修改密码
	@Override
	public boolean update(final User user, final String newPassword) throws Exception {
		final Connection con = dbUtil.getCon();
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			final String sql = "update db_user set password=? where username=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, AppMD5Util.getMD5(newPassword));
			pstmt.setString(2, user.getName());
			result = pstmt.executeUpdate();
		} catch (final SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.close(pstmt, con);
		}

		if (result != 0) {
			return true;
		} else {
			return false;
		}
	}

	// 添加用户
	@Override
	public boolean addUser(final User user) throws Exception {
		final Connection con = dbUtil.getCon();
		PreparedStatement pstmt = null;
		int t = 0;
		try {
			final String sql = "insert into db_user(username, password,phonenumber,right_id)values(?, ?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, AppMD5Util.getMD5(user.getPassword()));
			pstmt.setString(3, user.getPhonenumber());
			pstmt.setInt(4, 5);
			t = pstmt.executeUpdate();
		} catch (final SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.close(pstmt, con);
		}
		if (t != 0) {
			return true;
		} else {
			return false;
		}
	}

	// 判断用户是否存在	
	@Override
	public boolean usernameIsExist(final String username) throws Exception {
		final Connection con = dbUtil.getCon();
		PreparedStatement pstmt = null;
		try {
			final String sql = "select * from db_user where username=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);

			if (!pstmt.executeQuery().next()) {
				return false;
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.close(pstmt, con);
		}
		return true;
	}
	
	// 判断输入的原密码是否正确
	@Override
	public boolean passwordRight(final String username, String password) throws Exception {
		password=AppMD5Util.getMD5(password);
		final Connection con = dbUtil.getCon();
		PreparedStatement pstmt = null;
		try {
			final String sql = "select * from db_user where username=username";
			pstmt = con.prepareStatement(sql);
			final ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				if (password.equals(rs.getString("password"))) {
					
					return true;
				}
			}
		} catch (final SQLException e1) {
			e1.printStackTrace();
		} finally {
			dbUtil.close(pstmt, con);
		}

		return false;

	}
	
	// 判断登录信息是否正确
	@Override
	public boolean LoginRight(final String username, String password) throws Exception {
		password=AppMD5Util.getMD5(password);
		boolean t = false;
		final Connection con = dbUtil.getCon();
		PreparedStatement pstmt = null;
		final String sql = "select * from db_user";
		try {
			pstmt = con.prepareStatement(sql);
			final ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				if (username.equals(rs.getString("username")) && password.equals(rs.getString("password"))) {
					t = true;
					break;
				}	
			}
		} catch (final SQLException e1) {
			e1.printStackTrace();
		} finally {
			dbUtil.close(pstmt, con);
		}

		return t;

	}

	//获得用户权限类型
	@Override
	public String right(final String username) {
		final Connection con = dbUtil.getCon();
		PreparedStatement pstmt = null;
		try {
			final String sql = "select d.right from db_user e,`right` d where e.right_id=d.id and e.username=? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			final ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				return rs.getString("right");
			}
		} catch (final SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.close(pstmt, con);
		}
		return null;

	}
	
	//得到权限id
	@Override
	public int right_id(final String newRight) {
		final Connection con = dbUtil.getCon();
		PreparedStatement pstmt = null;
		int right_id=0;
		try {
			final String sql = "select e.right_id from db_user e,`right` d where e.right_id=d.id and d.`right`=? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newRight);
			final ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				right_id=rs.getInt("right_id");
			}		

		} catch (final SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.close(pstmt, con);
		}
		return right_id;
	}

	//修改权限
	@Override
	public boolean changeRight(final User user,final int right_id) throws Exception {
		final Connection con = dbUtil.getCon();
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			final String sql = "update db_user set right_id=? where username=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, right_id);
			pstmt.setString(2, user.getName());
			result = pstmt.executeUpdate();
		} catch (final SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.close(pstmt, con);
		}

		if (result != 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<User> getUserList(String sql) throws Exception {
		final Connection con = dbUtil.getCon();
		PreparedStatement pstmt = null;
		final int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			final ResultSet rs = pstmt.executeQuery();
			List<User> list = new ArrayList();
			while(rs.next()) {
				User user=new User();				
				user.setName(rs.getString("username"));
				user.setPhonenumber(rs.getString("phonenumber"));
				user.setright_id(rs.getInt("right_id"));
				list.add((User) user);
			}
			return list;
		} catch (final SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.close(pstmt, con);
		}
		return new ArrayList();
	}

	public int findCount(){
		// 总记录数
		int  count = 0;
		Connection conn = dbUtil.getCon();
		// 查询总记录数SQL语句
		String sql = "select count(*) from img_src";
		try  {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		// 光标向后移动，并判断是否有效
		if (rs.next()){
		// 对总记录数赋值
		count = rs.getInt(1);
		}
		rs.close();
		conn.close();
		} catch  (SQLException e) {
		e.printStackTrace();
		}
		// 返回总记录数
		return  count;
	}
	
	// 查询当前页所有信息
	public  List<User> find(int  page) throws Exception {
	String sql  = "select username,phonenumber,right_id from db_user order by right_id limit "+((page - 1) * User. PAGE_SIZE)+"," +User. PAGE_SIZE +";";
	try{
		Connection conn = dbUtil.getCon();
		PreparedStatement ps = conn.prepareStatement(sql);			
		List<User> list = getUserList(sql);
		return list;
	}catch  (SQLException e) {
		e.printStackTrace();		
		}
	return null;
}

	@Override
	public boolean phonenumberRight(String username, String phonenumber) throws Exception {
		final Connection con = dbUtil.getCon();
		PreparedStatement pstmt = null;
		try {
			final String sql = "select * from db_user where username=username";
			pstmt = con.prepareStatement(sql);
			final ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				if (phonenumber.equals(rs.getString("phonenumber"))) {					
					return true;
				}
			}
		} catch (final SQLException e1) {
			e1.printStackTrace();
		} finally {
			dbUtil.close(pstmt, con);
		}

		return false;
	}
}
	
