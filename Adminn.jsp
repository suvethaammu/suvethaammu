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
background: url('addemp.png');
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
</head>
<body>
<link rel="stylesheet" href="style.css" type="text/css" />
<script src="js/script.js"></script>
<a href="AdLogin.jsp">BACK...</a>   
<form action=" "> 

<center>

	<%  String uname=session.getAttribute("uname").toString();
	session.setAttribute("uname",uname);
	%>

<ul>
<li><a href="ViewHotel.jsp">Hotel Details</a></li>
<li><a href="UpdateHotel.jsp">Update Hotel Details</a></li>
  <li><a href="AddEmp.jsp">Add Mangaer</a></li>
  <li><a href="RemEmp.jsp">Remove Manager</a></li>
  <li><a href="ViewEmpp.jsp">View Manager Details</a></li>
  
</ul>
<marquee><h1 style="font-family:Algerian;"><font color="#808080",size="500%">ADMIN!!!!!!</font></h1></marquee>
</center>
 
</form>
</body>
</html>