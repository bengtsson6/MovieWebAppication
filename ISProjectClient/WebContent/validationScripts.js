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
		responseLabel.innerHTML = "Please enter Movie Name."
			return false;
	} 	
}