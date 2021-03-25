function validateUserForm(){
	var responseLabel = document.getElementById("responseLabel");
	var userEmail = document.getElementById("txtEmail").value;
	var userName = document.getElementById("txtUserName").value;
	var userBirthYear = document.getElementById("selBirthYear").value;
	
	if(userEmail == null || userEmail == "" || userName == null || userName == ""){
		responseLabel.innerHTML = "Enter information in all fields!";
		return false;	
	} else {
		return false;
	}
}