package  com.huang.controller;

import  java.io.IOException;
import java.sql.SQLException;
import  java.util.List;
import  javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import  javax.servlet.http.HttpServlet;
import  javax.servlet.http.HttpServletRequest;
import  javax.servlet.http.HttpServletResponse;

import com.huang.service.impl.FindServiceImpl;

@WebServlet("/FindServlet")
public class FindServlet extends HttpServlet {
private   static   final   long   serialVersionUID  = 1L;
@Override
protected   void  doGet(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
	FindServiceImpl find=new FindServiceImpl();// 当前页码	
	int  currPage = 1;	
	// 判断传递页码是否有效	
	if (request.getParameter("page") != null ){	
		// 对当前页码赋值	
		currPage = Integer. parseInt (request.getParameter("page"));	
	}
	try {
		request.setAttribute("list",find.getList(currPage));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	// 实例化StringBuffer	
	StringBuffer sb =find.getBar(currPage);
	// 将分页条的字符串放置到request之中	
	request.setAttribute("bar", sb.toString());	
	// 转发到product_list.jsp页面	
	request.getRequestDispatcher("all_information.jsp").forward(request, response);
	}
}