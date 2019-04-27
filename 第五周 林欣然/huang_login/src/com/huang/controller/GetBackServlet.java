package com.huang.controller;

import com.huang.dao.impl.UserDaoImpl;
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
 * 实现修改密码功能
 */
@WebServlet("/GetBackServlet")
public class GetBackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	boolean flat;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetBackServlet() {
		super();
		// TODO Auto-generated constructor stub
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
		String phonenumber = request.getParameter("phonenumber");
		String newPassword = request.getParameter("newPassword");
		UserDaoImpl d = new UserDaoImpl();
		try {
			flat = d.phonenumberRight(username, phonenumber);		
		} catch (Exception e1) {	
			e1.printStackTrace();
		}
		if (flat == true) {
			User user = new User();
			user.setName(username);
			user.setPhonenumber(phonenumber);	
			try {
				if (d.update(user, newPassword)==true) {
					response.sendRedirect("/huang_login/updatesuccess.jsp");
				} else {
					response.sendRedirect("/huang_login/updatefailuer.jsp");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			response.sendRedirect("/huang_login/updatefailuer2.jsp");
			return;
		}
	}

}
