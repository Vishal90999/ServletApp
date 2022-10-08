package com.vishal;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/vishal")
public class MyFirstServletApp_1 extends GenericServlet {
	
public void init()throws ServletException
{
	//no code
}

@Override
public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException 
{
//	
	
	String bcode=req.getParameter("code");
	String bname =req.getParameter("name");
	String bauthor=req.getParameter("author");
	float bprice=Float.parseFloat(req.getParameter("price"));
	int bqty=Integer.parseInt(req.getParameter("qty"));
	
	
	PrintWriter pw=	resp.getWriter();
	resp.setContentType("text/html");
	pw.println("<h1>======Book Details Saved..====</h1>");
	
    pw.println("<br>Book Code:"+bcode);
    pw.println("<br>Book Name:"+bname);
    pw.println("<br>Book Author:"+bauthor);
    pw.println("<br>Book Price:"+bprice);
    pw.println("<br>Book Quantity:"+bqty);
    
    
}
public void destroy() {
//	no code
}

	


}
