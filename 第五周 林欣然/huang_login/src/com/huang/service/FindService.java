package com.huang.service;

import java.util.List;
import com.huang.model.User;

public interface FindService {
	/*
	 * 获得当前页信息
	 */
	public List<User> getList(int currPage) throws Exception;
	
	/*
	 * 获得分页行
	 */
	public StringBuffer getBar(int currPage);
}
