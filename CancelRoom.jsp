<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.Connection" import="java.sql.PreparedStatement"
import="java.sql.ResultSet"
import="java.sql.SQLException"
import="java.util.*"
import="java.sql.*"
import="com.inautix.Room.*"
import="com.inautix.Hotel.ConnectionManager;"
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="js/script.js"></script>
</head>
<link rel="stylesheet" href="style.css" type="text/css" />


<body>
<%@include file="Customerr.jsp" %>
<form  action=" "  onSubmit="return validate4();" >
 <%
  //String uname=request.getParameter("uname");
  String uname1=(String)session.getAttribute("uname");
  session.setAttribute("uname",uname1);
 
  %>
 
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
				<tr><td>Hotel Name :</td><td>			
				<select id="hname" name="hname" style="font-size:15pt; height: 30px; width:150px;">

              <option value="0" >----Select----</option>

                   <%  while(rs.next()){ %>

                         <option  ><%= rs.getString(2)%></option>

                    <% } %>

                </select></td></tr>


			<%
			}
			catch(SQLException sqe)
			{ 
			out.println(sqe);
			}
%>
   </td></tr>
  
    </table>
     <center>
 <br><input type="submit" style="font-size: 12pt; height: 30px; width:150px;background-color: #e7e7e7; color: black;" value="SEARCH" id="search" onCLick="form.action='CancelRoom1.jsp'"/>
    
     
    </center>
 
    </form>
</body>
</html>