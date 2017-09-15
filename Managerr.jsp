<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="js/script.js"></script>
<style>
body{
background: url('reception.jpg');
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
        color: black;   
}

ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}

li {
    float: left;
}

li a {
    display: inline-block;
    color: white;
    text-align: center;
    padding: 10px 16px;
    text-decoration: none;
}

li a:hover {
    background-color: #111;
}
</style>
<link rel="stylesheet" href="style.css" type="text/css" />
</head>
<body>


<a href="ManLogin.jsp">BACK...</a>   
<form action=" "> 

<center>

	<%
    String hname=(String)session.getAttribute("hname");
	session.setAttribute("hname",hname);
	String uname=(String)session.getAttribute("uname");
	session.setAttribute("uname",uname);
	
	%>

<ul>
  <li><a href="UpdateRoom.jsp">Update Room </a></li>
  <li><a href="ViewRoom.jsp">View Room Details</a></li>
  <li><a href="AddEmp1.jsp">Add Employee</a></li>
   <li><a href="RemEmp1.jsp">Remove Employee</a></li>
  <li><a href="ViewEmp1.jsp">View Employee Details</a></li>
  <li><a href="BookDetails.jsp">Booking Details</a></li>
  
</ul>
<marquee><h1 style="font-family:Algerian;"><font color="#808080",size="500%">MANAGER!!!!!!</font></h1></marquee>

</center>
 
</form>

</body>
</html>