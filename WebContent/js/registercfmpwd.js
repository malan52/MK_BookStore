//check if the confirm password is as the same as the previous password
function confirmPWD(){
		var pwd = document.getElementById("pwd").value;
		var cfmpws = document.getElementById("cfmpws").value;
		if(pwd != cfmpws)
			alert("Password is not the same!"); 
		return flag;
	}
//check  if the password has minimun 6 character with just letter and number,by a paramter
function checkPWD(){
		var reg = /([a-zA-Z0-9]){6,}$/;
		var flag = reg.test(document.getElementById("pwd").value);
		if(!flag){
			alert("Minimum of 6 characters with only letters or/and number")
		}
		return flag;
}