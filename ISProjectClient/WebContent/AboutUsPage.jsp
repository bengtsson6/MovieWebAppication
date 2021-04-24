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
		<div> 
			<h1 id="titleHomePage">About Us</h1>
			<p id=txtHomePage>
				Welcome to Movie Center, your number one source for all things
				related to movies. We're dedicated to giving you the very best of
				the movie database, with a focus on users, movies, and ratings. <br>
				<br>Founded in 2020 by Programmeringsprinsarna, Movie Center
				has come a long way from its beginnings. When we first started out,
				our passion for a innovative movie database drove us to do a ton of
				research so that Movie Center can offer you the safest, most
				reliable and fastest movie database in the world. We now serve
				customers all over the world and are thrilled that we're able to
				turn our passion into our own website. <br>
				<br>We hope you enjoy this website as much as we enjoy offering
				them to you. If you have any questions or comments, please don't
				hesitate to contact us. <br> <br> Sincerely,<br>
				Programmeringsprinsarna
			</p>
			<h3 class="contactTitle">Contact</h3>
			<p> Email:
			<a href="mailto:info@programmeringsprinsarna.com">info@programmeringsprinsarna.com</a> 
			<br>
			Address: Tycho Brahes väg 1, 223 63 Lund
			<br>
			Phone: 0709195046
			</p>
			</div>
		</section>
	</section>
	<div class="footerContainer"><%@ include file="Footer.html"%></div>
</body>
</html>