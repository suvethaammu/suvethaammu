<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css" type="text/css" />

<title>Insert title here</title>

</head>

<body>
<%@include file="Adminn.jsp" %>
<form action=" " onSubmit="return validate2()" method="post">
<script src="js/script.js"></script>
   <table align="center">
      <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr>
    <tr><td>Enter Employee_ID:</td><td><input type="text" style="font-size: 12pt; height: 30px; width:150px;" id="eid" name="eid"/></td>
   
    <tr><td><input type="submit" style="font-size: 12pt; height: 30px; width:150px;background-color: #e7e7e7; color: black;"   value="REMOVE" id="login" onCLick="form.action='AdminServlet2'"/></td>
	
 
   </table>
    </form>
   	<%  String uname1=(String)session.getAttribute("uname");
	session.setAttribute("uname",uname1);
   
		
		%>
</body>
</html>