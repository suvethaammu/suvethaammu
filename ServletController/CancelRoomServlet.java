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

import com.inautix.Customer.CustomerDao;

/**
 * Servlet implementation class CancelRoomServlet
 */
@WebServlet("/CancelRoomServlet")
public class CancelRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CancelRoomServlet() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	res.setContentType("text/html");  
		
		PrintWriter out = res.getWriter();  
		          
		HttpSession session=req.getSession();
		String uname=(String)session.getAttribute("uname");
		String hname=(String)session.getAttribute("hname");
		String rid=req.getParameter("rid");  
		
		 RequestDispatcher requestDispatcher=null;
         CustomerDao cdao=new CustomerDao();
          
         if(cdao.cancelRoom(uname,hname,rid)) 
               {
        	 

        	 String message = "Room Cancelled Successfully...!!!!";
        	 req.setAttribute("message", message);
        	 req.getRequestDispatcher("/CancelSuccess.jsp").forward(req, res);
                    
               } 
            else 
               {
            	String message = "Error in cancelling room....!!!!";
             	 req.setAttribute("message", message);
             	 req.getRequestDispatcher("/CancelFail.jsp").forward(req, res);
            }
                
	}

	}

