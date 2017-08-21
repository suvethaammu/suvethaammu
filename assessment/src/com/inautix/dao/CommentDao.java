package com.inautix.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.inautix.connectionmanager.ConnectionManager;

public class CommentDao {
public static int insertcommentDetails(String desc,int  topicid) {
		
		Connection conn=ConnectionManager.DBConnection();
		PreparedStatement pstmt = null;
		ResultSet resultset=null;
		int result=0;
		try
		{
			 
			 String searchquery="insert into comment_XBBNHHC(comment_desc,comment_date,topic_id)values (?,?,?)";
			 pstmt=conn.prepareStatement(searchquery);
					 
			  pstmt.setString(1,desc);
			  SimpleDateFormat sdf=new SimpleDateFormat("MM-dd-yyyy");
	 			 java.util.Date date = new Date();
	 			 java.sql.Date sqlDate = new java.sql.Date(date.getTime());   
	 			 pstmt.setDate(2,sqlDate);
	 		     pstmt.setInt(3,topicid);
			  
			  
			   
			  result= pstmt.executeUpdate();	
		} 
			  catch (SQLException e) {
					
					e.printStackTrace();
				}
			
				
		       return result;
				
			}

public String getlastcomment(int str1) {

	Connection conn=ConnectionManager.DBConnection();
	PreparedStatement pstmt = null;
	ResultSet resultset=null;
	String lastcomment=null;
	String searchquery="select comment_desc from comment_xbbnhhc where topic_id=?";
	try {
		pstmt=conn.prepareStatement(searchquery);
		pstmt.setInt(1,str1);
		resultset=pstmt.executeQuery();
		while(resultset.next())
		{
			lastcomment=resultset.getString("comment_desc");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return lastcomment;
}



}
