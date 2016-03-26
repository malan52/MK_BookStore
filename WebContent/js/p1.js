//-----------------billing address-----------------------
var state=[
     ["Ontario","Quebec","Nova Scotia","New Brunswick","Manitoba","British Columbia","Prince Edward Island","Saskatchewan","Alberta","Newfoundland and Labrador" ],
     ["Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","Florida","Georgia","Hawaii","Idaho","Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota","Mississippi","Missouri","Montana","Nebraska","Nevada","Nevada","New Jersey","New Mexico","New York","North Carolina","North Dakota","Ohio,Oklahoma","Oregon","Pennsylvania","Rhode Island","South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Washington","Washington","Wisconsin","Wyoming","District of Columbia"],
     ];

     function getState(){
         
         var sltCountry=document.form1.country;        
         var sltState=document.form1.state;            
         var countryState=state[sltCountry.selectedIndex - 1];         
         sltState.length=1;         
         for(var i=0;i<countryState.length;i++){
             sltState[i+1]=new Option(countryState[i],countryState[i]);
         }
     }
     
//------------------shippinging address---------------------    

	var sstate=[
	           ["Ontario","Quebec","Nova Scotia","New Brunswick","Manitoba","British Columbia","Prince Edward Island","Saskatchewan","Alberta","Newfoundland and Labrador" ],
	           ["Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","Florida","Georgia","Hawaii","Idaho","Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota","Mississippi","Missouri","Montana","Nebraska","Nevada","Nevada","New Jersey","New Mexico","New York","North Carolina","North Dakota","Ohio,Oklahoma","Oregon","Pennsylvania","Rhode Island","South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Washington","Washington","Wisconsin","Wyoming","District of Columbia"],
	           ];

	function sgetState(){
	             
	               var sltCountry=document.form2.scountry;        
	               var sltState=document.form2.sstate;            
	               var countryState=sstate[sltCountry.selectedIndex - 1];         
	               sltState.length=1;         
	               for(var i=0;i<countryState.length;i++){
	                   sltState[i+1]=new Option(countryState[i],countryState[i]);
	               }
	           }
	

//-------------shipping addres is as the same as billing address----------

function sameadrs(){
	//the same first name
	var f = document.getElementById("fname").value;
	document.getElementById("sfname").value=f;
	//the same last name
	var l = document.getElementById("lname").value;
	document.getElementById("slname").value = l;	
	//the same address
	var a = document.getElementById("adrs").value;
	document.getElementById("sadrs").value=a;
	//the same phone number
	var p = document.getElementById("phone").value;
	document.getElementById("sphone").value=p;
	//the same email
	var e = document.getElementById("zip").value;
	document.getElementById("szip").value=e;	
	//the same contry
	var c = document.getElementById("country").value;
	document.getElementById("scountry").value=c;
	sgetState();	
	//the same state
	var s = document.getElementById("state").value;
	document.getElementById("sstate").value=s;	
	document.getElementById("sstate").options[document.getElementById("sstate").selectedIndex].text=document.getElementById("state").options[document.getElementById("state").selectedIndex].text
	
}

