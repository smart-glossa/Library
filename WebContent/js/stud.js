/**
 * 
 */
$(document).ready(function(){
	  getAllstudent();
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
		getAllstudent();					
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
	});
	$(document).on("keyup", "#sId", function() {
		var sid =$("#sId").val();
		var url="/Library/lib?operation=getone&sId="+sid;
		$.ajax({
			url:url,
			type:'post'
				})
			
		.done(function(result){
			 result = JSON.parse(result);
             var Name = result.name;
             var gender=result.gender;
             var dep=result.dep;
             var year=result.year;
             var contact=result.contact;
             var email=result.email;
             var rdate=result.rdate;
             $("#Name").val(Name);
             $("#Gender").val(gender);
             $("#dep").val(dep);
             $("#Year").val(year);
             $("#Contact").val(contact);
             $("#Email").val(email);
             $("#rdate").val(rdate);
         })
		
		})
		.fail(function(result){
			
			alert("error:"+result);	
	})
	});