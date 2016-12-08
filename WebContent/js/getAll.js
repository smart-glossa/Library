/**
 * 
 */
	function getAllEmployee(){
						var url="http://localhost:8080/Library/lib?operation=getAlls";
					$.ajax({
						url:url,
						type:'POST'
					})
					.done(function(result){
						var array=JSON.parse(result);

						var table="<table border='2px  ' class='table'><tr><th>Id</th><th>Name</th><th>Gender</th><th>Mobileno</th><th>Address</th></tr>"

					    for(i=0;i<array.length;i++){
					    	table+="<tr>"
						 	    table+="<td>"+array[i].Id+"</td>"
						 		table+="<td>"+array[i].Name+"</td>"
						 		//table+="<td>"+array[i].password+"</td>"
						 		table+="<td>"+array[i].Gender+"</td>"
						 		table+="<td>"+array[i].MoblieNo+"</td>"
						 		table+="<td>"+array[i].Address+"</td>"
						 		
						 		
						 		table+="</tr>";
						 	}
						table+="</table>";
						 	$(".getAllemployee")[0].innerHTML=table;	

						 })
						 .fail(function(result){
						 	alert("error");
						 })
						 
					}

	function getAllstudent(){
		var url="/Library/lib?operation=getAll";
	$.ajax({
		url:url,
		type:'POST'
	})
	.done(function(result){
		var array=JSON.parse(result);
	    var table="<table border='1px solid ' class='table'><tr><th>StudentId</th><th>StudentName</th><th>Gender</th><th>Department</th><th>Year</th><th>ContactNo</th><th>Email</th><th>RegisterDate</th></tr>"

	     for(i=0;i<array.length;i++){
	     	table+="<tr>"
		 	    table+="<td>"+array[i].stdId+"</td>"
		 		table+="<td>"+array[i].name+"</td>"
		 		table+="<td>"+array[i].gender+"</td>"
		 		table+="<td>"+array[i].dep+"</td>"
		 		table+="<td>"+array[i].Year+"</td>"
		 		table+="<td>"+array[i].contact+"</td>"
		 		table+="<td>"+array[i].email+"</td>"
		 		table+="<td>"+array[i].rdate+"</td>"
		 		table+="</tr>";
		 	}
		table+="</table>";
		 	$(".getAllStudent")[0].innerHTML=table;	

		 })
		 .fail(function(result){
		 	alert("error");
		 })
		 
	}
	
	function getAllbooks(){
		var url="/Library/lib?operation=bookget";
	$.ajax({
		url:url,
		type:'POST'
	})
	.done(function(result){
		var array=JSON.parse(result);
	    var table="<table border='1px solid ' class='table'><tr><th>BookId</th><th>BookName</th><th>AuthorName</th><th>Category</th></tr>"

	     for(i=0;i<array.length;i++){
	     	table+="<tr>"
		 	    table+="<td>"+array[i].bookid+"</td>"
		 		table+="<td>"+array[i].bookname+"</td>"
		 		table+="<td>"+array[i].aname+"</td>"
		 		table+="<td>"+array[i].cat+"</td>"
		 		table+="</tr>";
		 	}
		table+="</table>";
		 	$(".getAllbook")[0].innerHTML=table;	

		 })
		 .fail(function(result){
		 	alert("error");
		 })
		 
	}  