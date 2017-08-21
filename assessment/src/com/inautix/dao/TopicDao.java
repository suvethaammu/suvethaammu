package com.inautix.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.inautix.connectionmanager.ConnectionManager;

public class TopicDao {
	public static int inserttopicDetails(String topicname) {
		
		Connection conn=ConnectionManager.DBConnection();
		PreparedStatement pstmt = null;
		ResultSet resultset=null;
		int result=0;
		try
		{
			 
			 String searchquery="insert into TOPIC_XBBNHHC(TOPIC_desc)values (?)";
			 pstmt=conn.prepareStatement(searchquery);
					 
			  pstmt.setString(1,topicname);
			  
			   
			  result= pstmt.executeUpdate();	
		} 
			  catch (SQLException e) {
					
					e.printStackTrace();
				}
			
				
		       return result;
				
			}


public static int getId(String tid){

	        Connection conn=ConnectionManager.DBConnection();
              PreparedStatement stmt = null;
              int rs = 0;

              ResultSet rs1 = null;

              String sql= "select topic_id from topic_xbbnhhc where topic_desc=?";

              try{

                  stmt=conn.prepareStatement(sql);

                  stmt.setString(1, tid);

                  rs1=stmt.executeQuery();

                 while(rs1.next()){

                         rs=rs1.getInt("topic_id");

                 }
              }
              catch (SQLException e) {
					
					e.printStackTrace();
				}
			return rs;
			

               

              
}
}
