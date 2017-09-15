<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.inautix.Customer.*" import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<%@include file="Customerr.jsp" %>

<jsp:useBean id="custDao" class="com.inautix.Customer.CustomerDao" scope="session"></jsp:useBean>
<%
String uname1=(String)session.getAttribute("uname");
session.setAttribute("uname1",uname1);
		
		
		List<CustomerBean> customerList = custDao.getCustomer(uname1);
		Iterator<CustomerBean> itr =  customerList.iterator();
		out.print("<html><head><body><center><table border='2'><tr bgcolor=pink><th>ID</th><th>NAME</th><th>PHONE_NO</th><th>ADDRESS</th></tr>");
		while(itr.hasNext())
		{
			CustomerBean custBean = itr.next();
			out.print("<tr bgcolor=yellow><td>"+custBean.getCust_id()+"</td><td>"+custBean.getCust_name()+"</td><td>"+custBean.getCust_phno()+"</td><td>"+custBean.getCust_address()+"</td></tr><tr>");
		}
%>
</body>
</html>