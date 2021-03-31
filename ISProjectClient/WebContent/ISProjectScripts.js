function sendTablesForm(){
	var allUsersForm = document.getElementById("loadAllUsersForm");
	var allMoviesForm = document.getElementById("loadAllMoviesForm");
	if (allUsersForm != null){
		allUsersForm.submit();
	}
	if (allMoviesForm != null){
		allMoviesForm.submit();
	}
}