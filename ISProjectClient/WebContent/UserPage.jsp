<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<Style>
#selBirthYear {
	width: 132px;
}

table {
	background-color: #968c8c;
}

body {
	background-color: #bdb7b7;
}
</Style>
<head>
<meta charset="ISO-8859-1">
<title>IsProjectVT21.UserPage</title>
</head>
<body>
	<form action="/ISProjectClient/MainSerlvet" method="post">
		<table align="left">
			<tr>
				<td><label for="txtEmail">User Email</label></td>
				<td><input type="text" name="txtEmail" size=30 maxlength=35></td>
				<td><label for="txtUserName">Full Name</label></td>
				<td><input type="text" name="txtUserName" size=30 maxlength=35>
				</td>
			</tr>
			<tr>
				<td><label for="selBirthYear">BirthYear</label>
				<td><select name="selBirthYear" id="selBirthYear">
						<%
							for (int i = 1930; i < 2020; i++) {
						%>
						<option><%=i%></option>
						<%
							}
						%>
				</select></td>
			</tr>
			<tr>
				<td><input type="submit" name="btnSubmit" id="btnAddUser"
					value="Add User"></td>
				<td><input type="submit" name="btnSubmit"
					id="btnUpdateUser" value="Update User"></td>
			</tr>
		</table>
		<input name="operation" value="userPage" type=hidden>
	</form>
</body>
</html>