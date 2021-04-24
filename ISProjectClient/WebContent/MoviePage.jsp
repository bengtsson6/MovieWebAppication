<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="isproject.ejb.Movie"%>
<%@ page import="isproject.ejb.MovieId"%>
<%@ page import="java.util.List"%>
<html>
<head>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Raleway:wght@100;200;300;400;500;600;700&display=swap" rel="stylesheet">
<script src="ValidationScripts.js">
	
</script>
<script src="ISProjectScripts.js"></script>
<link rel="stylesheet" type="text/css" href="styling.css">
<meta charset="ISO-8859-1">
<title>IsProjectVT21.MoviePage</title>
</head>
<body onload="sendTablesForm()">
	<%
		List<Movie> allMovies = (List<Movie>) request.getAttribute("allMovies");
		String success = (String) request.getAttribute("Success");
		String failure = (String) request.getAttribute("Failure");
	%>
	<%@ include file="Header.html"%>
	<section class="mainSection">
		<%@ include file="NavigationBar.html"%>
		<div class="rightside">
		<form action="/ISProjectClient/MainServlet" method="post"
			id="moviePage" onSubmit="return validateMovieForm();">
			<fieldset> 
			<legend>Enter Movie Information:</legend>
			<div id="MovieFS">
				<p>Fields marked with "*" is mandatory</p>
				<p>
					<label for="txtName">Title:*</label> <input type="text"
						id="txtName" name="txtName" class="txtInputEnterInformation">
					<label for="txtDirector">Director:</label> <input type="text"
						name="txtDirector" id="txtDirector"
						class="txtInputEnterInformation">
				</p>
				<p>
					<label for="selGenre">Genre</label> <select name="selGenre"
						id=selGenre>
						<option>Action</option>
						<option>Comedy</option>
						<option>Drama</option>
						<option>Fantasy</option>
						<option>Horror</option>
						<option>Musical</option>
						<option>Romance</option>
						<option>Sci-Fi</option>
						<option>Thriller</option>
						<option>War</option>
						<option>Western</option>
					</select> <label for="selStreamingService">Streaming Service</label> <select
						id="selStreamingService" name="selStreamingService">
						<option>None</option>
						<option>AppleTV</option>
						<option>C More</option>
						<option>Disney +</option>
						<option>Google Play</option>
						<option>HBO</option>
						<option>Hulu</option>
						<option>Netflix</option>
						<option>Paramount+</option>
						<option>Prime Video</option>
						<option>Quibi</option>
						<option>Viaplay</option>
					</select>
				</p>
				<p>
					<label for="selReleaseYear">Release Year: *</label> <select
						name="selReleaseYear" id="selReleaseYear">
						<%
							for (int i = 1895; i < 2022; i++) {
						%>
						<option><%=i%></option>
						<%
							}
						%>
					</select>
				</p>
				<input type="submit" name="btnSubmit" id="btnAddMoive"
					value="Add Movie"> <input type="submit" name="btnSubmit"
					id="btnUpdateMovie" value="Update Movie"><input type="submit" name="btnSubmit"
						id="btnDeleteMovie" value="Delete Movie">
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
			</div>
			<input name="operation" value="moviePage" type=hidden>
			</fieldset>
		</form>
		<br> <input type="text" id="searchField"
			onkeyup="filterTableFunction()" placeholder="Search by Title">
		<br>
		<%
			if (allMovies == null) {
		%>
		<form action="/ISProjectClient/MainServlet" method="post"
			id="loadAllMoviesForm" name="loadAllMoviesForm">
			<input name="operation" value="moviePageAllMovies" type=hidden>
		</form>
		<%
			} else {
		%>
		<table id="dataTable" class="dataTable">
			<caption>All Movies</caption>
			<tr id="tableHeader">
				<th>Title</th>
				<th>Release Year</th>
				<th>Director</th>
				<th> Genre </th>
				<th>Streaming Service</th>
				<th>Options
			</tr>
			<%
				for (Movie movie : allMovies) {
						String title = movie.getId().getMovieName();
						String releaseYear = movie.getId().getReleaseYear();
						String director = movie.getDirector();
						String genre = movie.getGenre();
						String streamingService = movie.getStreamingService();
			%>
			<tr>
				<td><%=title%></td>
				<td><%=releaseYear%></td>
				<td><%=director%></td>
				<td><%=genre%></td>
				<td><%=streamingService%></td>
				<td class="buttonCell">
					<button onclick="rowButtonClicked(this)" class="rowButton"
						name="addRating">Add rating</button>
					<button onclick="rowButtonClicked(this)" class="rowButton"
						name="showRating">Show reviews</button>
				</td>
			</tr>
			<%
				}
			%>
		</table>
		<%
			}
		%>
		<form action="/ISProjectClient/MainServlet" method="post"
			id="sendToRatingForm" name="sendToRatingForm">
			<input name="inputMovieTitle" id="inputMovieTitle" value=""
				type="hidden"> <input name="inputReleaseYear"
				id="inputReleaseYear" value="" type="hidden"> <input
				name="btnValue" id="btnValue" value="" type="hidden"> <input
				name="operation" value="moviePageToRating" type="hidden">
		</form>
		</div>
	</section>
	<%@ include file="Footer.html"%>
</body>
</html>