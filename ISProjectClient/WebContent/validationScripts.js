function validateUserForm(){
	var responseLabel = document.getElementById("responseLabel");
	var userEmail = document.getElementById("txtEmail");
	var userName = document.getElementById("txtUserName");
	
	var emailValue = userEmail.value;
	var nameValue = userName.value;
	
	if( emailValue == null || emailValue == "" || nameValue == null || nameValue == "") { 
		responseLabel.innerHTML = "Enter information in all fields!";
		return false;	
	} 
	else {
		return true;
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
	else {
		return true;
	}
	
	
}