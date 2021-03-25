<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<Style>
#selBirthYear {
	width: 132px;
}

fieldset {
	background-color: #968c8c;
}

body {
	background-color: #bdb7b7;
}

#col1row3 {
	padding-top: 10;
	padding-bottom: 10;
}
</Style>
<head>
<meta charset="ISO-8859-1">
<title>IsProjectVT21.UserPage</title>
</head>
<body>
	<form action="/ISProjectClient/MainSerlvet" method="post">
		<fieldset id="UserFS">
			<legend>Enter User Information:</legend>
			<p>
				<label for="txtEmail">User Email</label> 
				<input type="text"
					name="txtEmail" size=30 maxlength=35> 
				<label for="txtUserName">Full Name</label> 
				<input type="text"
					name="txtUserName" size=30 maxlength=35>
					</p>
					<p>
					<label for="selBirthYear">BirthYear</label>
				<select name="selBirthYear" id="selBirthYear">
						<%
							for (int i = 1930; i < 2020; i++) {
						%>
						<option><%=i%></option>
						<%
							}
						%>
				</select>
				</p>
				<input type="submit"
					name="btnSubmit" id="btnAddUser" value="Add User"> <input
					type="submit" name="btnSubmit" id="btnUpdateUser"
					value="Update User">
		</fieldset>
		<input name="operation" value="userPage" type=hidden>
	</form>
</body>
</html>