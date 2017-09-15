package com.inautix.ServletController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inautix.Customer.*;

public class CusSignUpServlet extends HttpServlet
{       
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
    {
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




