package com.inautix.Hotel;

import java.sql.*;
import java.util.*;


public class ConnectionManager {

   static Connection con;
   static String url;
         
   public static Connection getConnection()
   {
     
      try
      {
         String url = "jdbc:odbc:" + "DataSource"; 
         // assuming "DataSource" is your DataSource name

         Class.forName("org.apache.derby.jdbc.ClientDriver");
         
                    	
            try {
            	con=DriverManager.getConnection("jdbc:derby://localhost:1527/Hoteldb","user","pwd");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
             								
         // assuming your SQL Server's	username is "username"               
         // and password is "password"
              
         
         
      }

      catch(ClassNotFoundException e)
      {
         System.out.println(e);
      }

   return con;
}
}