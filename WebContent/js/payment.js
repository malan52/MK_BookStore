var arr = new  Array();
arr[0]="Ontario,Quebec,Nova Scotia,New Brunswick,Manitoba,British Columbia,Prince Edward Island,Saskatchewan,Alberta,Newfoundland and Labrador" 
arr[1]="Alabama,Alaska,Arizona,Arkansas,California,Colorado,Connecticut,Delaware,Florida,Georgia,Hawaii,Idaho,Illinois,Indiana,Iowa,Kansas,Kentucky,Louisiana,Maine,Maryland,Massachusetts,Michigan,Minnesota,Mississippi,Missouri,Montana,Nebraska,Nevada,Nevada,New Jersey,New Mexico,New York,North Carolina,North Dakota,Ohio,Oklahoma,Oregon,Pennsylvania,Rhode Island,South Carolina,South Dakota,Tennessee,Texas,Utah,Vermont,Virginia,Washington,Washington,Wisconsin,Wyoming,District of Columbia" 


function init()
{
    var state = document.getElementById("state");
    var stateArr = arr[0].split(",");
    for(var i=0;i<stateArr.length;i++)
    {
             state[i]=new Option(stateArr[i],stateArr[i]);
    }
}

function getState()
{    
    var county = document.getElementById("country");
    var state = document.getElementById("state");
    var index = county.selectedIndex;
    var stateArr = arr[index].split(",");   
    
    state.length = 0;
    
    for(var i=0;i<stateArr.length;i++)
    {
             state[i]=new Option(stateArr[i],stateArr[i]);
         }
}