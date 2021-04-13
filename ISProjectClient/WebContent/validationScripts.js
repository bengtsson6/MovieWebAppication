function validateUserForm(){
	var responseLabel = document.getElementById("responseLabel");
	var userEmail = document.getElementById("txtEmail");
	var emailValue = userEmail.value;
	var userName = document.getElementById("txtUserName");
	var nameValue = userName.value;
	
	if (emailValue == null || emailValue == "") { 
		responseLabel.innerHTML = "Enter information in all fields!";
		return false;	
	} 

	if (nameValue = null || nameValue == ""){
		responseLabel.innerHTML = "Enter information in all fields!";
		return false;	
	}
}

function validateMovieForm() {
	var responseLabel = document.getElementById("responseLabel");
	var movieNameElement = document.getElementById("txtName");
	
	var movieName = movieNameElement.value;
	
	if (movieName == null || movieName == "") {
		responseLabel.innerHTML = "Please enter Movie Name.";
			return false;
	} 	
}

function validateRatingForm(){
	var responseLabel = document.getElementById("responseLabel");
	var movieTitleElement = document.getElementById("txtTitle");
	var releaseYearElement = document.getElementById("txtReleaseYear");
	var userEmailElement = document.getElementById("selEmail")
	var title = movieTitleElement.value;
	var releaseYear = releaseYearElement.value;
	var userEmail = userEmailElement.value;
	
	if(title == null || title == "" || releaseYear == null || releaseYear == "" || userEmail == null || userEmail == "") {
		responseLabel.innerHTML = "Please enter the mandatory fields";
		return false;
	}
}