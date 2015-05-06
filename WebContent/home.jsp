<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
<%@ page import="my.project.business_classes.User" %>



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>




<c:set var="language" 
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
	   scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename = "my.project.languages.labels" />

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="${language}">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
			
		
		<!-- LINK TO MY EXTERNAL CSS FILE ...............................................-->
				<link href="project.css" rel="stylesheet" type="text/css"/>
				
		<!-- LINK TO MY EXTERNAL JAVASCRIPT FILE ...............................................-->		
				<script src="/sound.js"></script>
				
				
		
<script type="text/javascript">
	
	//here it is standard ajax connection and creating an object for a connection..............................
	// this is an Asynchronous call back function execution using.........
	// gets a request from the server and sends a responce back to the browser.................................
	
	function createXMLHTTPRequestObject() {
		  var resObject = null;
		  try {
		    resObject = new ActiveXObject("Microsoft.XMLHTTP");
		  } catch (Error) {
		    try {
		      resObject = new ActiveXObject("MSXML2.XMLHTTP");
		    } catch (Error) {
		      try {
			resObject = new XMLHttpRequest();
		      } catch (Error) {
			sleep(0);
		      }
		    }
		  }
		  return resObject;
		}

	// heres a function that gets the valus or page and executes that choosen page......................
	//this is the end function that is called.............................................................

	function pic(value){
			myAjax(value);
	}

	
	// To distinguish which option was choosen on the drop down list.....................................
	// if the value on the drop down list equals p1 then choose that picture and place it in the frame....
	//using the id "list of pics" in the column ...........................................................
	
	function myAjax(value){
		
		var loc1 = "pic1.jsp";
		var loc2 = "pic2.jsp";
		var loc3 = "pic3.jsp";
		var loc4 = "pic4.jsp";
		var loc5 = "pic5.jsp";

		
		if (value == "p1")
		{
			
			new Ajax.Request(loc1, {
				method: "get",
			    onSuccess: function (transport) {
				html = transport.responseText;
				$("listofPictures").innerHTML = html;
			}
			}
			);
		}
		if (value == "p2")
		{
		new Ajax.Request(loc2, {
			method: "get",
		    onSuccess: function (transport) {
			html = transport.responseText;
			$("listofPictures").innerHTML = html;
		}
		}
		);
		}
		if (value == "p3")
		{
		new Ajax.Request(loc3, {
			method: "get",
		    onSuccess: function (transport) {
			html = transport.responseText;
			$("listofPictures").innerHTML = html;
		}
		}
		);
		}
		if (value == "p4")
		{
		new Ajax.Request(loc4, {
			method: "get",
		    onSuccess: function (transport) {
			html = transport.responseText;
			$("listofPictures").innerHTML = html;
		}
		}
		);
		}
		if (value == "p5")
		{
		new Ajax.Request(loc5, {
			method: "get",
		    onSuccess: function (transport) {
			html = transport.responseText;
			$("listofPictures").innerHTML = html;
		}
		}
		);
		}
		
	}
	
