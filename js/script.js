/**
 * 
 */

function validate11()

{

	var x = document.getElementById('uname').value;

	var y = document.getElementById('psw').value;


	if(x.length>0)

	{
		if(y.length>0)

		{

			return true;

		}

		else

		{

			alert("Password is empty");

			return false;  

		}



	}

	else

	{

		alert("Admin id is empty");

		return false;  

	}



}


function validate12()

{

	var x = document.getElementById('uname').value;

	var y = document.getElementById('psw').value;


	if(x.length>0)

	{
		if(y.length>0)

		{

			return true;

		}

		else

		{

			alert("Password is empty");

			return false;  

		}



	}

	else

	{

		alert("user name is empty");

		return false;  

	}



}

function validate1()

{


	var id = document.getElementById('eid').value;
	var ename = document.getElementById('ename').value;

	var epwd = document.getElementById('epwd').value;
	var cpwd = document.getElementById('cpwd').value;
	var edesig = document.getElementById('edesig').value;
	var salary = document.getElementById('esal').value;


	if(id.length>0)
	{
		if(ename.length>0)
		{
			if(epwd.length>0)
			{

				if(cpwd.length>0 && cpwd==epwd)
				{
					if(edesig.length>0)

					{
						if(salary.match(/^\d+$/) && salary.length>0) 
						{
							return true;

						}
						else
						{
							alert("Enter valid salary");
							return false;
						}
					}
					else
					{
						alert("Enter the designation");
						return false;

					}
				}
				else
				{
					alert("Enter correct Password");
					return false;

				}

			}
			else
			{
				alert("Enter Password");
				return false;
			}
		}
		else
		{
			alert("Please Enter Employeename");
			return false;
		}
	}
	else
	{
		alert("Please Enter Employee ID");
		return false;
	}


}

function validate2()
{
	var x=document.getElementById('eid').value;
	if(x.length>0)
	{
		return true;
	}
	else
	{
		alert("Enter valid employee_id");
		return false;
	}
}
function validatePrice()
{


	var price=document.getElementById('price').value;
	if(price.length>0)
	{
		return true;
	}
	else
	{
		alert("Enter valid room_price");
		return false;
	}
}
function validateHotel()
{


	var hotel=document.getElementById('hotel').value;
	if(hotel.length>0)
	{
		return true;
	}
	else
	{
		alert("Enter the location properly!!");
		return false;
	}
}

function validateRoom()
{
	var x=document.getElementById('rid').value;
	if(x.length>0)
	{
		return true;
	}
	else
	{
		alert("Enter room_id");
		return false;
	}
}

function validate3()
{

	var rid = document.getElementById('rid').value;
	var indate = document.getElementById("indate").value; //for javascript
	var date = indate.substring(0, 2);
	var month = indate.substring(3, 5);
	var year = indate.substring(6, 10);
	var myDate = new Date(year, month - 1, date);
	var today = new Date();


	var outdate = document.getElementById('outdate').value;
	var datee = outdate.substring(0, 2);
	var monthh = outdate.substring(3, 5);
	var yearr = outdate.substring(6, 10);
	var myDatee = new Date(yearr, monthh - 1, datee);
	var todayy = new Date();


	var person = document.getElementById('person').value;

	if(rid.length>0)
	{

		if(indate.length>0 && indate.match(/^[0-3]?[0-9]\/[01]?[0-9]\/[12][90][0-9][0-9]$/) && myDate >= today)
		{
			if(outdate.length>0 && outdate.match(/^[0-3]?[0-9]\/[01]?[0-9]\/[12][90][0-9][0-9]$/) &&  myDatee >= todayy && myDatee>=myDate)

			{
				if(person.length>0 && person.match(/^\d+$/))
				{
					return true;
				}
				else
				{
					alert("Enter valid no of persons");
					return false;
				}

			}
			else
			{
				alert("Enter valid check_out date");
				return false;
			}
		}
		else
		{
			alert("Enter the valid check_in date");
			return false;

		}
	}             
	else
	{
		alert("Please Enter the room_id");
		return false;
	}


}

function validate4()
{
	var hname = document.getElementById("hname");
	var selecthotel=hname.options[hname.selectedIndex].value;



	if (selecthotel!= 0)
	{

		return true;
	}
	else
	{
		alert("Please select the hotel...");
		return false;
	}


}
function validateSignUp()
{
	var id1 = document.getElementById('id1').value;
	var uname = document.getElementById('uname').value;

	var pwd = document.getElementById('pwd').value;
	var cpwd = document.getElementById('cpwd').value;
	var phno = document.getElementById('phno').value;
	var addr = document.getElementById('addr').value;


	if(id1.length>0)
	{
		if(uname.length>0)
		{
			if(pwd.length>0)
			{

				if(cpwd.length>0 && cpwd==pwd)
				{
					if(phno.length>0 && phno.match(/^\d+$/) && phno.length==10)

					{
						if(addr.length>0)

						{
							alert("Signed in successfully....");
							return true;

						}
						else
						{
							alert("Enter valid address");
							return false;
						}
					}

					else
					{
						alert("Enter the valid phno");
						return false;

					}
				}
				else
				{
					alert("Enter correct Password");
					return false;

				}

			}
			else
			{
				alert("Enter Password");
				return false;
			}
		}
		else
		{
			alert("Please Enter name");
			return false;
		}
	}
	else
	{
		alert("Please Enter ID");
		return false;
	}


}
function validate34()
{
	var rid = document.getElementById('rid').value;



	if(rid.length>0)
	{
		return true;
	}
	else
	{
		alert("Please Enter the room_id");
		return false;
	}


}
function validate5()

{
	var hname = document.getElementById("hname");
	var selecthotel=hname.options[hname.selectedIndex].value;

	var x = document.getElementById('uname').value;

	var y = document.getElementById('psw').value;


	if (selecthotel!= 0)
	{

		if(x.length>0)

		{
			if(y.length>0)

			{

				return true;

			}

			else

			{

				alert("Password is empty");

				return false;  

			}



		}

		else

		{

			alert("Manager id is empty");

			return false;  

		}
	}
	else
	{
		alert("Please select the hotel...");
		return false;
	}


}
function validatepay()

{
	var pay = document.getElementsByName("pay");
	var card = document.getElementById("card").value;
	var secure = document.getElementById('secure').value;

	var namecard = document.getElementById('namecard').value;

	if ( ( pay[0].checked == true ) && ( pay[1].checked == false ) || ( pay[0].checked == false ) && ( pay[1].checked == true ))

	{
		if(card.length>0&& card.match(/^\d+$/) && card.length==16)
			{
		
			if(secure.length>0 && secure.match(/^\d+$/) && secure.length==6)

			{
				if(namecard.length>0)
				{
					return true;
				}
				else

				{

					alert("Invalid name in the card");

					return false;  

				}
			}

			else

			{

				alert("Invalid secure id");

				return false;  

			}
		
		
	}
		else

		{

			alert("Invalid card number");

			return false;  

		}
	}

	else
	{
		alert("Please select the card type...");
		return false;
	}
}
