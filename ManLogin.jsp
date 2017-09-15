<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.Connection" import="java.sql.PreparedStatement"
import="java.sql.ResultSet"
import="java.sql.SQLException"
import="java.util.*"
import="java.sql.*"
import="com.inautix.Room.*"
import="com.inautix.Hotel.*"
import="com.inautix.Employee.*"
import="com.inautix.Admin.*"
import="com.inautix.Hotel.ConnectionManager;"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css" type="text/css" />

</head>
<script src="js/script.js"></script>
<style>

body{
background: url('login (1).jpg');
background-repeat: no-repeat;
background-size:100%;
   -webkit-background-size: cover;
   -moz-background-size: cover;
   -o-background-size: cover;
     width: 80%;
                height: 100%;
                position: fixed;
                left: 0px;
                top: 0px;
                z-index: -99999;
                padding:10%;
        font-size: 150%;  
        color: white;   
}
</style>
<body>
<br><br><a href="Menu.html">BACK</a>
<center>
<form id="LOGIN" action=" "  onSubmit="return validate5();" method="post">
 <br><br>
      <table align="center">
   
    <%
			Connection con = null;
			PreparedStatement ps = null;
			try
			{
			Class.forName("org.apache.derby.jdbc.ClientDriver");
        	con=DriverManager.getConnection("jdbc:derby://localhost:1527/Hoteldb","user","pwd");
			String sql = "SELECT * FROM T_XBBNHHV_HOTEL";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(); 
			%>
			<tr><td><b>Hotel Name :</b></td><td>
			<select id="hname" name="hname" style="font-size:12pt; height: 25px; width:120px;">

              <option value="0">Select</option>

                   <%  while(rs.next()){ %>

                         <option ><%= rs.getString(2)%></option>

                    <% } %>

                </select></td></tr>
					

			<%
			}
			catch(SQLException sqe)
			{ 
			out.println(sqe);
			}
%>
 
 
  	<tr><td><b>ManagerID:</b></td><td><input type="text" style="font-size: 12pt; height: 25px; width:200px;" placeholder="Enter Username" id="uname" name="uname"></td></tr>
  	<tr><td> <b>Password:</b></td><td>
	<input type="password" style="font-size: 12pt; height: 25px; width:200px;" placeholder="Enter Password" id="psw" name="psw" ></td></tr>
    
    </table>
    <center>
    <input type="submit"  style="font-size: 12pt; height: 30px; width:100px;background-color: #e7e7e7; color: black;" id="LOGIN" value="LOGIN"  onclick="form.action='ManagerServlett'"><br><br>
   </center>



</center>
</body>
</html>