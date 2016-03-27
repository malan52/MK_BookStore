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

function updateModal(bid, title, price){
	$(document).ready(function(){
		$(document).on("click", "#" + bid + "toModal", function() {
			$("#dm_img").attr("src", "image/book_cover/" + bid + ".jpg");
			alert("image/book_cover/" + bid + ".jpg" + "  " + title + "    " + "$" + price + ".00");
			$("#dm_title").text(title);
			$("#dm_price").text("$" + price + ".00");
		});
	});
}