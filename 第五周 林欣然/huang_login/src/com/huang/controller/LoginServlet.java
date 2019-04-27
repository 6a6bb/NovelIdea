package com.huang.controller;

import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huang.dao.impl.UserDaoImpl;
import com.huang.model.User;
import com.huang.service.impl.UserServiceImpl;

/**
 * 实现登录功能
 */
@WebServlet("/loginservlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserServiceImpl d = new UserServiceImpl();
		request.setAttribute("user",d.getUser(username));
		if (d.isUserNameRight(username) == d.USNERROR||d.isRightPassword(password) == d.PSWERROR) {
			response.sendRedirect("/huang_login/Login.jsp");
			return;
		}
		UserDaoImpl b = new UserDaoImpl();
		User user = new User();
		user.setName(username);
		user.setPassword(password);
		String identifycode = request.getParameter("identifycode");
		try {
			if(!b.usernameIsExist(username)) {
				request.setAttribute("message", "账号不存在!登录失败,稍后跳转登录页面.....");
				request.getRequestDispatcher("Loginfailuer.jsp").forward(request, response);
				return;
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		String code = (String) request.getSession().getAttribute("code");
		try {
			if (identifycode.equals(code) && b.LoginRight(username, password)) {
				//将权限信息存入session
				request.getSession().setAttribute("right",b.right(username));	
				//将登录信息存入session
				request.getSession().setAttribute("user", username); 
				request.getSession().setAttribute("User", d.getUser(username)); 
				request.getRequestDispatcher("loginornotservlet").forward(request, response);
				return;
			}else if(!b.LoginRight(username, password)){
				request.setAttribute("message", "密码错误!登录失败,稍后跳转登录页面......");
			}else {
				request.setAttribute("message", "你的账号已登陆!信息失效,稍后跳转登录页面.......");
			}
			request.getRequestDispatcher("Loginfailuer.jsp").forward(request, response);
			return;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
