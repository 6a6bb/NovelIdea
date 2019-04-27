package com.huang.dao;

import java.util.ArrayList;
import java.util.List;

import com.huang.model.User;

/**
 *
 * 
 * @param sql
 */
public interface UserDao {

	// 用户登录
	public Boolean login(User user);
	
	//获得用户权限
	public String right(String username);
	
	//返回用户权限id
	public int right_id(String newRight);
	
	// 修改密码
	public boolean update(User user, String newPassword) throws Exception;
	
	//修改权限
	public boolean changeRight(User user,int right_id) throws Exception;

	// 添加用户
	public boolean addUser(User user) throws Exception;

	// 判断用户是否存在
	public boolean usernameIsExist(String username) throws Exception;

	// 判断输入的原密码是否正确
	public boolean passwordRight(String username, String password) throws Exception;

	// 判断登录信息是否正确
	public boolean LoginRight(String username, String password) throws Exception;
	
	// 获得登陆信息
	public List<User> getUserList(String sql) throws Exception;
	
	// 判断输入的手机号是否正确
	public boolean phonenumberRight(String username, String phonenumber) throws Exception;

}
