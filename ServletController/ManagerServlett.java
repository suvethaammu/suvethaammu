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

import com.inautix.Manager.ManagerDao;

/**
 * Servlet implementation class ManagerServlett
 */
@WebServlet("/ManagerServlett")
public class ManagerServlett extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ManagerServlett() {
        super();
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  PrintWriter out = response.getWriter();
	        String hname = request.getParameter("hname");
	        String uname = request.getParameter("uname");
	        String psw = request.getParameter("psw");
	        HttpSession session=request.getSession();
	       session.setAttribute("hname",hname);
	       HttpSession session1=request.getSession();
	        session1.setAttribute("uname",uname);
	        ManagerDao aDao=new ManagerDao();
	        RequestDispatcher requestDispatcher=null;
	        
	       	   try {
				if(aDao.isValid(hname,uname,psw)) 
				   {
				        requestDispatcher = request.getRequestDispatcher("Managerr.jsp");
				        requestDispatcher.forward(request, response);
					               
					} 
					else
					{
				out.print("Invalid username or password....");
				    requestDispatcher = request.getRequestDispatcher("ManLogin.jsp");
				    requestDispatcher.include(request, response);
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
