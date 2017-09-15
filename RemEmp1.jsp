<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="style.css" type="text/css" />


<body>
<script src="js/script.js"></script>

<%@include file="Managerr.jsp" %>

<form action=" " onSubmit="return validate2()" method="post">

   <center>
      
   Enter Employee_ID:<input type="text" style="font-size: 12pt; height: 30px; width:150px;"  id="eid" name="eid"/><br><br>
   
    <input type="submit" style="font-size: 12pt; height: 30px; width:150px;background-color: #e7e7e7; color: black;"  value="REMOVE" id="login" onCLick="form.action='ManagerServlet2'"/>
	</center>
  </form>
 
   	<%  String uname5=(String)session.getAttribute("uname");
	session.setAttribute("uname",uname5);
   
		
		%>
		
</body>
</html>