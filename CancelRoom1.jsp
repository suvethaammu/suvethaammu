<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.inautix.Room.*" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="js/script.js"></script>
</head>
<link rel="stylesheet" href="style.css" type="text/css" />


<body>
<%@include file="CancelRoom.jsp" %>
<form  action=" "  onSubmit="return validate34();" method="post" >

<%
  //String uname=request.getParameter("uname");
  String uname3=(String)session.getAttribute("uname");
  session.setAttribute("uname",uname3);
 
  %>
 
   <%
	String hname=request.getParameter("hname");
   session.setAttribute("hname",hname);
	RoomDao roomDao = new RoomDao();
	List<RoomBean> holdingList = roomDao.getHoldings(hname);
	 Iterator<RoomBean> itr1 =  holdingList.iterator();
	out.print("<html><head><body><center><h2>ROOM DETAILS!!!!!</h2><table border='2'><tr bgcolor=pink><th>HOTEL_NAME</th><th>R1</th><th>R2</th><th>R3</th><th>R4</th><th>R5</th><th>ROOM_TYPE</th><th>ROOM_PRICE</th></tr>");
	while(itr1.hasNext()){
		RoomBean roBean = itr1.next();
	out.print("<tr bgcolor=yellow><td>"+roBean.getHotel_name()+"</td><td>"+roBean.getR1()+"</td><td>"+roBean.getR2()+"</td><td>"+roBean.getR3()+"</td><td>"+roBean.getR4()+"</td><td>"+roBean.getR5()+"</td><td>"+roBean.getRoom_type()+"</td><td>"+roBean.getRoom_price()+"</td></tr><tr>");
	}
	out.print("</tr></table></center></body></html>");

	%>
	<br><br><br>
      <center>
   Enter room_id:</td><td><input type="text" style="font-size: 12pt; height: 30px; width:150px;" id="rid" name="rid"/>
   <br><br>
   
   <input type="submit" style="font-size: 12pt; height: 30px; width:150px;background-color: #e7e7e7; color: black;" value="CANCEL" id="cancel" onCLick="form.action='CancelRoomServlet'"/>
    
 
 
   </center>
   
    </form>
</body>
</html>