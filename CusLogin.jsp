<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css" type="text/css" />

</head>
<script src="js/script.js"></script>
<style>

body{
background: url('login (1).jpg');
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
        font-size: 150%;  
        color: black;   
}
</style>
<body>
<br><br><a href="Menu.html">BACK</a>
<center>
<form id="LOGIN" action=" "  onSubmit="return validate12();"  method="post">
  <div class="container">
  <br><br><br><br><br><br>
    <label><b>Username</b></label>
    <input type="text" style="font-size: 12pt; height: 25px; width:200px;" placeholder="Enter Username" id="uname" name="uname"><br><br>
    <label><b>Password</b></label>
    <input type="password"  style="font-size: 12pt; height: 25px; width:200px;"  placeholder="Enter Password" id="psw" name="psw" ><br><br>
    <input type="submit"  style="font-size: 12pt; height: 30px; width:100px;background-color: #e7e7e7; color: black;" id="LOGIN" value="LOGIN"  onclick="form.action='CustomerServlet'"><br><br>
    <a href="SignUp.jsp">Register New User</a>   
 </div>
</form>
</center>
</body>

</html>