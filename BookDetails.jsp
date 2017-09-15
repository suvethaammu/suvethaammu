<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.inautix.Manager.*" import="com.inautix.Employee.*" import="com.inautix.Customer.*" import="java.util.*" import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<%@include file="Managerr.jsp" %>

<%
String hname6=(String)session.getAttribute("hname");
	session.setAttribute("hname",hname6);
	
	ManagerDao mDao = new ManagerDao();
	List<CustomerBean> holdingList =mDao.bookedDetails(hname);
	 Iterator<CustomerBean> itr3 =  holdingList.iterator();
	out.print("<html><head><body><center><table border='2'><tr bgcolor=yellow><th>CUST_ID</th><th>HOTEL_NAME</th><th>ROOM_ID</th><th>CHECK_IN DATE</th><th>CHECK_OUT DATE</th><th>DAYS</th><th>AMOUNT</th></tr>");
	while(itr3.hasNext()){
		CustomerBean roBean = itr3.next();
	out.print("<tr bgcolor=pink><td>"+roBean.getCust_id()+"</td><td>"+roBean.getHotel_name()+"</td><td>"+roBean.getRoom_id()+"</td><td>"+roBean.getCheck_in()+"</td><td>"+roBean.getCheck_out()+"</td><td>"+roBean.getDays()+"</td><td>"+roBean.getAmount()+"</td></tr><tr>");
	}
	out.print("</tr></table></center></body></html>");

	%>
</body>
</html>