package com.inautix.ServletController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

import com.inautix.Admin.*;
import com.inautix.Employee.EmployeeDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/AdminServlet2")
public class AdminServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdminServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");  
		PrintWriter out = res.getWriter();  
		HttpSession session=req.getSession();
		String uname=(String)session.getAttribute("uname");    
		String eid=req.getParameter("eid");  
		 RequestDispatcher requestDispatcher=null;

		 EmployeeDao aDao=new EmployeeDao();
		 aDao.delEmployee(uname,eid);
		  
         if(aDao.delEmployee(uname,eid)) 
               {
        	
        	
        	 req.getRequestDispatcher("/DeleteSuccess.jsp").forward(req, res);

               } 
            else 
               {
            
              	 req.getRequestDispatcher("/DeleteFail.jsp").forward(req, res);
                
            }
		          
	}

}
