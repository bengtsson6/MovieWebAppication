<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css2?family=Raleway:wght@100;200;300;400;500;600;700&display=swap" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>IsProjectVT21.HomePage</title>
<link rel="stylesheet" type="text/css" href="styling.css">
</head>
<body>
<%@ include file="Header.html"%>
	<section class="mainSection">
		<%@ include file="NavigationBar.html"%>
		<section class="textSection">
			<div class="textContainer">
				<h1 id="titleHomePage">Welcome!</h1>
				<p id =txtHomePage> Welcome to the Movie Center. Here you will be able to add users and movies to our database. 
				You will also be able to add ratings to movies to show if you love or hate them. 
				To the right you will also see the location of your device and the weather, temperature, and time of sunrise and sunset in your location. 
				If you have any questions, concerns, or general ideas on how we can improve this service don't hesitate to contact us. 
				For further information and contact details, please click on "About".
				</p>
			</div>
		</section>
		<div class="WeatherContainer"> 
		<%@ include file="Weather.html"%>
		</div>
		</section>
		<div class="footerContainer"><%@ include file="Footer.html"%></div>
</body>
</html>