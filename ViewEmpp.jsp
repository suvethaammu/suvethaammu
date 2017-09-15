<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<head>
<style>
table, th , td  {
  border: 2px solid grey;
  border-collapse: collapse;
  padding: 5px;
}
table tr:nth-child(odd) {
  background-color: #f1f1f1;
}
table tr:nth-child(even) {
  background-color: #ffffff;
}
</style>
</head>
<body>
<%@include file="Adminn.jsp" %>
<%  String uname66=session.getAttribute("uname").toString();
	session.setAttribute("uname",uname66);
	
	%>
<div ng-app="myApp" ng-controller="employeeCtrl"> 
<center>
Manager Detail
<table >
<tr bgcolor=yellow>

<td>ADMIN_ID</td><td>EMP_ID</td><td> EMP_NAME </td><td>EMP_PWD</td><td>DESIGNATION</td><td> SALARY
 </td></tr> <tr ng-repeat="x in Employee " bgcolor=pink>
   
    <td>{{ x.admin_id }}</td>
    <td>{{x.emp_id}}</td>
     <td>{{ x.emp_name}}</td>
    <td>{{ x.emp_pwd}}</td>
     <td>{{ x.emp_designation}}</td>
    <td>{{ x.salary}}</td>
    
  
  </tr>
</table>
</center> 
</div>
<script>
var app = angular.module('myApp', []);
app.controller('employeeCtrl', function($scope, $http) {
    $http.get("http://localhost:8080/HotelRoom/userdetails/all/<%=session.getAttribute("uname")%>")
    .then(function (response) {$scope.Employee= response.data;});
});
</script>
</body>
</html>
