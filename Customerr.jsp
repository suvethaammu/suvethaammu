<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css" type="text/css" />
<style>
body{
background: url('roomm.jpg');
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


 
<form action=" "> 

<center>

	<%  String uname=session.getAttribute("uname").toString();
	session.setAttribute("uname",uname);
	%>

<ul>
  <li><a href="ViewProfile.jsp">VIEW PROFILE</a></li>
  <li><a href="UpdateProfile.jsp">EDIT PROFILE</a></li>
  <li><a href="BookRoom.jsp">BOOK ROOMS</a></li>
  <li><a href="CancelRoom.jsp">CANCEL ROOMS</a></li>
  <li><a href="payment.jsp">PAYMENT</a></li>
   <li><a href="CusLogin.jsp">LOGOUT</a></li>
</ul>

</center>
<a href="CusLogin.jsp">BACK...</a>  
<div class="content">
    
</div>
</form>

</body>
</html>