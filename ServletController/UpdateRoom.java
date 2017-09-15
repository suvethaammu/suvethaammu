package com.inautix.ServletController;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.inautix.Manager.ManagerDao;
import com.inautix.Room.RoomDao;

/**
 * Servlet implementation class UpdateRoom
 */
@WebServlet("/UpdateRoom")
public class UpdateRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UpdateRoom() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    HttpSession session=req.getSession();
		String hname=(String)session.getAttribute("hname");
		HttpSession session1=req.getSession();
		String uname=(String)session.getAttribute("uname");
        
        int price= Integer.parseInt(req.getParameter("price"));
       
      
       
        
       RoomDao aDao=new RoomDao();
        RequestDispatcher requestDispatcher=null;
        
       
			if(aDao.updateRoom(hname,price)) 
			   {
				String message = "PRICE UPDATED SUCCESSFULLY!!!!";
	        	 req.setAttribute("message", message);
	        	 req.getRequestDispatcher("/Managerr.jsp").forward(req, res);
				} 
				else
				{
					String message = "ERROR IN UPDATING ROOM PRICE!!!!";
		           	 req.setAttribute("message", message);
		           	 req.getRequestDispatcher("/Managerr.jsp").forward(req, res);
				}
		
	}

}
