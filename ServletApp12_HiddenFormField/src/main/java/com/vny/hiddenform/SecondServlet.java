package com.vny.hiddenform;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/second")
public class SecondServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/html");
		pw.println("<h2>======Product Details======</h2>");
		pw.println("<br>product Code:"+req.getParameter("code"));
		pw.println("<br>product Name:"+req.getParameter("name"));
		pw.println("<br>product Price:"+req.getParameter("price"));
		pw.println("<br>product Quantity::"+req.getParameter("qty")+"<br><br>");
		
		RequestDispatcher rd=req.getRequestDispatcher("input.html");
		rd.include(req, resp);
	}
	

}
