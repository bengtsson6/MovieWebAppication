<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="isproject.ejb.Rating"%>
<%@ page import="java.util.ArrayList"%>
<html>
<head>
<link href="https://fonts.googleapis.com/css2?family=Raleway:wght@100;200;300;400;500;600;700&display=swap" rel="stylesheet">
<script src="ValidationScripts.js">	
</script>
<script src="ISProjectScripts.js"></script>
<link rel="stylesheet" type="text/css" href="styling.css">
<meta charset="ISO-8859-1">
<title>IsProjectVT21.ShowReview</title>
</head>
<body>
	<% 
	ArrayList<Rating> allRatings = (ArrayList<Rating>)request.getAttribute("allRatings");
	String title = (String)request.getAttribute("title");
	String year = (String)request.getAttribute("year");
	String avgRating = (String) request.getAttribute("avgRating");
	%>
	<%@ include file="Header.html"%>
	<section class="mainSection">
		<%@ include file="NavigationBar.html"%>
		<div class="rightside"> 
		<br> <input type="text" id="searchField"
			onkeyup="filterTableFunction()" placeholder="Search by User Email">
		<br>
    	<table id = "dataTableReview" class = "dataTable">
			<caption>All Ratings for <%=title%>, Average Rating: <%=avgRating%></caption>
			<tr id= "tableHeader">
				<th>User email</th>
				<th>Rating</th>
				<th>Review</th>
			</tr>
			<%
				for (Rating rating : allRatings) {
						String userEmail = rating.getId().getEmail();
						String ratingGrade = Integer.toString(rating.getRatingGrade());
						String review = rating.getReview();
			%>
			<tr>
				<td><%=userEmail%></td>
				<td><%=ratingGrade%></td>
				<td><%=review%></td>
			</tr>
			<%
				}
			%>
		</table>
		</div>
		</section>
		<div class="footerContainer"><%@ include file="Footer.html"%></div>
</body>
</html>