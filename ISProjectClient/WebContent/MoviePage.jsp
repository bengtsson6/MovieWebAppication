<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script src="validationScripts.js">
	
</script>
<link rel="stylesheet" type="text/css" href="styling.css">
<meta charset="ISO-8859-1">
<title>IsProjectVT21.MoviePage</title>
</head>
<body>
	<%@ include file="Header.html"%>
	<section id="main">
		<%@ include file="navigationBar.html"%>
		<form action="/ISProjectClient/MainSerlvet" method="post"
			id="moviePage" onSubmit="return validateMovieForm();">
			<fieldset id="MovieFS">
				<legend>Enter Movie Information:</legend>
				<p>
					<label for="txtName">Name</label> <input type="text" id="txtName"
						name="txtName" size=30 maxlength=35> <label
						for="txtDirector">Director</label> <input type="text"
						name="txtDirector" size=30 maxlength=35> <label
						for="txtGenre">Genre</label> <input type="text" name="txtGenre"
						size=30 maxlength=35> <label for="txtStreamingService">Streaming
						Service</label> <input type="text" name="txtStreamingService" size=30
						maxlength=35>
				</p>
				<p>
					<label for="selReleaseYear">Release Year</label> <select
						name="selReleaseYear" id="selReleaseYear">
						<%
							for (int i = 1930; i < 2022; i++) {
						%>
						<option><%=i%></option>
						<%
							}
						%>
					</select>
				</p>
				<input type="submit" name="btnSubmit" id="btnAddMoive"
					value="Add Movie"> <input type="submit" name="btnSubmit"
					id="btnUpdateMovie" value="Update Movie">
				<p>
					<label id="responseLabel"></label>
				</p>
			</fieldset>
			<input name="operation" value="moviePage" type=hidden>
		</form>
	</section>
</body>
</html>