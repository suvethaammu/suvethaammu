package com.inautix.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inautix.dao.TopicDao;

/**
 * Servlet implementation class Topicservlet
 */
@WebServlet("/Topicservlet")
public class Topicservlet extends HttpServlet {
	/*private static final long serialVersionUID = 1L;
       
    *//**
     * @see HttpServlet#HttpServlet()
     *//*
    public Topicservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String str=request.getParameter("tpname");
      PrintWriter out=response.getWriter();
      response.getWriter();
      TopicDao td=new TopicDao();
      
      int n1=td.inserttopicDetails(str);
      if(n1!=0)
      {
    	  request.setAttribute("Message","Topic Posted Successfully");
      }
      else
      {
    	  out.println("not inserted successfully");
      }
      RequestDispatcher rd=request.getRequestDispatcher("/page1.jsp");  
      rd.forward(request, response);
	}

}
