//*************************************...The Working One...***********************************************************************

//********************************************************...A Few Testers...******************************************************


function popup() {
alert("Hello.. !! ");
}

function bigImg(x){
x.style.height="250";
x.style.width="250";
}

function normalImg(x){
x.style.height="200";
x.style.width="200";
}


//*********************************************...Validation For Registration Page...**********************************************


function validateRegForm(){
	
	var f=document.forms["myRegForm"]["firstname"].value;
	var s=document.forms["myRegForm"]["lastname"].value;
	var u=document.forms["myRegForm"]["username"].value;
	var p=document.forms["myRegForm"]["password"].value;
	var rp=document.forms["myRegForm"]["repassword"].value;
	var e=document.forms["myRegForm"]["email"].value;

	var atpos=e.indexOf("@");
	var dotpos=e.lastIndexOf(".");

	if (u==null || u==""){
		  alert("Username must be filled out");
		  document.myForm.firstname.focus();
		  return;
	}
	if (f==null || f==""){
		  alert("First name must be filled out");
		  document.myForm.firstname.focus();
		  return;
	}
	if (s==null || s==""){
		  alert("Surname must be filled out");
		  document.myForm.lastname.focus();
		  return;
	}
	if (p==null || p==""){
		  alert("Password must be filled out");
		  document.myForm.lastname.focus();
		  return;
	}
	if (rp==null || rp==""){
		  alert("You must re-enter your password");
		  document.myForm.lastname.focus();
		  return;
	}
	if (rp != p){
		  alert("Passwords have to match");
		  document.myForm.password.value = "";
		  document.myForm.repassword.value = "";
		  document.myForm.password.focus();
		  return false;
	}
	if (atpos < 1 || dotpos < atpos+2 || dotpos+2 >= x.length){
		  alert("Not a valid e-mail address");
		  document.myForm.email.focus();
		  return;
	}
		document.myRegForm.submit();

	}




//*********************************************...Validation For Registration Page...ENDS HERE**********************************************


//*********************************************...Validation For Update Page...**********************************************



function validateUpdatePage(){
	
var u=document.forms["myUpdateForm"]["uname"].value;
var o=document.forms["myUpdateForm"]["opassword"].value;
var n=document.forms["myUpdateForm"]["npassword"].value;
var vn=document.forms["myUpdateForm"]["vnpassword"].value;


if (u==null || u==""){
	  alert("Username must be filled out");
	  document.myForm.firstname.focus();
	  return;
}
if (o==null || o==""){
	  alert("Old password must be filled out");
	  document.myForm.firstname.focus();
	  return;
}
if (n==null || n==""){
	  alert("New password must be filled out");
	  document.myForm.firstname.focus();
	  return;
}
if (vn==null || vn==""){
	  alert("New password must be filled out twice");
	  document.myForm.firstname.focus();
	  return;
}
if (vn != n){
	  alert("New password must match");
	  document.myForm.npassword.value = "";
	  document.myForm.vnpassword.value = "";
	  document.myForm.firstname.focus();
	  return;
}


}



//*********************************************...Validation For Update Page Ends here...**********************************************



//*********************************************...Validation For Billing Page...**********************************************



function validateBillingPage(){
	
var f=document.forms["billForm"]["firstname"].value;
var l=document.forms["billForm"]["lastname"].value;
var a1=document.forms["billForm"]["address1"].value;
var a2=document.forms["billForm"]["address2"].value;
var city=document.forms["billForm"]["city"].value;
var county=document.forms["billForm"]["county"].value;
var country=document.forms["billForm"]["country"].value;
var z=document.forms["billForm"]["zip"].value;
var phone=document.forms["billForm"]["phone"].value;

var cardt=document.forms["billForm"]["cardtype"].value;
var cardnum=document.forms["billForm"]["cardnumber"].value;
var cardidnum=document.forms["billForm"]["cardidnumber"].value;
var v=document.forms["billForm"]["valid"].value;



if (f==null || f==""){
	  alert("First name must be filled out");
	  document.billForm.firstname.focus();
	  return;
}
if (l==null || l==""){
	  alert("Last name must be filled out");
	  document.billForm.lastname.focus();
	  return;
}
if (a1==null || a1==""){
	  alert("Address line 1 must be filled out");
	  document.billForm.address1.focus();
	  return;
}
if (a2==null || a2==""){
	  alert("Address line 2 must be filled out ");
	  document.billForm.address2.focus();
	  return;
}
if (city==null || city==""){
	  alert("City must be filled out ");
	  document.billForm.city.focus();
	  return;
}
if (county==null || county==""){
	  alert("County must be filled out ");
	  document.billForm.county.focus();
	  return;
}
if (country==null || country==""){
	  alert("Country must be filled out ");
	  document.billForm.country.focus();
	  return;
}
if (z==null || z==""){
	  alert("Zip code must be filled out ");
	  document.billForm.zip.focus();
	  return;
}
if (phone==null || phone==""){
	  alert("Phone number must be filled out");
	  document.billForm.phone.focus();
	  return;
}
if (city==null || city==""){
	  alert("City must be filled out twice");
	  document.billForm.address2.focus();
	  return;
}
if (cardt==null || cardt==""){
	  alert("Your credit card type must be filled out ");
	  document.billForm.cardtype.focus();
	  return;
}
if (cardnum==null || cardnum==""){
	  alert("Your credit card number must be filled out ");
	  document.billForm.cardnumber.focus();
	  return;
}
if (cardnum.length != 15){
	  alert("Incorrect card number.. !!!");
	  document.billForm.cardnumber.focus();
	  return;
} 
if (cardidnum==null || cardidnum==""){
	  alert("Your credit card id number must be filled out ");
	  document.billForm.cardidnumber.focus();
	  return;
}
if (cardidnum.length != 4){
	  alert("Incorrect card id number.. !!! ");
	  document.billForm.cardidnumber.focus();
	  return;
}
if (v==null || v==""){
	  alert("Your credit card valid date must be filled out");
	  document.billForm.valid.focus();
	  return;
}


}



