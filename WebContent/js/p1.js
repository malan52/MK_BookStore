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
	var ss = document.getElementById("sstate").value;
	ss = s;
	//var content = document.getElementById("state").innerHTML;
	//document.getElementById("sstate").innerHTML = content;
	//alert("the PREVIOUS state:"+ s +"\n" + "the copied state:" +ss +"\n" );	
	//+ "the innerHTML is:" + content		
}

function different(){
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
	document.getElementById("sstate").value = s;
	return true;
	
	//document.write("<jsp:include page=\"/shipping.jspx\" />");
}

