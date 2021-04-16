$(document).ready(function() {
	$("#findBtn").click( function() {
		var emailValue = $("#txtEmail").val();
		if (emailValue != "") {
			$.ajax({
				method: "GET",
				url: "http://localhost:8080/ISProjectRestClient/UserRestServlet/"+emailValue,
				error: ajaxFindReturnError,
				success: ajaxFindResturnSuccess
			})
			function ajaxFindResturnSuccess(result, status, xhr){
				parseJsonFileUser(result);
			}
			function ajaxFindReturnError(result, status, xhr){
				alert("Error");
			}
		}
	})//End of addBtnClick Function
	$("#deleteBtn").click( function() {
		var emailValue = $("#txtEmail").val();
		if (emailValue != ""){
			$.ajax({
				method: "DELETE",
				url: "http://localhost:8080/ISProjectRestClient/UserRestServlet/"+emailValue,
				error: ajaxDelReturnError,
				success: ajaxDelReturnSuccess
			})
			function ajaxDelReturnSuccess(result, status, xhr) {
				clearFields();
				$("#responseLabel").html("Movie Deleted");
			}
			function ajaxDelReturnError(result, status, xhr){
				$("#responseLabel").html("Error occured");
			}
		}
	})
	
	$("#clearBtn").click( function() {
		clearFields();
	})//Clear fields button click event
})//End of document ready function

function parseJsonFileUser(result){
	$("#txtEmail").val(result.email);
	$("#txtName").val(result.name);
	$("#txtBirthYear").val(result.birthyear);
}

function clearFields(){
	$("#txtEmail").val("");
	$("#txtName").val("");
	$("#txtBirthYear").val("");
}