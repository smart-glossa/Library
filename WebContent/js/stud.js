/**
 * 
 */
$(document).ready(function(){
	$(document).on("click","#submit",function(key){
		var id=$('#sId').val();
		var name=$('#Name').val();
		var gender=$('#Gender').val();
		var dept=$('#dep').val();
		var year=$('#Year').val();
		var contact=$('#Contact').val();
		var email=$('#Email').val();
		var date=$('#rdate').val();
		var url= "/Library/lib?operation=add&sId="+ id + "&Name=" + name + "&Gender="+ gender+ "&dep=" + dept+ "&Year=" + year + "&Contact="+ contact+ "&Email="+email+ "&rdate="+date;

        $.ajax({
        	url:url,
        	type:'POST'

        })
        
        .done(function(result) {
			result = JSON.parse(result);
		   if (result.status == 1) {
		   alert("SuccessFully Added");
		  $('#sId').val("");
		$('#Name').val("");
		$('#Gender').val("");
		$('#dep').val("");
		$('#Year').val("");
	    $('#Contact').val("");
	    $('#Email').val("");
	    $('#rdate').val("");
										
	} else if (result.status == 0) {
	alert("Error occurs");
}
}).fail(function(result) {
	alert("Please Check Details!..")
	});
})



	$(document).on("click","#update",function() {
		var id = $('#sId').val();
		var name = $('#Name').val();
		var gender = $('#Gender').val();
		var dept = $('#dep').val();
		var year = $('#Year').val();
	   var contact = $('#Contact').val();
	   var email = $('#Email').val();
	   var date = $('#rdate').val();
	   
																									
		if (id == "") {
		alert("Please Enter StudentId..");
		$("#sId").focus().css(
		"outline-color", "#ff0000");
	    return;
	   }
	   if (name === "") {
	   alert("Please Enter Your Name");
	   $("#Name").focus().css(
	   "outline-color", "#ff0000");
		return;
	   }
	   if (gender === "") {
	   alert("Please Enter Gender..");
	   $("#Gender").focus().css(
	   "outline-color", "#ff0000");
	    return;
	   }
		if (dept === "") {
										
	   alert("Please Enter Department...");
	   $("#dep").focus().css(
	   "outline-color", "ff0000");
		return;
		}
		if (year === "") {
		alert("Please Enter Your Year..");
		$("#Year").focus().css(
		"outline-color", "ff0000");
		return;
		}
		if (contact === "") {
		alert("Please Enter Your contactno..");
		$('#Contact').focus().css(
		"outline-color", "ff0000");
		return;
	    }
	    if (email === "") {
		alert("Please Enter Your EmailId..");
		$('#Email').focus().css(
		"outline-color", "ff0000");
		return;
	    }

        if (date === "") {
		alert("Please Enter Your RegistrationDate..");
		$('#rdate').focus().css(
		"outline-color", "ff0000");
		return;
	    }
        var url = "/Library/lib?operation=stdupdate&sId="+ id+ "&Name="+ name+ "&Gender="+ gender+ "&dep=" +dept + "&Year="  +year+ "&Contact=" + contact+ "&Email=" +email+ "&rdate="+date;
												
		$.ajax({
		url : url,
		type : 'POST'
		}).done(function(result) {
		result = JSON.parse(result);
		if (result.status === 1) {
		alert("Updated SuccessFully");
		$('#sId').val("");
		$('#Name').val("");
	    $('#Gender').val("");
		$('#dep').val("");
	    $('#Year').val("");
	    $('#Contact').val("");
	    $('#Email').val("");
	    $('#rdate').val("");

	    } else {
		if (result.status === 0) {
		alert("Error occurs");
	   }
		}
	}).fail(function(result) {
	console.log(result);
})
	})
	$("#sId").click(function(){
		var name =$("#Name").val();
		var gender=$("#Gender").val();
		var dept=$("#dep").val();
		var year=$("#Year").val();
		var contact=$("#Contact").val();
		var email=$("#Email").val();
		var date =$("#rdate").val();
		var url="http://localhost:8080/Library/lib?operation=getone&Name="+name+"&Gender="+gender+"&dep="+dept+"&Year="+year+"&Contact="+contact+"&Email="+email+"&rdate="+date;
		$.ajax({
			url:url,
			type:'post'})
			
		.done(function(result){
			alert(result);
		
		})
		.fail(function(result){
			
			alert("error:"+result);	
	})
	});
	function getAll(){
		var url="http://localhost:8080/Library/lib?operation=getAll";
	$.ajax({
		url:url,
		type:'POST'
	})
	.done(function(result){
		var array=JSON.parse(result);
	    var table="<table border='2px solid ' class='table'><tr><th>sid</th><th>Name</th><th>gender</th><th>dep</th><th>year</th><th>contact</th><th>email</th><th>rdate</th></tr>"

	     for(i=0;i<array.length;i++){
	     	table+="<tr>"
		 	    table+="<td>"+array[i].sId+"</td>"
		 		table+="<td>"+array[i].Name+"</td>"
		 		table+="<td>"+array[i].Gender+"</td>"
		 		table+="<td>"+array[i].dep+"</td>"
		 		table+="<td>"+array[i].Year+"</td>"
		 		table+="<td>"+array[i].Contact+"</td>"
		 		table+="<td>"+array[i].Email+"</td>"
		 		table+="<td>"+array[i].rdate+"</td>"
		 		
		 		table+="</tr>";
		 	}
		table+="</table>";
		 	$(".getAll")[0].innerHTML=table;	

		 })
		 .fail(function(result){
		 	alert("error");
		 })
		 
	}
});