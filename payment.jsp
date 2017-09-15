<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="js/script.js"></script>
</head>
<body>
<%@include file="Customerr.jsp" %>

	<center>
		<form action=" " onSubmit="return validatepay();" method="post">

			<marquee>
				<h1 style="font-family: Algerian;">
					<font color="#808080" ,size="500%"> Card Details!!!!!!</font>
				</h1>
			</marquee>
			<table>
			<tr><td>Card Type: <input type="radio" name="pay" id="visa" value="Cash on Delivery">Credit card
			 <input type="radio" name="pay" id="mastercard" value="Net Banking">Debit card </td></tr>
		 		<tr><td>Card Number: <input id=card name=card type=text ></td></tr>
			<tr><td>  Security Code:<input id=secure name=secure type=text >(*Only 6 digits)</td></tr>
			<tr><td> Name on Card<input id=namecard name=namecard type=text placeholder="Exact namne as on the card" ></td></tr>
			
			</table>
			<input type="submit" name="submit" style="font-size: 12pt; height: 50px; width:120px;background-color: #e7e7e7; color: black;" value="BOOK" id="book" onCLick="form.action='paySuccess.jsp'"/>

		</form>
	</center>
</body>
</html>