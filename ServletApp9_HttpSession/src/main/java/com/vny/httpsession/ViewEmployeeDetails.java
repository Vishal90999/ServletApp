package com.vny.httpsession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/view2")
public class ViewEmployeeDetails extends HttpServlet {

	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException
	{
		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/html");
		
		HttpSession hs=req.getSession(false);
		
		if(hs==null) 
		{
			pw.println("Session Expired...");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, resp);
		}
		else 
		{
			UserBean ub1=(UserBean)hs.getAttribute("uBean");
		
		pw.println("Welcome user <h1>"+ub1.getlName()+"</h1><br>");
	
		RequestDispatcher rd=req.getRequestDispatcher("more.html");
	     rd.include(req, resp);
		
		//object creation of RetrieveDAO class 
		RetrieveEmpDAO r=new RetrieveEmpDAO();
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
		
		
	}

}
	}