//--------if the client check the checkbox, change the status of the shipping address
	function change(){
		
		var pf = document.getElementById("pf");//first name for the tag out of the first name
		var pl = document.getElementById("pl");//last name
		var pc = document.getElementById("pc");//country
		var ps = document.getElementById("ps");//state
		var pa = document.getElementById("pa");//address
		var pp = document.getElementById("pp");//phone
		var pz = document.getElementById("pz");//email
		
		var sf = document.getElementById("fname").value;
		var sl = document.getElementById("lname").value;
		var sc = document.getElementById("country").value;
		var ss = document.getElementById("state").value;
		var sa = document.getElementById("adrs").value;
		var sp = document.getElementById("phone").value;
		var sz = document.getElementById("zip").value;
		
		if(document.getElementById("yes").checked == true){
			pf.innerHTML = "<input type=\"text\" class=\"form-control\" id=\"sfname\" name=\"sfname\" placeholder="+ sf +" style=\"margin: 10px 10px 10px 10px;\" disabled=\"disabled\"/>";
			pl.innerHTML = "<input type=\"text\" class=\"form-control\" id=\"slname\" name=\"slname\" placeholder="+ sl +" style=\"margin: 10px 10px 10px 10px;\" disabled=\"disabled\"/>";
			pp.innerHTML = "<input type=\"text\" class=\"form-control\" id=\"sphone\" name=\"phone\" style=\"margin: 10px 10px 10px 10px;\" disabled=\"disabled\" placeholder="+ sp +">";
			pc.innerHTML = "<select id=\"scountry\" name=\"scountry\" class=\"form-control\" onchange=\"sgetState()\" disabled=\"disabled\"><option value=\"0\">"+ sc + "</option></select>";
			ps.innerHTML = "<select id=\"sstate\" name=\"sstate\" class=\"form-control\" disabled=\"disabled\"><option value=\"0\">"+ss+"</option></select>";
			pa.innerHTML = "<textarea class=\"form-control\" rows=\"2\" id=\"sadrs\" name=\"adrs\" onclick=\"this.innerHTML=''\" disabled=\"disabled\"/>"+ sa;
			pz.innerHTML = "<input type=\"text\" class=\"form-control\" id=\"szip\" name=\"szip\" style=\"margin: 10px 10px 10px 10px;\" disabled=\"disabled\" placeholder="+ sz +">";
		
			
		} else {
			pf.innerHTML = "<input type=\"text\" class=\"form-control\" id=\"sfname\" name=\"sfname\" placeholder=\"Joe\" style=\"margin: 10px 10px 10px 10px;\"/>";
			pl.innerHTML = "<input type=\"text\" class=\"form-control\" id=\"slname\" name=\"slname\" placeholder=\"Doe\" style=\"margin: 10px 10px 10px 10px;\"/>";
			pp.innerHTML = "<input type=\"text\" class=\"form-control\" id=\"sphone\" name=\"phone\" placeholder=\"10 digits\" style=\"margin: 10px 10px 10px 10px;\" onblur=\"checkSPhone()\"/>";
			pc.innerHTML = "<select id=\"scountry\" name=\"scountry\" class=\"form-control\" onchange=\"sgetState()\"><option value=\"0\">Select country</option><option value=\"Canada\" >Canada</option><option value=\"USA\" >USA</option></select>";
			ps.innerHTML = "<select id=\"sstate\" name=\"sstate\" class=\"form-control\"><option value=\"0\">Select state</option></select>";
			pa.innerHTML = "<textarea class=\"form-control\" rows=\"2\" id=\"sadrs\" name=\"adrs\" onclick=\"this.innerHTML=''\"/>Please enter address</textarea>";
			pz.innerHTML = "<input type=\"text\" class=\"form-control\" id=\"szip\" name=\"szip\" placeholder=\"6 digits\" style=\"margin: 10px 10px 10px 10px;\" onblur=\"checkSZip()\"/>";
			//alert("shipping country:" + sc + "\n" + "shipping state:" + ss);
		}
	}
	
//check if the billing phone number is 10 digits
	function checkPhone(){
		//alert("this is a test");
		var reg = /^[0-9]{10,10}$/;
		var flag = reg.test(document.getElementById("phone").value);
		if(!flag){
			alert("Phone Number must be 10 digits!");
		}
	}
//check if the shipping phone number is 10digits
	function checkSPhone(){
		var reg = /^[0-9]{10,10}$/;
		var flag = reg.test(document.getElementById("sphone").value);
		if(!flag){
			alert("Phone Number must be 10 digits!");
		}
	}
//check if the zip code is 6 digits with letter	
	function checkZip(){
		var reg =  /^[a-zA-Z0-9]{6,6}$/;
		var flag = reg.test(document.getElementById("zip").value);
		if(!flag){
			alert("ZIP CODE must be 6 digits with numbers and letters!");
		}		
	}
