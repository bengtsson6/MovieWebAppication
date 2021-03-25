<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>IsProjectVT21.MoviePage</title>
</head>
<body>
<form action="/ISProjectClient/MainSerlvet" method="post">
		<table align="left">
			<tr>
				<td><label for="txtName">Movie Name</label></td>
				<td><input type="text" name="txtName" size=30 maxlength=35></td>
				<td><label for="txtDirector">Director</label></td>
				<td><input type="text" name="txtDirector" size=30 maxlength=35>
				<td><label for="txtGenre">Genre</label></td>
				<td><input type="text" name="txtGenre" size=30 maxlength=35>
				<td><label for="txtStreamingService">Streaming Service</label></td>
				<td><input type="text" name="txtStreamingService" size=30 maxlength=35>
				</td>
			</tr>
			<tr>
				<td><label for="selReleaseYear">Release Year</label>
				<td><select name="selReleaseYear" id="selReleaseYear">
						<%
							for (int i = 1930; i < 2022; i++) {
						%>
						<option><%=i%></option>
						<%
							}
						%>
				</select></td>
			</tr>
			<tr>
				<td><input type="submit" name="btnSubmit" id="btnAddMovie"
					value="Add Movie"></td>
				<td><input type="submit" name="btnSubmit"
					id="btnUpdateMovie" value="Update Movie"></td>
				<td><input type="submit" name="btnSubmit"
					id="btnDeleteMovie" value="Delete Movie"></td>
			</tr>
		</table>
		<input name="operation" value="moviePage" type=hidden>
	</form>
</body>
</html>