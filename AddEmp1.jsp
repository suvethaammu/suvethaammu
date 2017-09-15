<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="js/script.js"></script>
<link rel="stylesheet" href="style.css" type="text/css" />

</head>
<body>
<script src="js/script.js"></script>

<%@include file="Managerr.jsp" %>

<form action=" " onSubmit="return validate1();" method="post">
   <table align="center">
   
      <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr>
      
    <tr><td>Enter Employee_ID:</td><td><input type="text"  id="eid" name="eid"/></td>
    <tr><td>Enter Employee_Name:</td><td><input type="text"  id="ename" name="ename"/></td>
    <tr><td>Enter Employee_Password:</td><td><input type="password"  id="epwd" name="epwd"/></td>
   <tr><td>Re-Enter Password:</td><td><input type="password"  id="cpwd" name="cpwd"/></td>
    <tr><td>Enter Employee Designation:</td><td><input type="text"  id="edesig" name="edesig"/></td><tr></tr><tr></tr><tr></tr>
 <tr><td>Enter Employee Salary:</td><td><input type="text"  id="esal" name="esal"/></td><tr></tr><tr></tr><tr></tr>
    </table>
   <center><input type="submit" style="font-size: 12pt; height: 30px; width:150px;background-color: #e7e7e7; color: black;"  value="ADD" id="login" onCLick="form.action='ManagerInsert'"/></center><br><br>
    
	
  </form>
  
   	<%  String uname9=(String)session.getAttribute("uname");
	session.setAttribute("uname",uname9);
   
		
		%>
  
</body>
</html>