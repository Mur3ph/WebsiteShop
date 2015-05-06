<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
  
<%@ page import="my.project.business_classes.User, my.project.business_classes.Product, java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<c:set var="language" 
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
	   scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename = "my.project.languages.labels" />
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Cart</title>

<!-- LINK TO MY EXTERNAL CSS FILE ...............................................-->
				<link href="project.css" rel="stylesheet" type="text/css"/>
				
		<!-- LINK TO MY EXTERNAL JAVASCRIPT FILE ...............................................-->		
				<script src="javascript.js"></script>

</head>
<body>

		<!-- START OF OUTER TABLE ...............................................-->
				
					<table border="0" align="center">
					
					
					<!-- ADDED NEW FIRST ROW 4 COLUMN SPAN ADDED ABOVE HEADER..................&nbsp;....................................................................................-->
					
					<tr bgcolor="#666666">
						
						<td colspan="2"></td>
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
										<li><a href="tickets.jsp"><fmt:message key="login.label.tickets" /></a></li>
										
									</ul> 
									
								</td>
								
								
							</tr>
							
							<!-- ADDED NEW ROW FOR A LOGGING OUT BUTTON........................................................................................... -->
							
							<tr>
							
								<td colspan="4" align="right"></td>
								
							</tr>
					
							
							<!-- THIRD ROW 4 COLUMNS MIGHT SPAN ON SOME PAGES FOR ANOTHER TABLE GOING IN HERE... -->
							
							<tr>
							
								
								<td colspan="4">
								
						
							
							
								<form>
									<table align="center"  border="0" cellspacing="5" width="90%" frame="void">
									
										
									
										
												
									<tr>
										<td>
											
														
												<table align="center" border="1" width="90%">
												
														<tr bgcolor="#CC9966"> 
															<th colspan="4" align="center"><label><fmt:message key="login.label.pd" /></label></th>
														<tr>
														
														<tr bgcolor="#CC9933"> 
												
														<th id="reg" align="center"><fmt:message key="login.label.username"/></th>
														<th id="reg" align="center"><label><fmt:message key="login.label.firstname" /></label></th>
														<th id="reg" align="center"><label><fmt:message key="login.label.lastname" /></label></th>
														<th id="reg" align="center"><label><fmt:message key="login.label.email" /></label></th>
														
														
														</tr>
														
														
														<!-- Using this customers personal details on session --> 
														<c:set var="user" value="${sessionScope.user}"/>
												
														<tr>
														
													    <td align="center"><c:out value="${user.userName}"/></td>
													    <td align="center"><c:out value="${user.firstName}"/></td>
												   	    <td align="center"><c:out value="${user.lastName}"/></td>	
												   	    <td align="center"><c:out value="${user.emailAddress}"/></td> 
															
														</tr>
														
														
														
												</table>
												
										</td>	
									</tr>
														
														
														
														
									<tr>
										<td>
											
														
												<table align="center" width="90%">
												
														<tr> 
												
														<th id="reg" align="center"><label></label></th>
														<th id="reg" align="center"><label></label></th>
														<th id="reg" align="center"><label></label></th>
														<th id="reg" align="center"><label></label></th>
														
														
														</tr>
													
												</table>
												
										</td>	
									</tr>	
												
									
													
													
									<tr>
										<td>
											<!-- frame="box" -->
														
											    <table align="center" width="90%">
															
													<tr bgcolor="#CC9966"> 
														<th colspan="4" align="center"><label><fmt:message key="login.label.details" /></label></th>
													<tr>
													
													<tr bgcolor="#CC9933"> 
														<th><label><fmt:message key="login.label.name" /></label></th><th><label><fmt:message key="login.label.code" /></label></th><th><label><fmt:message key="login.label.genre" /></label></th><th><label><fmt:message key="login.label.price" /></label></th>
													<tr>
													
													
													
													
												<!-- Using this customers what their trying to purchase on session... --> 
												
													<c:set var="item" value="${sessionScope.product}"/>
													<tr>
																  <td align="center"><c:out value="${item.code}" /></td>
																  <td align="center"><c:out value="${item.name}" /></td>
																  <td align="center"><c:out value="${item.genre}" /></td>
																  <td align="center"><c:out value="${item.price}" /></td>	 
														
													</tr>
													
													
													<tr bgcolor="#CC9966">
														
															
															<td id="reg" align="right" colspan="3"><label>Total Price:</label></td>
															<td id="reg" align="center"><input type="text" name="total" readonly="readonly" value="${item.price}"/></td>
															
														
													</tr>
													
													<tr>
														
															<td id="reg" align="center" colspan="4">&nbsp;</td>
														
													</tr>
													
													
													<tr bgcolor="#CC9933">
														
															<td id="reg" align="center" colspan="2"><a href="UserController?action=listAllProducts">Continue Shopping</a></td>
		
															<td id="reg" align="center" colspan="2"><a href="billing_info.jsp">Proceed To Check Out</a></td>
															
													</tr>
													
													<tr>
														
															<td id="reg" align="center" colspan="4">&nbsp;</td>
														
													</tr>
													
												</table>
												
										
										
									
									</table>
								</form>
								
								</td>
								
							
								
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

<!-- <c:forEach var="item1" items="${sessionScope.products}"> -->
<!-- <c:set var="totAmt" value="${totAmt + item1.price}"/> -->
<!-- </c:forEach>	-->