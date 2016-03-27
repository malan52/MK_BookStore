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
   	 xhttp.open("POST", "Login", true);
   	 xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
   	 xhttp.send("username=" + $("#login_username").val() +"&password=" + $("#login_password").val());
    }

function updateModal(bid, title, price){
		var xhttp = new XMLHttpRequest();
    	xhttp.onreadystatechange = function() {
			if (xhttp.readyState == 4) {
				$("#dm_img").attr("src", "image/book_cover/" + bid + ".jpg");
				$("#dm_title").text(title);
				$("#dm_price").text("$" + price + ".00");
				var reviews = responseText.split("\n");
				for(var i; i < reviews.length; i++){
					reviews[i].split(",");
				}
			}	
    	}
    	 xhttp.open("GET", "DetailModalCtrl?bid=" + bid, true);
       	 //xhttp.send("username=" + $("#login_username").val() +"&password=" + $("#login_password").val());
    	 xhttp.send();
}