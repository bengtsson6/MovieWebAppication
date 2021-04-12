function intitialize() {
	sendTablesForm();
	sendRowToRatingForm();
}

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

function sendRowToRatingForm() {
	var table = document.getElementById("dataTable");
	if (table != null) {
		var rows = table.getElementsByTagName("tr");
		for (var i = 1; i < rows.length; i++) {
			table.getElementsByTagName("tr")[i].onclick = funtion()
			{
				window.alert("HEJ");
				var cellTitle = this.getElementsByTag("td")[0];
				var cellTitleContent = cellTitle.innerHTML;
				window.alert(cellTitleContent);
			}
			;
		}
	}
}

function rowClicked(row) {
	var tdTitle = row.getElementsByTagName("td")[0];
	var tdYear = row.getElementsByTagName("td")[1];
	var title = tdTitle.innerText;
	var year = tdYear.innerText;
	document.getElementById("inputMovieTitle").value = title;
	document.getElementById("inputReleaseYear").value = year;
}