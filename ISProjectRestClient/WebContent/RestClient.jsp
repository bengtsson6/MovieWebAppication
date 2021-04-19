<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="RestClientStyle.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="RestClientScript.js"></script>
<title>User Client</title>
</head>
<body>
	<header>
		<h1>User Rest Client</h1>
	</header>
	<section id="mainSection">
		<fieldset id = "mainFieldSet">
		<legend>User Information:</legend>
		<p>User Email is mandatory
		</p>
		<label for = "txtEmail"> User Email: *</label><input type = "text" id = txtEmail name = "txtEmail">	
		<label for = "txtName"> Name: </label><input type = "text" id = txtName name = "txtName">
		<br><br>
		<label for = "txtBirthYear"> BirthYear: </label><input type = "text" id = txtBirthYear name = "txtBirthYear">
		<br><br>
		<button class = "actionBtn" id = "clearBtn" value = "clear">Clear Fields</button>
		<br><br>
		<button class = "actionBtn" id = "addBtn" value = "AddUser">AddUser</button>
		<button class = "actionBtn" id = "findBtn" value = "Find User">Find User</button>
		<button class = "actionBtn" id = "deleteBtn" value = "Delete User">Delete User</button>
		<button class = "actionBtn" id = "updateBtn" value = "Update User">Update User</button>
		<button class = "actionBtn" id = "findAllBtn" value = "Find All Users">Find All Users</button>
		<p id = "responseLabel"></p>
		</fieldset>
		<p id = "allUsers"></p>
	</section>
</body>
</html>