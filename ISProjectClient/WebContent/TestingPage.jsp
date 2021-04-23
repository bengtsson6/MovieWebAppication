<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="styling.css">
<title>ISProject.Testing</title>
</head>
<body>
	<%@ include file="Header.html"%>
	<section class="mainSection">
		<%@ include file="NavigationBar.html"%>
		<form action="TestServlet" method="get" name="testMethodsForm">
			<fieldset>
			<legend>Choose your test: </legend>
				<select name="suite"> 
					<option value="0" selected>Select a testing</option>
					<option value="isproject.junit.FacadeBeanTest">Facade Test</option>
				</select> <input type="submit" value="Run">
			</fieldset>
		</form>
	</section>
	<%@ include file="Footer.html"%><
</body>
</html>