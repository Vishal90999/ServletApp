package com.vny.emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewEmployeeDetails extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse resp) 
			throws ServletException, IOException
	{
		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/html");
		
		//object creation of RetrieveDAO class 
		RetrieveDAO r=new RetrieveDAO();
		//method calling which is present inside this class
		//which return ArrayList
		ArrayList<EmployeeBean> al=r.retrieve();
		
		//data retrieve from ArrayList
		
		if(al.size()==0)
		{
			pw.println("<h3>Employee Details not Found...</h3><br>");
		}
		else
		{
			Iterator<EmployeeBean> i=al.iterator();
			pw.println("<b><i><=====Employee Details=====></i></b><br><br>");
			pw.println("<b>Empid</b>&nbsp&nbsp"+"<b>Name</b>&nbsp&nbsp"+""
					+ "<b>Job</b>&nbsp&nbsp&nbsp&nbsp"+"<b>Salary</b>"
					+ "&nbsp&nbsp"+"&nbsp&nbsp<b>DeptNo</b><br><br>");
			while(i.hasNext())
			{
				EmployeeBean eb2=(EmployeeBean)i.next();
				pw.println(eb2.getEid()+"&nbsp;&nbsp;"+
				           eb2.getEname()+"&nbsp;&nbsp;"+
					       eb2.getJob()+"&nbsp;&nbsp;"+
				           eb2.getSal()+"&nbsp;&nbsp;"+
						   eb2.getDno()+"<br><br>"
				           );
						
			}//end of while
			pw.println("<br>");
			
		}//end of else
		
		RequestDispatcher rd=req.getRequestDispatcher("index.html");
		     rd.include(req, resp);
	}

}
