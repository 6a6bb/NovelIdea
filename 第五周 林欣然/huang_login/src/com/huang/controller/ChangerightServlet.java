
package com.huang.controller;

import com.huang.dao.impl.UserDaoImpl;
import com.huang.controller.*;
import com.huang.util.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huang.model.User;
import com.huang.service.impl.UserServiceImpl;

/**
 * 实现修改权限功能
 */
@WebServlet("/Changerightservlet")
/**
 * @author linxinran
 *
 * ${tags}
 */
public class ChangerightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	boolean flat;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangerightServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		//转化乱码！
		String newRight=new String(request.getParameter("newRight").getBytes("ISO-8859-1"),"UTF-8"); 
		//过滤器
		String user1 = (String) request.getSession().getAttribute("user");
		
		UserDaoImpl d = new UserDaoImpl();
		User user = new User();
		user.setName(username);
		int rid1=d.right_id(d.right(user1));
		int rid2=d.right_id(d.right(username));
		user.setright_id(rid1);
		request.getSession().setAttribute("regUser", user);
		if(rid2==0) {																
			//判断用户名是否已经存在
			request.getSession().setAttribute("message", "账号不存在!权限修改失败,稍后跳转用户页面.......");
			response.sendRedirect("/huang_login/changefailuer.jsp");
			return;
		}else if(rid1<rid2) {														
			//判断该用户权限是否足以修改要修改的用户(同级应该不能改吧)
			int right_id=d.right_id(newRight);
			try {
				 if(right_id<rid1){													
					 //要赋予的权限不能超过自己拥有的权限
					 request.getSession().setAttribute("message", "你的权限不足!权限修改失败,稍后跳转用户页面........");
				}else if(d.changeRight(user, right_id)) {
					response.sendRedirect("/huang_login/changesuccess.jsp");
					return;
				}else {
					request.getSession().setAttribute("message", "数据出错!权限修改失败,稍后跳转用户页面......");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			request.getSession().setAttribute("message", "你的权限不足!权限修改失败,稍后跳转用户页面......");
		}
		response.sendRedirect("/huang_login/changefailuer.jsp");
		return;
	}
}