//*********************************************...Validation For Billing Page Ends here...**********************************************




//*********************************************...Validation For Both Login Pages...**********************************************



function validateLoginForm(){
	
	var x=document.forms["myLoginForm"]["username"].value;
	var y=document.forms["myLoginForm"]["password"].value;

	if (x==null || x==""){
	  alert("Username must be filled out");
	  myLoginForm.username.focus();
	  return false;
	 }
	if (y==null || y==""){
		  alert("Password must be filled out");
		  myLoginForm.password.focus();
		  return false;
	}

}

//*********************************************...Validation For Both Login Pages.ENDS..**********************************************



//**************************************...Javascript Calculations & Validations For Ticket Page...********************************






function validateTicketForm(){
	
	var f=document.forms["myTicketForm"]["firstname"].value;
	var s=document.forms["myTicketForm"]["lastname"].value;
	var e=document.forms["myTicketForm"]["email"].value;
	var u=document.forms["myTicketForm"]["username"].value;

	var atpos=e.indexOf("@");
	var dotpos=e.lastIndexOf(".");

	if (f==null || f==""){
		  alert("First name must be filled out");
		  myForm.firstname.focus();
		  return false;
	}
	else if (s==null || s==""){
		  alert("Surname must be filled out");
		  myForm.lastname.focus();
		  return false;
	}
	else if (u==null || u==""){
		  alert("Username must be filled out");
		  myForm.firstname.focus();
		  return false;
	}
	else if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length){
		  alert("Not a valid e-mail address");
		  myForm.email.focus();
		  return false;
	}


} // End Of validateTicketForm() Method............................................................................................



function startForm() {
	
	
	document.forms[0].ticket.focus();
			
	// validate the data that has been entered by the user 
	document.forms[0].ticket.onchange = calcPrice;
	document.forms[0].quant.onchange = calcPrice;
	document.forms[0].onsubmit = checkForm;
	//document.forms[0].onsubmit = getEmail;
			
							// Which ever one is clicked add that value to class box, current value of the hidden object...
							
							function calcClass() {
								document.forms[0].class.value = this.value;
						           calcTotal();
							}
					
							// You need to go through all radio's and see which one's checked property is true.
							
							for ( var i=0 ; i<document.forms[0].classType.length ; i++ ) {
								document.forms[0].classType[i].onclick = calcClass;
							}
					
					
					
								
							function checkForm() {
							
								if (document.forms[0].cname.value.length == 0) {
									alert("You must enter Your full name");
									return false;
								}else if (document.forms[0].caddress.value.length == 0) {
									alert("You must enter your delivery address");
									return false;
								} else if (document.forms[0].cemail.value.length == 0) {
									alert("You must enter your email address");
									return false;
								} else {
									alert("Order Successful, Thank you");
									return true;
								}
							
							}
					

					
								function changeText2(){
									var userInput = document.getElementById("userInput").value;
									document.getElementById("txtChange").innerHTML = userInput;
								}
								
								// Second Set Of Radio Buttons buttons...............................................
						
								
								for ( var i=0 ; i<document.forms[0].extraType.length ; i++ ) {
									document.forms[0].extraType[i].onclick = calcExtra;
								}
							
								function calcExtra() {
									document.forms[0].extra.value = this.value;
									calcTotal();
								}	
								
								
			
} // End startForm() Method..........................................................................................................




function calcPrice() {
		var flightTicket = document.forms[0].ticket;
		// returns the index of the selected option in the drop down list - ticket
		var ticketIndex = flightTicket.selectedIndex;
			
		// Gets the the price of the ticket you chose from the value in option
		var flightTicketPrice = flightTicket.options[ticketIndex].value;
			
		var quantity = document.forms[0].quant;
		// returns the index of the selected option in the drop down list
		var quantityIndex = quantity.selectedIndex;
		// Gets the no. of tickets you ordered from the value in options
		var quantityOrdered = quantity.options[quantityIndex].value;
			// Sum of tickets and amount
			document.forms[0].price.value = (flightTicketPrice * quantityOrdered).toFixed(2);

				calcTotal();
		

} // End Of calcPrice() Method....................................................................................................


function calcTotal() {
		
		// varibles for the 3 readonly total textboxes
		var priceBal = parseFloat(document.forms[0].price.value);
		var classBal = parseFloat(document.forms[0].class.value);
		var extraBal = parseFloat(document.forms[0].extra.value);
			
			// to get the sub_total
			document.forms[0].sub.value = ((priceBal + classBal) + extraBal).toFixed(2);
			
		// to work out how much tax has to be added to the bill
		var vatRate = 0.25; 
		var vatBal = vatRate * (priceBal + classBal + extraBal);
		
			document.forms[0].vat.value = (vatBal).toFixed(2);
			
			// The net bill plus tax
			document.forms[0].totl.value = ((priceBal + classBal) + extraBal + vatBal).toFixed(2);
			
			
}// End Of calcTotal() Method......................................................................................................


//**************************************...Validations For Customer details page...******************************************************************************************



//**************************************...Validations For Customer details page ENDS...******************************************************************************************



