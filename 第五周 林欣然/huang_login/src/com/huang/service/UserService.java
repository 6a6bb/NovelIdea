package com.huang.service;

public interface UserService {
	 /** 
     * 判断用户名格式是否正确
     */ 
	public int isUserNameRight(String username);

	
	 /** 
     * 判断密码格式是否正确
     */ 
	public int isRightPassword(String password);
	


}
