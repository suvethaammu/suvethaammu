<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.inautix.Room.*" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="js/script.js"></script>
</head><link rel="stylesheet" href="style.css" type="text/css" />


<body>
<%@include file="BookRoom.jsp" %>

<%
  //String uname=request.getParameter("uname");
  String uname2=(String)session.getAttribute("uname");
  session.setAttribute("uname",uname2);
 
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
	<form  action=" "  onSubmit="return validate3();" method="post" >
	<script src="js/script.js"></script>
	
	 <table align="center">
     <tr><td>Enter room_id:</td><td><input type="text"  id="rid" name="rid"/></td></tr>
    <tr><td>Enter Check_IN Date:</td><td><input type="text"  id="indate" name="indate"/></td></tr>
       <tr><td>Enter Check_Out Date:</td><td><input type="text" id="outdate" name="outdate"/></td></tr>
          <tr><td>Enter No.of persons:</td><td><input type="text"  id="person" name="person"/></td></tr>
 
  
    <tr><td><input type="submit" name="submit" style="font-size: 12pt; height: 50px; width:120px;background-color: #e7e7e7; color: black;" value="BOOK" id="book" onCLick="form.action='BookRoomServlet'"/></td><tr></tr><tr></tr><tr></tr>
    
 
   </table>
   
    </form>
    
    
</body>
</html>