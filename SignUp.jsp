<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="js/script.js"></script>
<title>Signup Page</title>
<link rel="stylesheet" href="style.css" type="text/css" />
<style>

body{
background: url('signup.jpg');
background-repeat: no-repeat;
background-size:100%;
   -webkit-background-size: cover;
   -moz-background-size: cover;
   -o-background-size: cover;
     width: 80%;
                height: 100%;
                position: fixed;
                left: 0px;
                top: 0px;
                z-index: -99999;
                padding:10%;
        font-size: 100%;  
        color: white;   
}
</style>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script type="text/javascript">
var app=angular.module('myapp',[]);
app.controller('mycontroller',['$scope','$http',function mycontroller($scope,$http){
       
       $scope.cust_id=null;
       $scope.cust_name=null;
       $scope.cust_pwd=null;
       $scope.cust_repwd=null;
       $scope.cust_phno=null;
       $scope.cust_address=null;
       $scope.userdetails=function(id1,uname,pwd,cpwd,phno,addr)
       {
            
              var userdet={
            		  cust_id:id1,
            		  cust_name:uname,
            		  cust_pwd:pwd,
            		  cust_repwd:cpwd,
            		  cust_phno:phno,
            		  cust_address:addr
              };
              window.alert(JSON.stringify(userdet));
              
              $http.put('userdetails/insert', userdet).then(function(response) {
                     window.alert("Successful" );
              }, function(response) {
                     window.alert("Failed" );
              });
       };
       
}]);
</script>

<body data-ng-app="myapp" data-ng-controller="mycontroller">
 <a href="CusLogin.jsp">BACK..</a>
<form action=" "  onSubmit="return validateSignUp();" method="post">
<pre>
    <table align="center">
    <tr></tr>
       <tr><td>Enter ID:</td> <td> <input type="text" data-ng-model="id1" id="id1"></td></tr>
       <tr><td>Enter Name:</td> <td> <input type="text" data-ng-model="uname" id="uname"></td></tr>
       <tr><td>Enter password:</td> <td> <input type="password" data-ng-model="pwd" id="pwd"></td></tr>
       <tr><td>Enter Confirm password:</td> <td> <input type="password" data-ng-model="cpwd" id="cpwd"></td></tr>
       <tr><td>Enter PhoneNO:</td> <td> <input type="text" data-ng-model="phno" id="phno"></td></tr>
         <tr><td>Enter Address:</td> <td> <input type="text" data-ng-model="addr" id="addr"></td></tr>
          </table>
      <center><input type="submit" style="font-size: 12pt; height: 30px; width:100px;background-color: #e7e7e7; color: black;" id="SUBMIT" value="SUBMIT"  data-ng-click='userdetails(id1,uname,pwd,cpwd,phno,addr)'>
     </center>
       </pre>
  
    </form>
</body>
</html>