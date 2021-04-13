<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>IsProjectVT21.HomePage</title>
<link rel="stylesheet" type="text/css" href="styling.css">
</head>
<body>
<%@ include file="Header.html"%>
	<section class="mainSection">
		<%@ include file="navigationBar.html"%>
		<%@ include file="Weather.html" %>
		<section class="textSection">
		<h1 id="titleHomePage">Welcome!</h1>
		<p id =txtHomePage> Welcome to the movie center. Here you will be able to add users and movies to our database. 
		You will also be able to add ratings to movies to show if you love or hate them. 
		To the right you will also see the location of your device and the weather, temperature, and time of sunrise and sunset in your location. 
		If you have any questions, concerns, or general ideas on how we can improve this service don't hesitate to contact us. 
		Our details are at the bottom of the page.
		</p>
		</section>
		</section>
</body>
</html>