</script>
<script type="text/javascript" src="prototype.js"></script>	
			
				</head>
					<body>
				
				<!-- START OF OUTER TABLE ...........................................................-->
				
					<table border="0" align="center">
					
					
					
					<!-- ADDED NEW FIRST ROW 4 COLUMN SPAN ADDED ABOVE HEADER......................................................................................................-->
					
					<tr bgcolor="#666666">
						<td colspan="2"><a href="welcome.jsp">${user.userName}</a></td>
						<td >
						
							<table>
							
								<tr bgcolor="#666666">
									
									<td id="language"><a href="home.jsp?language=en"><img src="images/flags/usa.gif" alt="American Flag"/></a></td>
									<td id="language"><a href="home.jsp?language=es"><img src="images/flags/spain.gif" alt="Spanish Flag"/></a></td>
									<td id="language"><a href="home.jsp?language=ie"><img src="images/flags/ireland.gif" alt="Irish Flag"/></a></td>
									<td id="language"><a href="home.jsp?language=fr"><img src="images/flags/france.gif" alt="French Flag"/></a></td>
									
								</tr>	
									
							</table>	
						
						</td>
						
						<td colspan="2" align="right" ><a href="customer_cart.jsp"><fmt:message key="login.label.cart" /></a>&nbsp;|&nbsp;<a href="UserController?action=logout"><fmt:message key="login.label.logout" /></a></td>
					</tr>
					
							
					<!-- HEADER FIRST ROW 4 COLUMN SPAN...............................................-->
					
							<tr>
							
								<th colspan="4"><h1><img src="images/header2.jpg" alt="project_header"/></h1></th>
								
								
							</tr>
							
							<!-- INTERNAL LINKS SECOND ROW 4 COLUMN SPAN..................................-->
							
							<tr id="links">
							
								<td colspan="4" id="horizontal">
									
									<ul>
										<li><a href="home.jsp"><fmt:message key="login.button.home" /></a></li>
										<li><a href="register.jsp"><fmt:message key="login.button.reg1" /></a></li>
										<li><a href="UserController?action=listAllProducts"><fmt:message key="login.button.shop" /></a></li>
										<li><a href="login_index.jsp"><fmt:message key="login.button.login" /></a></li>
										<li><a href="UserController?action=listAllTickets"><fmt:message key="login.label.tickets" /></a></li>
										
									</ul> 
									
								</td>
								
								
							</tr>
							
							<!-- ADDED NEW ROW FOR A LOGGING OUT BUTTON........................................ -->
							
							<tr>
							
								<td colspan="4" align="right"></td>
								
							</tr>
					
							
							<!-- THIRD ROW 4 COLUMNS MIGHT SPAN ON SOME PAGES FOR ANOTHER TABLE GOING IN HERE... -->
							
							<tr>
							
								<td align="center">
									<table>
										<tr>
											<td  id="listofPictures"><img src="images/gig2.jpg" alt="Concert Crowd" height="150" width="150"/></td>
											
										</tr>
										
										<tr>
											<td id="reg"><label>Browse Photo's of <br/>our recent gigs !!!</label></td>
											
										</tr>
										
										<tr>
											<!-- Calling the Ajax method here -->
											<td id="reg">
												<select name='pic' id='pic' onChange="pic(this.options[this.selectedIndex].value);">
								
													<option value="">Select...</option>
													<option value="p1">Live In New York</option>
													<option value="p2">Wood Stock</option>
													<option value="p3">Henman Hill</option>
													<option value="p4">Singapore</option>
													<option value="p5">DKIT</option>
													
												</select>
											</td>	
										</tr>		
									</table>
								
								</td>
								
								
								
								
								
								<td colspan="2" align="left" id="reg">
														<h2>Introduction</h2>
												<p>Welcome back to The Blah Blah for another exciting week.<br/> 
												   We have had some requests here that we do an Intro to Indie<br/>
												   Music segment, so welcome, and please share your opinions <br/>
												   as we move along.  As I seek to define indie music, I am <br/>
												   touching on a segment of the music industry that is very <br/>
												   hard to define.  In fact, the definition seems to change <br/>
												   depending on who you are talking to, what era you are referring <br/>
												   to, and what mood you are in that day. 
												</p>
												<p>
													What is indie music?  Who listens to it? What does it sound <br/>
													like? Is there really a difference from big label music? Do <br/>
													you even dare find out the answers?
												</p>
												
						
						
								</td>
								
								<td id="reg" align="center"><object style="height: 200px; width: 200px"><param name="movie" value="http://www.youtube.com/v/E5gNYVia2rg?version=3&feature=player_detailpage"><param name="allowFullScreen" value="true"><param name="allowScriptAccess" value="always"><embed src="http://www.youtube.com/v/E5gNYVia2rg?version=3&feature=player_detailpage" type="application/x-shockwave-flash" allowfullscreen="true" allowScriptAccess="always" width="200" height="200"></object></td>
								
							</tr>
							
							<!-- FOURTH ROW FOOTER 4 COLUMNS SPAN ............................................-->
							
							<tr>
							
								<td colspan="4" id="footer"> <p>Top Notch Books<br />
																Sesame Street<br />
																Dundalk<br />
																Co. Tipperary<br />

																Tel: +353 (0)99 999 9999<br />
																Fax: +353 (0)00 000 0000<br />
																Email: info@ismise.ie</p>
								</td>
								
							</tr>
							
					</table> 

				</body>
</html>