package com.inautix.ServletController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.inautix.Admin.AdminDao;


@WebServlet("/AdminInsert")
public class AdminInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdminInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");  
		PrintWriter out = res.getWriter(); 
		
		HttpSession session=req.getSession();
		String uname=(String)session.getAttribute("uname");
		out.print(uname);
		String eid=req.getParameter("eid");  
		String ename=req.getParameter("ename");  
		String epwd=req.getParameter("epwd");  
		String edesig=req.getParameter("edesig");  
		String esal=req.getParameter("esal");  
		 RequestDispatcher requestDispatcher=null;
         AdminDao edao=new AdminDao();
          
         if(edao.insertEmployee(uname,eid,ename,epwd,edesig,esal)) 
               {
        	 String message = "MANAGER ADDED SUCCESSFULLY!!!!";
        	 session.setAttribute("message", message);
        	 req.getRequestDispatcher("/AddSuccess.jsp").forward(req, res);

                    
               } 
            else 
               {
              
            	String message = "ERROR IN INSERTING MANAGER!!!!";
           	 req.setAttribute("message", message);
           	 req.getRequestDispatcher("/AddFail.jsp").forward(req, res);


                 
            }
                
	}

}
