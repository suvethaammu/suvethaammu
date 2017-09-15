<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="Customerr.jsp" %>
<h3> Amount paid by <%
  //String uname=request.getParameter("uname");
  String uname2=(String)session.getAttribute("uname");
  session.setAttribute("uname",uname2);
 out.print(uname2);
  %> is successful!!!</h3>

</body>
</html>