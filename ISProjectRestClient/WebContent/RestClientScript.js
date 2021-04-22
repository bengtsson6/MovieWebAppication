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
				$("#responseLabel").html("");
			}
			function ajaxFindReturnError(result, status, xhr){
				$("#responseLabel").html("Error occured");
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
				$("#responseLabel").html("User Deleted");
			}
			function ajaxDelReturnError(result, status, xhr){
				$("#responseLabel").html("Error occured");
			}
		}
	})//End of deleteButton function	
	$("#addBtn").click ( function () {
		var emailValue = $("#txtEmail").val();
		var userNameValue = $("#txtName").val();
		var userBirthYearValue = $("#txtBirthYear").val();		
		var obj = {email : emailValue, name: userNameValue, birthyear: userBirthYearValue};
		var jsonString = JSON.stringify(obj);	
		if (emailValue != ""){
			$.ajax({
				method: "POST",
				url: "http://localhost:8080/ISProjectRestClient/UserRestServlet/",
				data: jsonString,
				dataType: 'json',
				error: ajaxDelReturnError,
				success: ajaxDelReturnSuccess
			})
			function ajaxDelReturnSuccess(result, status, xhr) {
				clearFields();
				$("#responseLabel").html("User Added");
			}
			function ajaxDelReturnError(result, status, xhr){
				$("#responseLabel").html("Error occured");
			}	
		}
	})//End of addbtn function
		$("#updateBtn").click ( function () {
		var emailValue = $("#txtEmail").val();
		var userNameValue = $("#txtName").val();
		var userBirthYearValue = $("#txtBirthYear").val();
		
		var obj = {email : emailValue, name: userNameValue, birthyear: userBirthYearValue};
		var jsonString = JSON.stringify(obj);
		
		if (emailValue != ""){
			$.ajax({
				method: "PUT",
				url: "http://localhost:8080/ISProjectRestClient/UserRestServlet/" + emailValue,
				data: jsonString,
				dataType: 'json',
				error: ajaxDelReturnError,
				success: ajaxDelReturnSuccess
			})
			function ajaxDelReturnSuccess(result, status, xhr) {
				clearFields();
				$("#responseLabel").html("User Updated");
			}
			function ajaxDelReturnError(result, status, xhr){
				$("#responseLabel").html("Error occured");
			}	
		}
	})//End of update btn function
		$("#findAllBtn").click ( function(){

			$.ajax({
				method: "GET",
				url: "http://localhost:8080/ISProjectRestClient/UserRestServlet/",
				error: ajaxFindAllReturnError,
				success: ajaxFindAllReturnSuccess
			})
			function ajaxFindAllReturnSuccess(result, status, xhr) {
				var allUsers = ""; 
				for(var i = 0; i < result.length; i++){
					allUsers += " {" + result[i].email + ", " + result[i].name + ", " + result[i].birthyear +"}, " + "<br>";
				}
				$("#allUsers").html(allUsers);
			}
			function ajaxFindAllReturnError(result, status, xhr){
				alert("error");
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