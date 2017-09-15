<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.inautix.Room.*" import="java.util.*;"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="style.css" type="text/css" />


<body >
<script src="js/script.js"></script>

<%@include file="Managerr.jsp" %>

<jsp:useBean id="roomDao" class="com.inautix.Room.RoomDao" scope="session"></jsp:useBean>
<%

	String hname3=(String)session.getAttribute("hname");
	session.setAttribute("hname",hname3);
  List<RoomBean> holdingList = roomDao.getHoldings(hname);
	Iterator<RoomBean> itr1 =  holdingList.iterator();
	out.print("<html><head><body><center><table border='2'><tr bgcolor=pink><th>HOTEL_NAME</th><th>R1</th><th>R2</th><th>R3</th><th>R4</th><th>R5</th><th>ROOM_TYPE</th><th>ROOM_PRICE</th></tr>");
	while(itr1.hasNext()){
		RoomBean roomBean = itr1.next();
	out.print("<tr bgcolor=yellow><td>"+roomBean.getHotel_name()+"</td><td>"+roomBean.getR1()+"</td><td>"+roomBean.getR2()+"</td><td>"+roomBean.getR3()+"</td><td>"+roomBean.getR4()+"</td><td>"+roomBean.getR5()+"</td><td>"+roomBean.getRoom_type()+"</td><td>"+roomBean.getRoom_price()+"</td></tr><tr>");
	}
	out.print("</tr></table></center></body></html>");

	%>
</body>
</html>