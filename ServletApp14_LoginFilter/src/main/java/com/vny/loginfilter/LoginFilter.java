package com.vny.loginfilter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
@WebFilter("/login")
public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/html");
		
		LogBean lb=new LogBean();
		lb.setuName(req.getParameter("uname"));
		lb.setPwd(req.getParameter("pwd"));
		
		UserBean ub1=new LoginDAO().login(lb);
		
		if(ub1==null)
		{
			pw.println("<h2><b><i>Invalid Login Credential...</i></b></h2><br><br><br>");
			
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, resp);
		}
		else
		{
			//adding attribute to request
			req.setAttribute("fname", ub1.getfName());
			//linking servlet program executing with same url pattern
			chain.doFilter(req, resp);
		}
		
		
	}

}