//check if the shipping zip code is 6 digits with letter
	function checkSZip(){
		var reg =  /^[a-zA-Z0-9]{6,6}$/;
		var flag = reg.test(document.getElementById("szip").value);
		if(!flag){
			alert("ZIP CODE must be 6 digits with numbers and letters!");
		}		
	}
	
	//check if the cardholder is all letters
	function checkCardHolder(){			
		var reg = /^[a-zA-Z]+$/;
		var flag = reg.test(document.getElementById("cardHolder").value);
		if(!flag){
			alert("CardHolder must to be all letters!");
		}
	}

//check if the card number is digits
	function checkCardNumber(){
		var reg16 = /^[0-9]{16,16}$/;
		var reg15 = /^[0-9]{15,15}$/;		
		var type = document.getElementById("cardType");
		if(type.value=="1" || type.value=="2"){
			var flag16 = reg16.test(document.getElementById("cardNumber").value);
			if(!flag16 && type.value=="1"){
				alert("VISA Card Number must be 16 digits!");
			}
			else if(!flag16 && type.value=="2"){
				alert("MASTER Card Number must be 16 digits!");
			}
		}
		else{
			var flag15 = reg15.test(document.getElementById("cardNumber").value);
			if(!flag15 && type.value =="3"){
				alert("AMERICAN EXPRESS Card Number must be 15 digits!")
			}
		}
		
	}

//check if the cvc is all digits
	function checkCVC(){
		var reg3 = /^[0-9]{3,3}$/;
		var reg4 =/^[0-9]{4,4}$/;
		
		var type = document.getElementById("cardType"); 
		if(type.value == "1" || type.value == "2"){
			var digit3 = reg3.test(document.getElementById("cvc").value);
			if(!digit3){
				alert("cvc must be 3 digits!");
			}
		}
		else{
			var digit4 = reg3.test(document.getElementById("cvc").value);
			if(!digit4){
				alert("cvc must be 4 digits!")
			}
		}		
	}
	
	function checkAll(){
		//check the billling phone
		var regphone = /^[0-9]{10,10}$/;
		var flagphone = regphone.test(document.getElementById("phone").value);
		//shipping phone
		var regsphone = /^[0-9]{10,10}$/;
		var flagsphone = regsphone.test(document.getElementById("sphone").value);
		//billing zip code
		var regzip =  /^([a-zA-Z0-9]){6,6}$/;
		var flagzip = regzip.test(document.getElementById("zip").value);
		//shipping zip code
		var regszip =  /^([a-zA-Z0-9]){6,6}$/;
		var flagszip = regszip.test(document.getElementById("szip").value);
		//cardHolder
		var regholder = /^[a-zA-Z]+$/;
		var flagholder = regholder.test(document.getElementById("cardHolder").value);
		//card number
		var reg16 = /^[0-9]{16,16}$/;
		var reg15 = /^[0-9]{15,15}$/;		
		var type = document.getElementById("cardType");
		if(type.value=="1" || type.value=="2"){
			var flag16 = reg16.test(document.getElementById("cardNumber").value);
		}
		else{
			var flag15 = reg15.test(document.getElementById("cardNumber").value);
		}
		//check cvc
		var reg3 = /^[0-9]{3,3}$/;
		var reg4 =/^[0-9]{4,4}$/;
		if(type.value == "1" || type.value == "2"){
			var digit3 = reg3.test(document.getElementById("cvc").value);
		}
		else{
			var digit4 = reg3.test(document.getElementById("cvc").value);
		}	
		if(!flagphone||!flagsphone||!flagzip||!flagszip||!flagholder||(!flag16 && type.value=="1")||(!flag16 && type.value=="2")||(!flag15 && type.value =="3")||!digit3||!digit4){
			alert("please check the input information!");
		}		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	