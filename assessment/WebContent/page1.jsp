<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String str=(String)request.getAttribute("Message");
if(str!=null)
{
out.println(str);
}
%>
<h2><b>POST A TOPIC</b></h1>

        <div class="pg1">

                <form action="Topicservlet" method="post" onSubmit="form.action">

                        <table>

                                <tr>
                                  <td>Topic</td>

                                        <td><input type="text" name="tpname" /></td>

                                </tr>

                                <tr></tr>

                                <tr></tr>

                        </table>

                        <input type="submit" value="Post a Topic" />
                        <br><br>
                        <a href="index.html">back</a>

                </form>

        </div>
</body>
</html>