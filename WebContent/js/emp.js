
// Add operation on employee
$(document).ready(function() {
					getAllEmployee();
					$(document).on("click","#submit",function(key) {
								var id = $('#Id').val();
								var name = $('#Name').val();
								var password = $('#password').val();
								var gender = $('#Gender').val();
								var mob = $('#Mobileno').val();
								var addr = $('#Address').val();
								if(id==""){
									alert("please Enter id");
									return;
								}
								if(name=="")
									{
									alert("please Enter your name");
									return;
									}
								if(password=="")
								{
								alert("please Enter your password");
								return;
								}
								if(gender=="")
								{
								alert("please Enter gender");
								return;
								}
								if(mob=="")
								{
								alert("please Enter your mobileno");
								return;
								}
								if(addr=="")
								{
								alert("please Enter your Address");
								return;
								}
							
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
									   getAllEmployee();
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

									});
		$(document).on("keyup", "#Id", function() {
        var id = $('#Id').val();
        if (id != "") {//http://localhost:8080/Library/lib?operation=getonly&Id=1
            var getUrl = "/Library/lib?operation=getonly&Id=" + id;
            $.ajax({
                    url: getUrl,
                    type: "POST"
                })
                .done(function(result) {
                    result = JSON.parse(result);
                    var Name = result.Name;
                    var password=result.password;
                    var Gender=result.Gender;
                    var mobileno=result.MoblieNo;
                    var addr=result.addr;
                    $("#Name").val(Name);
                    $("#Password").val(0);
                    $("#Gender").val(Gender);
                    $("#Mobileno").val(mobileno);
                    $("#Address").val(addr);
                    
                })
                .fail(function(result) {
                    alert("Some Errors Please Enter correct value");
                });
        } else {
            $("#Name").val("");
            $("#Gender").val("");
            $("#Mobileno").val("");
            $("#Address").val("");
        }
});
$("#Name").on("keypress", function(event) {
    var englishAlphabetAndWhiteSpace = /[A-Za-z ]/g;
   
    var key = String.fromCharCode(event.which);
    // just refer key code
    //alert(event.keyCode);
    // keyCode == 8  is backspace
    // keyCode == 37 is left arrow
    // keyCode == 39 is right arrow
    // englishAlphabetAndWhiteSpace.test(key) does the matching, that is, test the key just typed against the regex pattern
    if (event.keyCode == 8 || event.keyCode == 37 || event.keyCode == 39 || englishAlphabetAndWhiteSpace.test(key)) {
        return true;
    }

    // If we got this far, just return false because a disallowed key was typed.
    $("#errmsg").html("Please Only Letters").show().fadeOut(4000);
    return false;
});

$('#Name').on("paste",function(e)
{
    e.preventDefault();
});

				
									
				});
