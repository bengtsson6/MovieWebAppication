<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="isproject.ejb.UserProfile"%>
<%@ page import="java.util.List"%>
<html>
<head>
<script src="validationScripts.js"></script>
<script src="ISProjectScripts.js"></script>
<link rel="stylesheet" type="text/css" href="styling.css">
<meta charset="ISO-8859-1">
<title>IsProjectVT21.UserPage</title>
</head>
<body onload = "sendUserTableForm();">
	<%
		String success = (String) request.getAttribute("Success");
		List<UserProfile> allUsers = (List<UserProfile>) request.getAttribute("allUsers");
	%>
	<%@ include file="Header.html"%>
	<section id="main">
		<%@ include file="navigationBar.html"%>
		<form action="/ISProjectClient/MainServlet" method="post"
			id="userForm" onSubmit="return validateUserForm();">
			<fieldset id="UserFS">
				<legend>Enter User Information:</legend>
				<p>
					<label for="txtEmail">User Email</label> <input type="text"
						name="txtEmail" id="txtEmail" size=30 maxlength=35> <label
						for="txtUserName">Full Name</label> <input type="text"
						name="txtUserName" id="txtUserName" size=30 maxlength=35>
				</p>
				<p>
					<label for="selBirthYear">BirthYear</label> <select
						name="selBirthYear" id="selBirthYear">
						<%
							for (int i = 1930; i < 2020; i++) {
						%>
						<option><%=i%></option>
						<%
							}
						%>
					</select>
				</p>
				<p>
					<input type="submit" name="btnSubmit" id="btnAddUser"
						value="Add User"><input type="submit" name="btnSubmit"
						id="btnUpdateUser" value="Update User">
				</p>
				<%
					if (success != null) {
				%>
				<p id=responseLabel class="thick-font">
					<b><%=success%></b>
				</p>
				<%
					} else {
				%>
				<p id=responseLabel class="thick-font"></p>
				<%
					}
				%>

			</fieldset>
			<input name="operation" value="userPage" type=hidden>
		</form>
	</section>
	<br>
	<section id="tableSection">
		<%
			if (allUsers == null) {
		%>
		<form action="/ISProjectClient/MainServlet" method="post"
			id="loadAllUsersForm" name= "loadAllUsersForm" onload = "sendUserTableForm()" >
			<input name="operation" value="userPageAllUsers" type=hidden>
			</form>
			<%
				} else {
			%>
			<table class="presentDataTable">
				<tr>
					<th>Email</th>
					<th>Name</th>
					<th>Birth Year</th>
				</tr>
				<%
					for (UserProfile user : allUsers) {
							String userEmail = user.getEmail();
							String userName = user.getUserName();
							String userBirthYear = user.getBirthYear();
				%>
				<tr>
					<td><%=userEmail%></td>
					<td><%=userName%></td>
					<td><%=userBirthYear%></td>
				</tr>
				<%
					}
				%>

			</table>
			<%
				}
			%>
	</section>
</body>
</html>