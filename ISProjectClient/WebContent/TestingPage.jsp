<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css2?family=Raleway:wght@100;200;300;400;500;600;700&display=swap" rel="stylesheet">
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="styling.css">
<title>ISProject.Testing</title>
</head>
<body>
	<%@ include file="Header.html"%>
	<section class="mainSection">
		<%@ include file="NavigationBar.html"%>
		<div class="rightside">
		<form action="TestServlet" method="get" name="testMethodsForm">
			<fieldset id="TestingFS">
			<legend>Choose your test: </legend>
				<select name="suite"> 
					<option value="0" selected>Select a testing</option>
					<option value="isproject.junit.FacadeBeanTest">Facade Test</option>
				</select> <input type="submit" value="Run">
			</fieldset>
		</form>
		</div>
	</section>
	<div class="footerContainer"><%@ include file="Footer.html"%></div>
</body>
</html>