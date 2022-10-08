package com.vny.servletlifecycle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dis")
@SuppressWarnings("serial")
public class ServletLifeCycle extends HttpServlet{
	
	public ServletLifeCycle() {
		System.out.println("ServletLifeCycle.ServletLifeCycle(0-param)");
	}
	

	@Override
	public void init() throws ServletException {
		System.out.println("ServletLifeCycle.init()");
	}


	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("ServletLifeCycle.service()");
	}


	@Override
	public void destroy() {
		System.out.println("ServletLifeCycle.destroy()");
	}
	
	

}
