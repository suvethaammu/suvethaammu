package com.inautix.connectionmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	public static Connection DBConnection()
	{
	Connection con = null;
	try {
		
		Class.forName("org.apache.derby.jdbc.ClientDriver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	
	try {
		con=DriverManager.getConnection("jdbc:derby://172.24.34.118:1527/sample","user","pwd");
	   
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return con;
	}
}
