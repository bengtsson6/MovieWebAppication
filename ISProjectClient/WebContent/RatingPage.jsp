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
		String movieTitle = (String) request.getAttribute("title");
		String releaseYear = (String) request.getAttribute("releaseYear");
		ArrayList<String> allEmails = (ArrayList<String>) request.getAttribute("allEmails");
	%>
	<%@ include file="Header.html"%>
	<section class="mainSection">
		<%@ include file="navigationBar.html"%>
		<form action="/ISProjectClient/MainServlet" method="post"
			id="addRatingForm" onSubmit="return validateRatingForm();">
			<fieldset id="RatingFS">
				<legend>Enter Information:</legend>
				<%
					if (movieTitle != null && releaseYear != null) {
				%>
				 <label for="txtTitle">Title: </label> <input
					type="text" name="txtTitle" id="txtTitle" value="<%=movieTitle%>"
					class="txtInputEnterInformation"> <label
					for="txtReleaseYear">Release Year: </label> <input type="text"
					name="txtReleaseYear" id="txtReleaseYear"
					class="txtInputEnterInformation" value="<%=releaseYear%>">
					<br>
					<p>If you want to register a user <a href = "UserPage.jsp">click here</a> </p>
				<label for="selEmail">User Email: </label> <select name="selEmail"
					id="selEmail">
					<%for(String email: allEmails) { %>
					<option><%=email%></option>
					<%}%>
					</select>
				<%
					} else {
				%>
				 <label for="txtTitle">Title</label> <input
					type="text" name="txtTitle" id="txtTitle"
					class="txtInputEnterInformation"> <label
					for="txtReleaseYear">Release Year: </label> <input type="text"
					name="txtReleaseYear" id="txtReleaseYear"
					class="txtInputEnterInformation">
					<br>
					<p>If you want to register a user <a href = "UserPage.jsp">click here</a> </p>
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
				<br> <br> 
					<input type="submit" name="btnSubmit"
					id="btnAddRating" value="Add Rating"><input type="submit"
					name="btnSubmit" id="btnViewRating" value="View Ratings">
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
			<input name="operation" value="ratingPage" type=hidden>
		</form>
	</section>
</body>
</html>