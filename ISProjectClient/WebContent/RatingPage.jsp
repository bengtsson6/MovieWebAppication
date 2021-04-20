<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="java.util.ArrayList"%>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="validationScripts.js"></script>
<script src="ISProjectScripts.js"></script>
<link rel="stylesheet" type="text/css" href="styling.css">
<title>IsProjectVT21.RatingPage</title>
</head>
<body>
	<%
		String success = (String) request.getAttribute("Success");
		String failure = (String) request.getAttribute("Failure");
		String movieTitle = (String) request.getAttribute("title");
		String releaseYear = (String) request.getAttribute("releaseYear");
		ArrayList<String> allEmails = (ArrayList<String>) request.getAttribute("allEmails");
	%>
	<%@ include file="Header.html"%>
	<section class="mainSection">
		<%@ include file="navigationBar.html"%>
		<%@ include file="Weather.html"%>
		<form action="/ISProjectClient/MainServlet" method="post"
			id="addRatingForm" onSubmit="return validateRatingForm();">
			<fieldset id="RatingFS">
				<h2>
					Add your rating to
					<%=movieTitle%></h2>
				<%
					if (movieTitle != null && releaseYear != null) {
				%>
				<p>
					If you want to register a user <a href="UserPage.jsp">click
						here</a>
				</p>
				<label for="selEmail">User Email: </label> <select name="selEmail"
					id="selEmail">
					<%
						for (String email : allEmails) {
					%>
					<option><%=email%></option>
					<%
						}
					%>
				</select>
				<%
					} else {
				%>
				<p>
					If you want to register a new user <a href="UserPage.jsp">click
						here</a>
				</p>
				<label for="selEmail">User Email: </label> <select name="selEmail"
					id="selEmail"></select>
				<%
					}
				%>
				<br> <br> <label for="selRating">Rating: </label> <select
					name="selRating" id="selRating">
					<%
						for (int i = 1; i < 11; i++) {
					%>
					<option><%=i%></option>
					<%
						}
					%>
				</select> <br> <br>
				<div>
					<label for="textAreaReview">Review: </label>
					<textarea id="textAreaReview" name="textAreaReview" rows="4"
						cols="50"></textarea>
				</div>
				<br> <br> <input type="submit" name="btnSubmit"
					id="btnAddRating" value="Add Rating">
				<button onclick="window.location.href = 'MoviePage.jsp'"
					type="button">Back to Movies</button>
				<%
					if (success != null) {
				%>
				<p id=responseLabel class="thick-font">
					<b><%=success%></b>
				</p>
				<%
					} else if (failure != null) {
				%>
				<p id=responseLabel class="thick-font">
					<b><%=failure%></b>
				</p>
				<%
					} else {
				%>
				<p id=responseLabel class="thick-font"></p>
				<%
					}
				%>
			</fieldset>
			<input name=txtTitle value="<%=movieTitle%>" type=hidden> <input
				name=txtReleaseYear value="<%=releaseYear%>" type=hidden> <input
				name="operation" value="ratingPage" type=hidden>
		</form>
		<%@ include file="Footer.html"%>
	</section>
</body>
</html>