

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
	var e=document.forms["myRegForm"]["email"].value;

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
	else if (p==null || p==""){
		  alert("Password must be filled out");
		  myForm.lastname.focus();
		  return false;
	}
	else if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length){
		  alert("Not a valid e-mail address");
		  myForm.email.focus();
		  return false;
	}


	}




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

}// End Of validateLoginForm() Method............................................................................................




//**************************************...Javascript Calculations & Validations For Ticket Page...********************************






function validateTicketForm(){
	
	var f=document.forms["myTicketForm"]["firstname"].value;
	var s=document.forms["myTicketForm"]["lastname"].value;
	var u=document.forms["myTicketForm"]["username"].value;
	var e=document.forms["myTicketForm"]["email"].value;

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


} // End Of validateLoginForm() Method............................................................................................



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

								// Check buttons...............................................
//								
								for (var i=0;i<document.forms[0].extraType.length;i++){
									  if (document.forms[0].extraType[i].checked){
									    document.forms[0].extraType[i].onclick = calcExtra;
									   }
								}
								
//								for ( var i=0 ; i<document.forms[0].extraType.length ; i++ ) {
//									document.forms[0].extraType[i].onclick = calcExtra;
//								}
							
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
			document.forms[0].price.value = (flightTicketPrice * quantityOrdered).toFixed();

				calcTotal();
		

} // End Of calcPrice() Method....................................................................................................


function calcTotal() {
		
		// varibles for the 3 readonly total textboxes
		var priceBal = parseFloat(document.forms[0].price.value);
		var classBal = parseFloat(document.forms[0].class.value);
		var extraBal = parseFloat(document.forms[0].extra.value);
			
			// to get the sub_total
			document.forms[0].sub.value = ((priceBal * classBal) + extraBal).toFixed(2);
			
		// to work out how much tax has to be added to the bill
		var vatRate = 0.25; 
		var vatBal = vatRate * (priceBal + classBal + extraBal);
		
			document.forms[0].vat.value = (vatBal).toFixed(2);
			
			// The net bill plus tax
			document.forms[0].totl.value = ((priceBal * classBal) + extraBal + vatBal).toFixed(2);
			
			
}// End Of calcTotal() Method......................................................................................................






