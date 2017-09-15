package com.inautix.ServletController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.inautix.Hotel.HotelDao;
import com.inautix.Room.RoomDao;


@WebServlet("/UpdateHotel")
public class UpdateHotel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UpdateHotel() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
			HttpSession session=req.getSession();
			String uname=(String)session.getAttribute("uname");
			String hotel=req.getParameter("hotel");  
			HotelDao aDao=new HotelDao();
	        RequestDispatcher requestDispatcher=null;
	        if(aDao.updateHotel(hotel,uname)) 
				   {
					String message = "LOCATION UPDATED SUCCESSFULLY!!!!";
		        	 req.setAttribute("message", message);
		        	 req.getRequestDispatcher("/Adminn.jsp").forward(req, res);
					} 
					else
					{
						String message = "ERROR IN UPDATING LOCATION!!!!";
			           	 req.setAttribute("message", message);
			           	 req.getRequestDispatcher("/Adminn.jsp").forward(req, res);
					}
			
		}

}
