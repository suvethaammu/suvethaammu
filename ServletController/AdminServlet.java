package com.inautix.ServletController;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.inautix.Admin.*;

	
@WebServlet("/AdminServlet")
	public class AdminServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

public AdminServlet() {
                super();
                // TODO Auto-generated constructor stub
}

protected void doPost(HttpServletRequest request, HttpServletResponse response)
                                throws ServletException, IOException {
	
        PrintWriter out = response.getWriter();
        String admin_id1 = request.getParameter("uname");
        String admin_pwd1 = request.getParameter("psw");
        HttpSession session=request.getSession();
        session.setAttribute("uname",admin_id1);
        
        AdminDao aDao=new AdminDao();
        RequestDispatcher requestDispatcher=null;
        
       	   try {
			if(aDao.isValid(admin_id1,admin_pwd1)) 
			   {
			        requestDispatcher = request.getRequestDispatcher("Adminn.jsp");
			        requestDispatcher.forward(request, response);
				               
				} 
				else
				{
			out.print("Invalid username or password....");
			    requestDispatcher = request.getRequestDispatcher("AdLogin.jsp");
			    requestDispatcher.include(request, response);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
                              
   }


}




