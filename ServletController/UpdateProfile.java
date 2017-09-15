package com.inautix.ServletController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.inautix.Customer.CustomerDao;
import com.inautix.Hotel.HotelDao;


@WebServlet("/UpdateProfile")
public class UpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UpdateProfile() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session=req.getSession();
		String uname=(String)session.getAttribute("uname");
		String update=req.getParameter("update");
		System.out.println(update);
		String name=req.getParameter("name");  
		System.out.println(name);
		CustomerDao aDao=new CustomerDao();
        RequestDispatcher requestDispatcher=null;
        if(update.equals("cust_address")&& aDao.updateAddress(uname,name))
        
        
			   {
				String message = "UPDATED SUCCESSFULLY!!!!";
	        	 req.setAttribute("message", message);
	        	 req.getRequestDispatcher("/Customerr.jsp").forward(req, res);
				} 
			
        
        else if(update.equals("cust_phno")&& aDao.updatephno(uname,name))
            
        
			   {
				String message = "UPDATED SUCCESSFULLY!!!!";
	        	 req.setAttribute("message", message);
	        	 req.getRequestDispatcher("/Customerr.jsp").forward(req, res);
				} 
				else
				{
					String message = "ERROR IN UPDATING!!!!";
		           	 req.setAttribute("message", message);
		           	 req.getRequestDispatcher("/Customerr.jsp").forward(req, res);
				}
        
		
	}

}
