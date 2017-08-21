function topic_validate()
{
	var key=document.getElementById('tpname').value;
	var x=/^[a-zA-Z0-9]+$/;
	if(key.length>0&&x.match(!key))
		{
		return true;
		}
	else
		{
		alert("The field should not be empty and no special characters");
		return false;
		}
	
	}
function comment_validate()
{
	var key=document.getElementById('tpname').value;
	var x=/^[a-zA-Z0-9]+$/;
	if(key.length>0)
		{
		return true;
		}
	else
		{
		alert("The comment should not be empty ");
		return false;
		}
	
	
}