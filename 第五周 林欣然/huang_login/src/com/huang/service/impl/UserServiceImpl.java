package com.huang.service.impl;

import com.huang.dao.impl.UserDaoImpl;
import com.huang.model.User;
import com.huang.service.UserService;

public class UserServiceImpl implements UserService {
	public final static int PSWRIGHT = 1;
	public final static int PSWERROR = 0;
	public final static int USNRIGHT = 1;
	public final static int USNERROR = 0;

	@Override
	public int isUserNameRight(String username) {
		// 账号 6-20位的数字英文组合
		if (username.length() > 5 && username.length() < 21
				&& username.matches("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$")) {
			return USNRIGHT;
		} else {
			return USNERROR;
		}

	}

	@Override
	public int isRightPassword(String password) {
		// 密码 6-25位数字
		if (!password.matches("^[0-9]{6,25}$")) {
			return PSWERROR;
		} else {
			return PSWRIGHT;
		}

	}
	
	public User getUser(String username) {
		UserDaoImpl user=new UserDaoImpl();
		return user.getUser(username);
	}




}
