
$(document).ready(function(){

	$(document).on("click","#returns",function(key){
		var id=$('#sid').val();
		var empid=$('#rempid').val();
		
		
		if(id=="")
		{
		alert("Please Enter your BookId");
		$("#sid").focus().css("outline-color", "#ff0000");
		return;
		}
		if(empid=="")
		{
		alert("Please Enter your BookName");
		$("#rempid").focus().css("outline-color", "#ff0000");
		return;
		}
		var url= "/Library/lib?operation=addreturn&sid="+ id + "&rempid=" + empid ;
        $.ajax({
        	url:url,
        	type:'POST'

        })
        
        .done(function(result) {
			result = JSON.parse(result);
		   if (result.status == 1) {
		  alert("SuccessFully Added");
		  $('#sid').val("");
		$('#rempid').val("");
					
	} else if (result.status == 0) {
	alert("Error occurs");
}
}).fail(function(result) {
	alert("Please Check Details!..")
	});
});
	$(document).on('click','#rett',function(){
		var stud = $('#sutid').val();
			var url = "/Library/lib?operation=getret&sutid="+ stud;
			$.ajax({
				url:url,
				type:'POST'
			})
			.done(function(result){
				res = JSON.parse(result);
		    	  var table = '<table>'
		    		  table += '<tr><th>BorrowDate</th><th>ReturnDate</th><th>BorrowEmployeeId</th><th>ReturnEmployeeId</th></tr>';
		    	   
		    	    	  table += '<tr class="row">'
		    	    	  table += '<td>'+res.bdate +'</td>';
		    	    	  table += '<td >'+ res.rdate +'</td>';
		    	    	  table += '<td>'+ res.rempid +'</td>';
		    	    	  table += '<td>'+ res.bempid +'</td>';
		    	    
		                  table += '</table>';  
		                  $('.getStatement')[0].innerHTML = table;
			})
	});
});

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
		retVar += "			<input type=text id=\"sid\" placeholder=\"StudentId..\">";
		retVar += "		<\/div>";
		retVar += "			&nbsp;&nbsp;";
		retVar += "		<div>";
		retVar += "			<label>EmployeeId*:<\/label>";
		retVar += "		<\/div>";
		retVar += "			&nbsp;&nbsp;";
		retVar += "		<div>";
		retVar += "			<input type=text id=\"rempid\" placeholder=\"EmployeeId..\">";
		retVar += "		<\/div>";
		retVar += "			&nbsp;&nbsp;&nbsp;";
		retVar += "		<div>";
		//retVar += "			<input type=submit value=\"Add\" id=\"add\">";
		retVar += "			<button id=\"returns\" >Submit</button>";
		retVar += "			&nbsp;";
		//retVar += "			<input type=submit value=\"Update\" id=\"updateCus\">";
		retVar += "			<button id=\"returnget\">GetAll</button>";
		retVar += "		<\/div>";
		retVar += "";
		
		retVar += "	<\/div>";
		retVar += "	</center>";
	$('.ret')[0].innerHTML = retVar;
	}
	
	