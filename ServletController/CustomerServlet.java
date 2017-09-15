package com.inautix.ServletController;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.inautix.Customer.*;

	
@WebServlet("/CustomerServlet")
	public class CustomerServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

public CustomerServlet() {
                super();
                // TODO Auto-generated constructor stub
}

protected void doPost(HttpServletRequest request, HttpServletResponse response)
                                throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        
        
        //request.getRequestDispatcher("CusLogin.jsp").include(request, response);  
          
        String uname = request.getParameter("uname");
        String pwd = request.getParameter("psw");
        HttpSession session=request.getSession();
        session.setAttribute("uname",uname);
        CustomerDao aDao=new CustomerDao();
        RequestDispatcher requestDispatcher=null;
        
       	   try {
			if(aDao.isValid(uname,pwd)) 
			   {
				out.println("Success...");
				Cookie ck=new Cookie("uname",uname);
				 ck.setMaxAge(12);  
			        response.addCookie(ck);  
			        requestDispatcher = request.getRequestDispatcher("Customerr.jsp");
			        requestDispatcher.forward(request, response);
				               
				} 
				else
				{
			out.print("Invalid username or password....");
			    requestDispatcher = request.getRequestDispatcher("CusLogin.jsp");
			    requestDispatcher.include(request, response);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
                              
                }


}




