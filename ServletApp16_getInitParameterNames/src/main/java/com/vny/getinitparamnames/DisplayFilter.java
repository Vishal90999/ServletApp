package com.vny.getinitparamnames;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DisplayFilter implements Filter {
	
	FilterConfig fc=null;
	@Override
	public void init(FilterConfig fc) throws ServletException {
		this.fc=fc;
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/html");
		
		pw.println("welcome user::"+req.getParameter("uname"));
		pw.println("<br>====Details from FilterConfig====");
		
		pw.println("<br>Filter Name::"+fc.getFilterName());
		Enumeration <String> e=fc.getInitParameterNames();
		
		while(e.hasMoreElements())
		{
			pw.println("<br>"+e.nextElement());
		}//end of loop
		
		pw.println("<br>=====Iterator<E>=====");
		
		Enumeration <String> e1=fc.getInitParameterNames();
		   Iterator<String> it= e1.asIterator();
		   
		   it.forEachRemaining((k)->{
			   pw.println("<br>"+fc.getInitParameter(k));
			   
		   });
		
		
	}

}
