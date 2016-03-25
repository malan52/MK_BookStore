//check if the confirm password is as the same as the previous password
function confirmPWD(previous, current){
		var pwd = document.getElementById("previous").value;
		var cfmpws = document.getElementById("current").value;
		if(previous != current)
			alert("Password is not the same!"); 
		return flag;
	}
//check  if the password has minimun 6 character with just letter and number,by a paramter
function checkPWD(pwd){
		var reg = /([a-zA-Z0-9]){6,}$/;
		var flag = reg.test(document.getElementById("pwd").value);
		if(!flag){
			alert("Minimum of 6 characters with only letters or/and number")
		}
		return flag;
}