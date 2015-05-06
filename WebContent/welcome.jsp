<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="my.project.business_classes.User, my.project.business_classes.Product, java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<c:set var="language" 
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
	   scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename = "my.project.languages.labels" />  

<%
String cookieName = "nameoftheuser";
Cookie cookies [] = request.getCookies ();
Cookie myCookie = null;
if (cookies != null)
{
for (int i = 0; i < cookies.length; i++) 
{
if (cookies[i].getName().equals("nameoftheuser"))
{
myCookie = cookies[i];
break; 
}
}
}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Page</title>

<!-- LINK TO MY EXTERNAL CSS FILE ..........................................................................................................................-->
				<link href="project.css" rel="stylesheet" type="text/css"/>
				
		<!-- LINK TO MY EXTERNAL JAVASCRIPT FILE ...........................................................................................................-->		
				<script src="javascript.js"></script>


</head>
<body>
<!-- START OF OUTER TABLE ...........................................................................................................................-->
				
					<table border="0" align="center">
					
					
					<!-- ADDED NEW FIRST ROW 4 COLUMN SPAN ADDED ABOVE HEADER......................................................................................................-->
					
					<tr bgcolor="#666666">
						<td colspan="2"></td>
						<td colspan="2" align="right" ><a href="customer_cart.jsp"><fmt:message key="login.label.cart" /></a>&nbsp;|&nbsp;<a href="UserController?action=logout"><fmt:message key="login.label.logout" /></a></td>
					</tr>
					
							
					<!-- HEADER FIRST ROW 4 COLUMN SPAN......................................................................................................-->
					
							<tr>
							
								<th colspan="4"><h1><img src="images/header2.jpg" alt="project_header"/></h1></th>
								
								
							</tr>
							
							<!-- INTERNAL LINKS SECOND ROW 4 COLUMN SPAN......................................................................................-->
							
							<tr id="links">
							
								<td colspan="4" id="horizontal">
									
									<ul>
										<li><a href="home.jsp"><fmt:message key="login.button.home" /></a></li>
										<li><a href="register.jsp"><fmt:message key="login.button.reg1" /></a></li>
										<li><a href="UserController?action=listAllProducts"><fmt:message key="login.button.shop" /></a></li>
										<li><a href="login_index.jsp"><fmt:message key="login.button.login" /></a></li>
										<li><a href="tickets.jsp"><fmt:message key="login.label.tickets" /></a></li>
										
									</ul>  
									
								</td>
								
								
							</tr>
							
							<!-- ADDED NEW ROW FOR A LOGGING OUT BUTTON...................................................................................... -->
							
							<tr>
							
								<td colspan="4" align="right"></td>
								
							</tr>
					
							
							<!-- THIRD ROW 4 COLUMNS MIGHT SPAN ON SOME PAGES FOR ANOTHER TABLE GOING IN HERE... -->
							
							<tr>
								
								<td colspan="4">
								
								<form action="UserController" method="post">
									<table align="center"  border="0" cellspacing="0" width="100%">
											
										
												<tr>
												
													<td id="reg" align="left">
													
														<ul>
														
															<li><a href="update.jsp"><fmt:message key="login.button.update" /></a></li>
															<li><a href="delete_user.jsp"><fmt:message key="login.button.deletep" /></a></li>
															<li><a href="UserController?action=listAllProducts"><fmt:message key="login.button.onlineshop" /></a></li>
															<li><a href="tickets.html"><fmt:message key="login.button.event" /></a></li>
															<li><a href=""><fmt:message key="login.button.history" /></a></li>
															
														</ul> 
													
													</td>
												
													<td>
														
															<table id="reg" frame="box" align="center" width="90%">
															
															
																<tr bgcolor="#CC9933"> 
																	<th colspan="4" align="center"><label><fmt:message key="login.label.welc" /></label></th>
																<tr>
																
																<tr bgcolor="#CC9966">
														
																	<th id="reg" align="center"><label><fmt:message key="login.label.firstname" /></label></th>
																	<th id="reg" align="center"><label><fmt:message key="login.label.lastname" /></label></th>
																	<th id="reg" align="center"><label><fmt:message key="login.label.username" /></label></th>
																	<th id="reg" align="center"><label><fmt:message key="login.label.email" /></label></th>
																	
																</tr>
																
															
																<tr>
																<%
																	if (myCookie == null) {
																	%>
																	welcome new user
																	<%
																	} else {
																	%> 
																	Welcome: <%=myCookie.getValue()%>.
																	<%
																	}
																	%>
																<td id="reg" align="center"><label for="fname"><c:out value="${user.firstName}"/></label></td>
																<td id="reg" align="center"><label for="lname"><c:out value="${user.lastName}"/></label></td>
																<td id="reg" align="center"><label for="uname"><c:out value="${user.userName}"/></label></td>
																<td id="reg" align="center"><label for="email"><c:out value="${user.emailAddress}"/></label></td>
																
																</tr>
																
																
																
															</table>
														
													</td>		
												</tr>				
												
									
									</table>
								</form>
								
							</td>
								
							
								
					</tr>
							
							<!-- FOURTH ROW FOOTER 4 COLUMNS SPAN .......................................................................................................-->
							
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