<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.inautix.Employee.*" import="com.inautix.Admin.*" import="java.util.List" import="java.util.Iterator"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="js/script.js"></script>
</head>
<link rel="stylesheet" href="style.css" type="text/css" />


<body>
<%@include file="Adminn.jsp" %>

<jsp:useBean id="empDao" class="com.inautix.Employee.EmployeeDao" scope="session"></jsp:useBean>
<%
String uname1=(String)session.getAttribute("uname");
	session.setAttribute("uname",uname1);
  


List<EmployeeBean> holdingList = empDao.viewEmp(uname1);
	Iterator<EmployeeBean> itr1 =  holdingList.iterator();
	out.print("<html><head><body><center><table border='2'><tr bgcolor=yellow><th>ADMIN_ID</th><th>EMP_ID</th><th>EMP_NAME</th><th>EMP_PWD</th><th>DESIGNATION</th><th>SALARY</th></tr>");
	while(itr1.hasNext()){
	EmployeeBean empBean = itr1.next();
	out.print("<tr bgcolor=pink><td>"+empBean.getAdmin_id()+"</td><td>"+empBean.getEmp_id()+"</td><td>"+empBean.getEmp_name()+"</td><td>"+empBean.getEmp_pwd()+"</td><td>"+empBean.getEmp_designation()+"</td><td>"+empBean.getSalary()+"</td></tr><tr>");
	}
	out.print("</tr></table></center></body></html>");

	%>
</body>
</html>