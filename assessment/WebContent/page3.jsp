<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.sql.*, java.util.*,java.io.*,com.inautix.connectionmanager.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String lastcomment=(String)request.getAttribute("lastcomment"); %>
	<h2>
		<b>VIEW THE LATEST COMMENT</b>
		</h1>

		<div class="pg5">

			<form action="commentServlet" method="Get">

				<table>

					<tr>

						<td>Topic<select name="topics">

								<%
									Connection conn = ConnectionManager.DBConnection();
									PreparedStatement stmt = null;

									int rs = 0;
									ResultSet rs1 = null;

									String searchquery = "select * from topic_xbbnhhc";
									try {
										stmt = conn.prepareStatement(searchquery);

										rs1 = stmt.executeQuery();
										while (rs1.next()) {
								%>

								<option value="<%=rs1.getString("topic_desc")%>"><%=rs1.getString("topic_desc")%></option>
								<%
									}
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								%>
						</select>

						</td>
					</tr>
					<tr>


						<td>LatestComment</td>

						<td><input type="text" name="lc" value="<%if(lastcomment!=null){out.println(lastcomment);} %>" /></td>

					</tr>

					<tr></tr>

					<tr></tr>

				</table>

				<input type="submit" value="view Comment" />

			</form>
<br>
                        <a href="index.html">back</a>

		</div>
</body>
</html>