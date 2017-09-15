package com.inautix.ServletController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inautix.Customer.CustomerDao;

/**
 * Servlet implementation class CustSignUpServlet
 */
@WebServlet("/CustSignUpServlet")
public class CustSignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustSignUpServlet() {
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
		PrintWriter out=res.getWriter();
        String uid=req.getParameter("id1");
        String uname=req.getParameter("uname");
       
        String pwd=req.getParameter("pwd");
        String cpwd=req.getParameter("cpwd");
        String phno=req.getParameter("phno");
        String addr=req.getParameter("addr");
     
        RequestDispatcher requestDispatcher=null;
       CustomerDao edao=new CustomerDao();
        
       if(edao.signUpisValid(uid,uname,pwd,cpwd,phno,addr)) 
             {
            
            requestDispatcher = req.getRequestDispatcher("CusLogin.jsp");
                requestDispatcher.forward(req, res);
                  
             } 
          else 
             {
             out.println("<script type=\"text/javascript\">");
             out.println("alert('error');");
             //out.println("location='Emplogin.html';");
              out.println("</script>");
                requestDispatcher = req.getRequestDispatcher("Cuslogin.jsp");
                requestDispatcher.include(req, res);
               
          }
              
	}

}
