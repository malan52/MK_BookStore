/**
 * 	For login.japx only.
 */

function varifyLogin(){
    	var xhttp = new XMLHttpRequest();
    	xhttp.onreadystatechange = function() {
			if (xhttp.readyState == 4) {
				alert(xhttp.responseText);
			}
	    		  
	    }
   	 xhttp.open("POST", "LoginAndRegister", true);
   	 xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
   	 xhttp.send("username=" + $("#login_username").val() +"&password=" + $("#login_password").val());
    }
