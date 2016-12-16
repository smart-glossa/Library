/**
 * 
 */

	function returns(){
		var retVar="";
		retVar += "		<center>";
		retVar += "<div class=\"cus\">";
		retVar += "";
		retVar += "		<div>";
		retVar += "			<h2>Return Book<\/h2>";
		retVar += "		<\/div>";
		retVar += "		<div>";
		retVar += "			<label>StudentId*:<\/label>";
		retVar += "		<\/div>";
		retVar += "			&nbsp;&nbsp;&nbsp;";
		retVar += "		<div>";
		retVar += "			<input type=text id=\"addr\" placeholder=\"StudentId..\">";
		retVar += "		<\/div>";
		retVar += "			&nbsp;&nbsp;";
		retVar += "		<div>";
		retVar += "			<label>EmployeeId*:<\/label>";
		retVar += "		<\/div>";
		retVar += "			&nbsp;&nbsp;";
		retVar += "		<div>";
		retVar += "			<input type=text id=\"conno\" placeholder=\"EmployeeId..\" maxlength=\"10\">";
		retVar += "		<\/div>";
		retVar += "			&nbsp;&nbsp;&nbsp;";
		retVar += "		<div>";
		//retVar += "			<input type=submit value=\"Add\" id=\"add\">";
		retVar += "			<button class=\"sub\" >Submit</button>";
		retVar += "			&nbsp;";
		//retVar += "			<input type=submit value=\"Update\" id=\"updateCus\">";
		retVar += "			<button>Reset</button>";
		retVar += "		<\/div>";
		retVar += "";
		
		retVar += "	<\/div>";
		retVar += "	</center>";
	$('.ret')[0].innerHTML = retVar;
	}