package com.vny.bookdetails47;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/insert")
public class AddBookDetailsServlet5 extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse resp) 
			throws ServletException, IOException 
	{
		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/html");
	
		BookBean bb= new BookBean();
		bb.setBcode(req.getParameter("bcode"));
		bb.setBname(req.getParameter("bname"));
		bb.setBauthor(req.getParameter("bauthor"));
		bb.setBprice(Float.parseFloat(req.getParameter("bprice")));
		bb.setQty(Integer.parseInt(req.getParameter("bqty")));
		
  /**   Description
    *   BookBean object ready for travel into DB
	*   create object of InsertDAO to insert the Bean object into DB
	*	it return integer value
	*	provide the Bean Object to method and execute method 
	*	(see InsertDAO class) for more clarification
	*/
		
		InsertDAO i=new InsertDAO();
		int k=i.insert(bb);
		
		//direct call to method
		//int k=new InsertDAO().insert(bb);
		
		if(k>0)
		{
			pw.println("<b>Book Detatails inserted Successfully..<b><br><br>");
			
			RequestDispatcher rd=req.getRequestDispatcher("input.html");
			rd.include(req, resp);
		}
		
		
		
		
	}

}
