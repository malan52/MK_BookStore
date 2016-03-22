 var city=[
     ["Ontario","Quebec","Nova Scotia","New Brunswick","Manitoba","British Columbia","Prince Edward Island","Saskatchewan","Alberta","Newfoundland and Labrador" ],
     ["Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","Florida","Georgia","Hawaii","Idaho","Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota","Mississippi","Missouri","Montana","Nebraska","Nevada","Nevada","New Jersey","New Mexico","New York","North Carolina","North Dakota","Ohio,Oklahoma","Oregon","Pennsylvania","Rhode Island","South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Washington","Washington","Wisconsin","Wyoming","District of Columbia"],
     ];

     function getCity(){
         
         var sltProvince=document.form1.province;        
         var sltCity=document.form1.city;            
         var provinceCity=city[sltProvince.selectedIndex - 1];         
         sltCity.length=1;         
         for(var i=0;i<provinceCity.length;i++){
             sltCity[i+1]=new Option(provinceCity[i],provinceCity[i]);
         }
     }