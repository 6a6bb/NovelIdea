package com.huang.filter;


import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import com.huang.model.User;
/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	@Override
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		String uri = request.getRequestURI();
		String username = request.getParameter("username");
		String user = (String)request.getSession().getAttribute("user");
		if(uri.contains("/Getback.jsp")||uri.contains("/trip.jsp")||uri.contains("/huang_login/Getbackfailuer.jsp")||uri.contains("/huang_login/Loginfilter.jsp")||uri.contains("/huang_login/Register.jsp")||uri.contains("/huang_login/registerfailuer.jsp")||uri.contains("/huang_login/registersuccess.jsp")||uri.contains("/huang_login/Login.jsp")||
			uri.contains("/huang_login/loginservlet")||uri.contains("/huang_login/GetBackServlet")||uri.contains("/huang_login/Register")||uri.contains("/checkcodeservlet")||
			uri.contains("/css")||uri.contains("/js")||uri.contains("/image")) {
			chain.doFilter(request,resp);
		}else {
			if(user != null ) {
				chain.doFilter(request, resp);
			}else {
				request.getRequestDispatcher("/Loginfilter.jsp").forward(request, resp);
			}
		}	
		
}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
