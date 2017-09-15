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

import com.inautix.Employee.EmployeeDao;

/**
 * Servlet implementation class ManagerServlet2
 */
@WebServlet("/ManagerServlet2")
public class ManagerServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");  
		PrintWriter out = res.getWriter();  
		HttpSession session=req.getSession();
		String uname=(String)session.getAttribute("uname");    
		String eid=req.getParameter("eid");  
		 RequestDispatcher requestDispatcher=null;

		 EmployeeDao aDao=new EmployeeDao();
		 aDao.delEmploy(uname,eid);
		  
         if(aDao.delEmploy(uname,eid)) 
               {
        	 String message = "EMPLOYEE REMOVED SUCCESSFULLY!!!!";
        	 req.setAttribute("message", message);
        	 req.getRequestDispatcher("/Managerr.jsp").forward(req, res);

               } 
            else 
               {
            	String message = "ERROR IN REMOVING EMPLOYEE!!!!";
              	 req.setAttribute("message", message);
              	 req.getRequestDispatcher("/Managerr.jsp").forward(req, res);
                
            }
	}

}
