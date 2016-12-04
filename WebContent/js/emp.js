/**
 * 
 */
// Add operation on employee
$(document)
		.ready(
				function() {
					$(document).on(
							"click",
							"#submit",
							function(key) {
								var id = $('#Id').val();
								var name = $('#Name').val();
								var password = $('#password').val();
								var gender = $('#Gender').val();
								var mob = $('#Mobileno').val();
								var addr = $('#Address').val();
								var url = "/Library/lib?operation=empAdd&Id="
										+ id + "&Name=" + name + "&password="
										+ password + "&Gender=" + gender
										+ "&Mobileno=" + mob + "&Address="
										+ addr;
								$.ajax({
									url : url,
									type : 'POST'
								}).done(function(result) {
									result = JSON.parse(result);
									if (result.status == 1) {
										alert("SuccessFully Added");
										$('#Id').val("");
										$('#Name').val("");
										$('#password').val("");
										$('#Gender').val("");
										$('#Mobileno').val("");
										$('#Address').val("");
										displaybills();
									} else if (result.status == 0) {
										alert("Error occurs");
									}
								}).fail(function(result) {
									// console.log(result);
									alert("Please Check Details!..")
								});
							})
							// update employee details js...
					$(document)
							.on(
									"click",
									"#update",
									function() {
										var id = $('#Id').val();
										var name = $('#Name').val();
										var password = $('#password').val();
										var gender = $('#Gender').val();
										var mob = $('#Mobileno').val();
										var addr = $('#Address').val();
										if (id == "") {
											alert("Please Enter EmployeeId..");
											$("#Id").focus().css(
													"outline-color", "#ff0000");
											return;
										}
										if (name === "") {
											alert("Please Enter Your Name");
											$("#Name").focus().css(
													"outline-color", "#ff0000");
											return;
										}
										if (password === "") {
											alert("Please Enter Password..");
											$("#password").focus().css(
													"outline-color", "#ff0000");
											return;
										}
										if (gender === "") {
											alert("Please Enter Gender...");
											$("#Gender").focus().css(
													"outline-color", "ff0000");
											return;
										}
										if (mob === "") {
											alert("Please Enter Your MobileNo..");
											$("#Mobileno").focus().css(
													"outline-color", "ff0000");
											return;
										}
										if (addr === "") {
											alert("Please Enter Your Address..");
											$('#Address').focus().css(
													"outline-color", "ff0000");
											return;

										}

										var url = "/Library/lib?operation=empupdate&Id="
												+ id
												+ "&Name="
												+ name
												+ "&password="
												+ password
												+ "&Gender="
												+ gender
												+ ",&Mobileno="
												+ mob
												+ "&Address=" + addr;
										$.ajax({
											url : url,
											type : 'POST'
										}).done(function(result) {
											result = JSON.parse(result);
											if (result.status === 1) {
												alert("Updated SuccessFully");
												$('#Id').val("");
												$('#Name').val("");
												$('#password').val("");
												$('#Gender').val("");
												$('#Mobileno').val("");
												$('#Address').val("");
											} else {
												if (result.status === 0) {
													alert("Error occurs");
												}
											}
										}).fail(function(result) {
											console.log(result);
										});

									})
									$("#Id").click(function(){
										var name =$("#Name").val();
										var password=$("#password").val();
										var gender=$("#Gender").val();
									    var mobileno=$("#Mobileno").val();
									    var address=$("#Address").val();
										var url="http://localhost:8080/Library/lib?operation=getonly&Name="+name+"&password="+password+"&Gender="+gender+"&Mobileno="+mobileno+"&Address="+address;
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
					function getAlls(){
						var url="http://localhost:8080/Library/lib?operation=getAlls";
					$.ajax({
						url:url,
						type:'POST'
					})
					.done(function(result){
						var array=JSON.parse(result);

						var table="<table border='2px solid ' class='table'><tr><th>Id</th><th>Name</th><th>password</th><th>Gender</th><th>Mobileno</th><th>Address</th></tr>"

					    for(i=0;i<array.length;i++){
					    	table+="<tr>"
						 	    table+="<td>"+array[i].Id+"</td>"
						 		table+="<td>"+array[i].Name+"</td>"
						 		table+="<td>"+array[i].password+"</td>"
						 		table+="<td>"+array[i].Gender+"</td>"
						 		table+="<td>"+array[i].mobileno+"</td>"
						 		table+="<td>"+array[i].Address+"</td>"
						 		
						 		
						 		table+="</tr>";
						 	}
						table+="</table>";
						 	$(".getAll")[0].innerHTML=table;	

						 })
						 .fail(function(result){
						 	alert("error");
						 })
						 
					}

									
				})
