function sendTablesForm() {
	var allUsersForm = document.getElementById("loadAllUsersForm");
	var allMoviesForm = document.getElementById("loadAllMoviesForm");
	if (allUsersForm != null) {
		allUsersForm.submit();
	}
	if (allMoviesForm != null) {
		allMoviesForm.submit();
	}
}

function filterTableFunction() {
	var input = document.getElementById("searchField");
	var table = document.getElementById("dataTable");
	if (input != null || table != null) {
		var filterText = input.value.toUpperCase();
		var tableRows = table.getElementsByTagName("tr");
		for (var i = 0; i < tableRows.length; i++) {
			var td = tableRows[i].getElementsByTagName("td")[0];
			if (td) {
				var txtValue = td.innerText.toUpperCase();
				var index = txtValue.indexOf(filterText);
				if (index > -1) {
					tableRows[i].style.display = "";
				} else {
					tableRows[i].style.display = "none";
				}
			}
		}
	}
}