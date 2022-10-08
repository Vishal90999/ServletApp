package com.vny.filterconfig;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterConfig11 implements Filter {
	
	public FilterConfig fc=null;
	
	
//	public void init(FilterConfig fc) throws ServletException 
//	{
//		this.fc=fc;
//	}

	
	@Override
	public void init(FilterConfig fc) throws ServletException {
		this.fc=fc;
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/html");
		
		pw.println("Welcome user::"+req.getParameter("uname"));
		pw.println("<br>===Details from Filter config====");
		pw.println("<br>FilterName::"+fc.getFilterName());
		pw.println("<br>ConfigValue::"+fc.getInitParameter("aaa"));	
	
		
	}

}
