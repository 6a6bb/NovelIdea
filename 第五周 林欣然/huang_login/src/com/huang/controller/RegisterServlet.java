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
 *  实现用户注册功能
 */
@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		String phonenumber = request.getParameter("phonenumber");
		UserServiceImpl d = new UserServiceImpl();
		if (d.isUserNameRight(name) == d.USNERROR) {
			response.sendRedirect("/huang_login/registerfailuer.jsp");
			return;
		}
		if (d.isRightPassword(password) == d.PSWERROR) {
			response.sendRedirect("/huang_login/registerfailuer.jsp");
			return;
		}

		User user = new User();
		user.setName(name);
		user.setPassword(password);
		user.setPhonenumber(phonenumber);
		UserDaoImpl userdaoimpl = new UserDaoImpl();
		try {
			if(userdaoimpl.usernameIsExist(name)) {							//判断用户名是否已经存在
				response.sendRedirect("/huang_login/registerfailuer.jsp");
			}else if (userdaoimpl.addUser(user)) {
				response.sendRedirect("/huang_login/registersuccess.jsp");
			} else {
				response.sendRedirect("/huang_login/registerfailuer.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
