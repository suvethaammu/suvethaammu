package com.inautix.ServletController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.inautix.Admin.AdminDao;
import com.inautix.Customer.CustomerDao;
import com.inautix.Room.RoomBean;
import com.inautix.Room.RoomDao;

@WebServlet("/BookRoomServlet")
public class BookRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BookRoomServlet() {
        super();
      
    }

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");  
		
		PrintWriter out = res.getWriter();  
		          
		HttpSession session=req.getSession();
		String uname=(String)session.getAttribute("uname");
		String hname=(String)session.getAttribute("hname");
		String rid=req.getParameter("rid");  
		
		String indate=req.getParameter("indate");  
		String outdate=req.getParameter("outdate");  
		String person=req.getParameter("person").toString(); 
		
		
		 RequestDispatcher requestDispatcher=null;
         CustomerDao cdao=new CustomerDao();
          if(cdao.checkRoom(hname,rid))
          {
        	  RoomBean roBean=null;
        	  out.print("Available");
        	  if(cdao.bookRoom(uname,hname,rid,indate,outdate,person)) 
               {
        		  System.out.println(hname);
        		   
        			RoomDao roomDao = new RoomDao();
        			List<RoomBean> holdingList1 = roomDao.getroomPrice(hname);
        			 Iterator<RoomBean> itr11 =  holdingList1.iterator();
        			
        			while(itr11.hasNext()){
        			
        				roBean = itr11.next();
        				
        				out.print(roBean.getRoom_price());
        				System.out.print(roBean.getRoom_price());
        			}

        	 String message = "Room Booked Successfully...!!!!   The amount paid is...";
        	 req.setAttribute("obj",roBean);
        	 req.setAttribute("message", message);
        	 req.getRequestDispatcher("/BookSuccess.jsp").forward(req, res);
                    
               } 
            else 
               {
      String message = "Error in booking room....!!!!";
             	 req.setAttribute("message", message);
             	 req.getRequestDispatcher("/BookFail.jsp").forward(req, res);
            }
          }
          else
          {
        	  String message = "Error in booking room....!!!!";
          	 req.setAttribute("message", message);
          	 req.getRequestDispatcher("/BookFail.jsp").forward(req, res);
          }
	}


}
