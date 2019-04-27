package com.huang.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.huang.dao.UserDao;
import com.huang.dao.impl.UserDaoImpl;
import com.huang.model.User;
import com.huang.service.CheckcodeService;
import com.huang.service.FindService;


public class FindServiceImpl implements FindService {
	/*
	 * 获得当前页信息
	 */
	@Override
	public List<User> getList(int currPage) throws Exception{
		List<User> list = null ;
		// 实例化ImageDao	
		UserDaoImpl dao = new UserDaoImpl();
		// 查询所有信息	
		try {
			list = dao.find(currPage);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return list;
	}
	/*
	 * 获得分页行
	 */
	@Override
	public StringBuffer getBar(int currPage){
		// 总页数	
		int  pages ;
		// 实例化ImageDao
		UserDaoImpl dao = new  UserDaoImpl();	
		// 查询总记录数	
		int  count = dao.findCount();	
		// 计算总页数	
		if (count % User. PAGE_SIZE  == 0){	
		// 对总页数赋值
			pages = count / User. PAGE_SIZE ;
		} else {	
		// 对总页数赋值	
			pages = count / User. PAGE_SIZE  + 1;	
		}	
		// 实例化StringBuffer	
		StringBuffer sb = new  StringBuffer();	
		// 通过循环构建分页条	
		for ( int  i=1; i <= pages; i++){	
			// 判断是否为当前页	
			if (i == currPage){	
			// 构建分页条	
			sb.append("『" + i + "』");	
			} else {	
			// 构建分页条	
			sb.append("<a href='FindServlet?page=" + i + "'>" + i + "</a>");	
			}	
			// 构建分页条	
			sb.append(" ");	
		}
		return sb;	
	}
	
}
