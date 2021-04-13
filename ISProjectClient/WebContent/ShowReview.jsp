<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="isproject.ejb.Rating"%>
<%@ page import="java.util.ArrayList"%>
<html>
<head>
<script src="validationScripts.js">	
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
	%>
	<%@ include file="Header.html"%>
	<section class="mainSection">
		<%@ include file="navigationBar.html"%>
		<%@ include file="Weather.html" %>
		<table id = "dataTable" class="dataTable">
			<caption>All Ratings for <%=title%> <%=year%></caption>
			<tr>
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
		</section>
</body>
</html>