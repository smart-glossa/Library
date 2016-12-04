/**
 * 
 */
$(document).ready(function(){
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
					
	} else if (result.status == 0) {
	alert("Error occurs");
}
}).fail(function(result) {
	alert("Please Check Details!..")
	});
})



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
})

$("#bookid").click(function(){
	var name =$("#bookname").val();
	var bauthor=$("#aname").val();
	var bcat=$("#cat").val();
	var url="http://localhost:8080/Library/lib?operation=bookone&bookname="+name+"&aname="+bauthor+"&cat="+bcat;
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
	function bookget(){
		var url="http://localhost:8080/Library/lib?operation=bookget";
	$.ajax({
		url:url,
		type:'POST'
	})
	.done(function(result){
		var array=JSON.parse(result);

		var table="<table border='2px solid ' class='table'><tr><th>bookid</th><th>bookname</th><th>authorname</th><th>cat</th></tr>"

	    for(i=0;i<array.length;i++){
	    	table+="<tr>"
		 	    table+="<td>"+array[i].bookid+"</td>"
		 		table+="<td>"+array[i].bookname+"</td>"
		 		table+="<td>"+array[i].authorname+"</td>"
		 		table+="<td>"+array[i].cat+"</td>"
		 		
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