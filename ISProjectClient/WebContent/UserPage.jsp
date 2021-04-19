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
<body onload="sendTablesForm();">
	<%
		String success = (String) request.getAttribute("Success");
		List<UserProfile> allUsers = (List<UserProfile>) request.getAttribute("allUsers");
	%>
	<%@ include file="Header.html"%>
	<section class="mainSection">
		<%@ include file="navigationBar.html"%>
		<%@ include file="Weather.html" %>
		<form action="/ISProjectClient/MainServlet" method="post"
			id="userForm" onSubmit="return validateUserForm();">
			<fieldset id="UserFS">
				<legend>Enter User Information:</legend>
				<p>Fields marked with "*" is mandatory</p>
				<p>
					<label for="txtEmail">User Email: *</label> <input type="text"
						name="txtEmail" id="txtEmail" class="txtInputEnterInformation">
					<label for="txtUserName">Full Name: *</label> <input type="text"
						name="txtUserName" id="txtUserName"
						class="txtInputEnterInformation">
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
		<br> <input type="text" id="searchField"
			onkeyup="filterTableFunction()" placeholder="Search by Email">
		<br>
		<%
			if (allUsers == null) {
		%>
		<form action="/ISProjectClient/MainServlet" method="post"
			id="loadAllUsersForm" name="loadAllUsersForm">
			<input name="operation" value="userPageAllUsers" type=hidden>
		</form>
		<%
			} else {
		%>
		<table id="dataTable" class="dataTable">
			<caption>All Users</caption>
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
			<%@ include file="Footer.html"%>
	</section>
</body>
</html>