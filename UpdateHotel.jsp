<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<script src="js/script.js"></script>

<%@include file="Adminn.jsp" %>

<form action=" " onSubmit="return validateHotel();" method="post">
 
     <center>
    
   Update Hotel_location:<input type="text" style="font-size: 12pt; height: 30px; width:150px;"  id="hotel" name="hotel"/><br><br>
   
    <input type="submit" style="font-size: 12pt; height: 30px; width:150px;background-color: #e7e7e7; color: black;"  value="UPDATE" id="update" onCLick="form.action='UpdateHotel'"/>
    
</center>
  </form>
  
   	<%  String uname4=(String)session.getAttribute("uname");
	session.setAttribute("uname",uname4);
	%>
</body>
</html>