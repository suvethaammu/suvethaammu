package com.inautix.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inautix.dao.CommentDao;
import com.inautix.dao.TopicDao;

/**
 * Servlet implementation class commentServlet
 */
@WebServlet("/commentServlet")
public class commentServlet extends HttpServlet {
	/*private static final long serialVersionUID = 1L;
       
    *//**
     * @see HttpServlet#HttpServlet()
     *//*
    public commentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	*//**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 *//**/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str=request.getParameter("topics");
		TopicDao tdao=new TopicDao();
		int str1=TopicDao.getId(str);
		CommentDao cd=new CommentDao();
		String lastcomm=cd.getlastcomment(str1);
		request.setAttribute("lastcomment", lastcomm);
		RequestDispatcher rd=request.getRequestDispatcher("/page3.jsp");  
	      rd.forward(request, response);
		
	}

	/*
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str=request.getParameter("topics");
		String str2=request.getParameter("yc");
		TopicDao tdao=new TopicDao();
		
		 int str1=TopicDao.getId(str);
	      PrintWriter out=response.getWriter();
	      response.getWriter();
	      CommentDao td=new CommentDao();
	      
	      int n1=td.insertcommentDetails(str2,str1);
	      if(n1!=0)
	      {
	    	  request.setAttribute("Message","Comment Posted Successfully");
	      }
	      else
	      {
	    	  out.println("not inserted successfully");
	      }
	      RequestDispatcher rd=request.getRequestDispatcher("/page2.jsp");  
	      rd.forward(request, response);
		
	}

}
