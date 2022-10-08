package com.vny.emp;

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
	public class InsertEmployeeDetails extends GenericServlet {

		@Override
		public void service(ServletRequest req, ServletResponse resp) 
				throws ServletException, IOException
		{
			PrintWriter pw=resp.getWriter();
			resp.setContentType("text/html");
			
			EmployeeBean eb=new EmployeeBean();//Bean Object
			
			eb.setEid(req.getParameter("eid"));
			eb.setEname(req.getParameter("ename"));
			eb.setJob(req.getParameter("job"));
			eb.setSal(Float.parseFloat(req.getParameter("sal")));
			eb.setDno(Integer.parseInt(req.getParameter("dno")));
			
			//Object creation of InsertDOA for insert method calling
			InsertDOA i=new InsertDOA();
			
		    int k = i.insert(eb);
		    //insert method return k;(integer value)
		    
		    if(k>0)
		    {
		    	pw.println("<h3>Employee Details inserted Successfully...</h3><br>");
		    	
		    	RequestDispatcher rd=req.getRequestDispatcher("index.html");
		    	rd.include(req, resp);
		    }
			
		}

}
