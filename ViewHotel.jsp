<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.inautix.Hotel.*" import="java.util.List" import="java.util.Iterator"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="Adminn.jsp" %>

<jsp:useBean id="hotDao" class="com.inautix.Hotel.HotelDao" scope="session"></jsp:useBean>
<%
	 String uname33=session.getAttribute("uname").toString();
	session.setAttribute("uname",uname33);
	
	List<HotelBean> holdingList = hotDao.getHotels(uname);
	Iterator<HotelBean> itr1 =  holdingList.iterator();
	out.print("<html><head><body><center><table border='2'><tr bgcolor=yellow><th>HOTEL_ID</th><th>HOTEL_NAME</th><th>LOCATION</th></tr>");
	while(itr1.hasNext()){
		HotelBean hotBean = itr1.next();
	out.print("<tr bgcolor=pink><td>"+hotBean.getHotel_id()+"</td><td>"+hotBean.getHotel_name()+"</td><td>"+hotBean.getLocation()+"</td></tr><tr>");
	}
	out.print("</tr></table></center></body></html>");

	%>
</body>
</html>