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
	var e = document.getElementById("email").value;
	document.getElementById("semail").value=e;	
	//the same contry
	var c = document.getElementById("country").value;
	document.getElementById("scountry").value=c;
	sgetState();	
	//the same state
	var s = document.getElementById("state").value;
	document.getElementById("sstate").value=s;	
	document.getElementById("sstate").options[document.getElementById("sstate").selectedIndex].text=document.getElementById("state").options[document.getElementById("state").selectedIndex].text
		
}

	function change(){
		
		var pf = document.getElementById("pf");//first name
		var pl = document.getElementById("pl");//last name
		var pc = document.getElementById("pc");//country
		var ps = document.getElementById("ps");//state
		var pa = document.getElementById("pa");//address
		var pp = document.getElementById("pp");//phone
		var pe = document.getElementById("pe");//email
		
		
		var sc = document.getElementById("scountry").value;
		var ss = document.getElementById("sstate").value;
		
		if(document.getElementById("yes").checked == true){
			pf.innerHTML = "<input type=\"text\" class=\"form-control\" id=\"sfname\" placeholder=\"Joe\" style=\"margin: 10px 10px 10px 10px;\" disabled=\"disabled\"/>";
			pl.innerHTML = "<input type=\"text\" class=\"form-control\" id=\"slname\" placeholder=\"Doe\" style=\"margin: 10px 10px 10px 10px;\" disabled=\"disabled\"/>";
			pc.innerHTML = "<select id=\"scountry\" class=\"form-control\" onchange=\"sgetState()\" disabled=\"disabled\"><option value=\"0\">"+ sc + "</option></select>";
			ps.innerHTML = "<select id=\"sstate\" class=\"form-control\" disabled=\"disabled\"><option value=\"0\">"+ss+"</option></select>";
			pa.innerHTML = "<textarea class=\"form-control\" rows=\"2\" id=\"sadrs\" name=\"adrs\" onclick=\"this.innerHTML=''\" disabled=\"disabled\"/></div>";
			pp.innerHTML = "<input type=\"text\" class=\"form-control\" id=\"sphone\" name=\"phone\" style=\"margin: 10px 10px 10px 10px;\" disabled=\"disabled\"/>";
			pe.innerHTML = "<input type=\"email\" class=\"form-control\" id=\"semail\" name=\"email\" style=\"margin: 10px 10px 10px 10px;\" disabled=\"disabled\"/>";
		
			
		} else {
			pf.innerHTML = "<input type=\"text\" class=\"form-control\" id=\"sfname\" placeholder=\"Joe\" style=\"margin: 10px 10px 10px 10px;\"/>";
			pl.innerHTML = "<input type=\"text\" class=\"form-control\" id=\"slname\" placeholder=\"Doe\" style=\"margin: 10px 10px 10px 10px;\"/>";
			pc.innerHTML = "<select id=\"scountry\" class=\"form-control\" onchange=\"sgetState()\"><option value=\"0\">Select country</option><option value=\"Canada\" >Canada</option><option value=\"USA\" >USA</option></select>";
			ps.innerHTML = "<select id=\"sstate\" class=\"form-control\"><option value=\"0\">Select state</option></select>";
			pa.innerHTML = "<textarea class=\"form-control\" rows=\"2\" id=\"sadrs\" name=\"adrs\" onclick=\"this.innerHTML=''\"/>Please enter address</textarea></div>";
			pp.innerHTML = "<input type=\"text\" class=\"form-control\" id=\"sphone\" name=\"phone\" style=\"margin: 10px 10px 10px 10px;\"/>";
			pe.innerHTML = "<input type=\"email\" class=\"form-control\" id=\"semail\" name=\"email\" style=\"margin: 10px 10px 10px 10px;\"/>";
			
		}
		
	}
