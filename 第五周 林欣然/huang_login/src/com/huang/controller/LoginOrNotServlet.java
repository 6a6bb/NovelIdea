package com.huang.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 实现验证用户是否登录功能
 */
@WebServlet("/loginornotservlet")
public class LoginOrNotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginOrNotServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(request.getSession().getAttribute("user")!=null){
			String right=(String)request.getSession().getAttribute("right");
			if("用户".equals(right)) {
				request.getRequestDispatcher("user3.jsp").forward(request,response);
			}else if("管理员".equals(right)) {
				request.getRequestDispatcher("user2.jsp").forward(request,response);
			}else {
				request.getRequestDispatcher("user.jsp").forward(request,response);
			}			
			return;
		}else{
			request.getRequestDispatcher("Login.jsp").forward(request,response);
		}
		
		
		
	}

}
