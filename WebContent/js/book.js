$(document).ready(function(){
	getAllbooks();
	$(document).on("click","#submit",function(key){
		var id=$('#bookid').val();
		var name=$('#bookname').val();
		var author=$('#aname').val();
		var cat=$('#cat').val();
		var url= "/Library/lib?operation=bookadd&bookid="+ id + "&bookname=" + name + "&aname="+author + "&cat=" + cat;
        $.ajax({
        	url:url,
        	type:'POST'

        })
        
        .done(function(result) {
			result = JSON.parse(result);
		if (result.status == 1) {
		alert("SuccessFully Added");
		$('#bookid').val("");
		$('#bookname').val("");
		$('#aname').val("");
		$('#cat').val("");
		getAllbooks();
					
	} else if (result.status == 0) {
	alert("Error occurs");
}
}).fail(function(result) {
	alert("Please Check Details!..")
	})
});



	$(document).on("click","#update",function() {
		var id = $('#bookid').val();
		var name = $('#bookname').val();
		var author= $('#aname').val();
		var cat = $('#cat').val();
	   
																									
		if (id == "") {
		alert("Please Enter BookId..");
		$("#bookid").focus().css(
		"outline-color", "#ff0000");
	    return;
	   }
	   if (name === "") {
	   alert("Please Enter BookName");
	   $("#bookname").focus().css(
	   "outline-color", "#ff0000");
		return;
	   }
	   if (author === "") {
	   alert("Please Enter Gender..");
	   $("#aname").focus().css(
	   "outline-color", "#ff0000");
	    return;
	   }
		if (cat === "") {
										
	   alert("Please Enter Department...");
	   $("#cat").focus().css(
	   "outline-color", "ff0000");
		return;
		}  
		var url = "/Library/lib?operation=bookupdate&bookid="+ id+ "&bookname="+ name+ "&aname="+ author+ "&cat=" +cat;								
		$.ajax({
		url : url,
		type : 'POST'
		}).done(function(result) {
		result = JSON.parse(result);
		if (result.status === 1) {
		alert("Updated SuccessFully");
		$('#bookid').val("");
		$('#bookname').val("");
	    $('#aname').val("");
		$('#cat').val("");
	    
	    } else {
		if (result.status === 0) {
		alert("Error occurs");
	   }
		}
	}).fail(function(result) {
	console.log(result);
})
});

$("#bookid").click(function(){
	var bid =$("#bookid").val();
	var url="/Library/lib?operation=bookone&bookid="+bid;
	$.ajax({
		url:url,
		type:'post'
			})
		
	.done(function(result){
		alert(result);
	
	})
	.fail(function(result){
		
		alert("error:"+result);	
})
})
});

/* book return and borrow */
$(document).ready(function(){
	$(document).on("click","#borrow",function(key){
		var studid=$('#sid').val();
		var sname=$('#name').val();
		var bid=$('#bid').val();
		var cat=$('#cat').val();
		var bdate=$('#bdate').val();
		//http://localhost:8080/Library/lib?operation=addborrow&sid=1&name=sathish&bid=1999&cat=tamil&bdate=10/19/1212
		var url= "/Library/lib?operation=addborrow&sid="+ studid + "&name=" + sname + "&bid="+bid + "&cat=" + cat+"&bdate="+bdate;
        $.ajax({
        	url:url,
        	type:'POST'

        })
        
        .done(function(result) {
			result = JSON.parse(result);
		   if (result.status == 1) {
		   alert("SuccessFully Added");
		   $('#sid').val("");
		  $('#name').val("");
		$('#bid').val("");
		$('#cat').val("");
		$('#bdate').val("");
					
	} else if (result.status == 0) {
	alert("Error occurs");
}
}).fail(function(result) {
	alert("Please Check Details!..")
	})
});
$(document).on("keyup", "#sid", function() {
	var sid =$("#sid").val();
	var bid=$('#bid').val();
	//http://localhost:8080/Library/lib?operation=getvalue&sid=1&bid=1
	var url="/Library/lib?operation=getvalue&sid="+sid+"&bid="+bid;
	$.ajax({
		url:url,
		type:"POST"
			})
		
	.done(function(result){
		 result = JSON.parse(result);
         var Name = result.name;
         var cat=result.cat;
         $("#name").val(Name);
         $("#cat").val(cat);
	})
	.fail(function(result) {
        alert("Some Errors Please Enter correct value");
    })
})
$(document).on("click","#return",function() {
	var id = $('#studid').val();
	var bdate = $('#bdate').val();
	var rdate= $('#rdate').val();																								
	if (id == "") {
	alert("Please Enter StudentId..");
	$("#studid").focus().css(
	"outline-color", "#ff0000");
    return;
   }
   if (bdate === "") {
   alert("Please Enter BorrowDate..");
   $("#bdate").focus().css(
   "outline-color", "#ff0000");
	return;
   }
   if (rdate === "") {
   alert("Please Enter ReturnDate..");
   $("#rdate").focus().css(
   "outline-color", "#ff0000");
    return;
   }//http://localhost:8080/Library/lib?operation=rupdate&studid=1&bdate=10/19/1212&rdate=12/10/2010
	var url = "/Library/lib?operation=rupdate&studid="+ id+ "&bdate="+ bdate+ "&rdate="+ rdate;								
	$.ajax({
	url : url,
	type : 'POST'
	}).done(function(result) {
	result = JSON.parse(result);
	if (result.status === 1) {
	alert("Updated SuccessFully");
	$('#studid').val("");
	$('#name').val("");
	$('#bookid').val("");
    $('#bdate').val("");
	$('#cat').val("");
	$('#rdate').val();
    
    } else {
	if (result.status === 0) {
	alert("Error occurs");
   }
	}
}).fail(function(result) {
console.log(result);
})
});
});
