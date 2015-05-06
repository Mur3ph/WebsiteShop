<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    
<%@ page import="my.project.business_classes.Customer, my.project.business_classes.Product, my.project.business_classes.Order, my.project.business_classes.OrderItem, java.util.Date"%>
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
<title>Order</title>
<!-- LINK TO MY EXTERNAL CSS FILE ...............................................-->
				<link href="project.css" rel="stylesheet" type="text/css"/>
				
		<!-- LINK TO MY EXTERNAL JAVASCRIPT FILE ...............................................-->		
				<script src="javascript.js"></script>

</head>
<body>

		<!-- START OF OUTER TABLE ...............................................-->
				
					<table border="0" align="center">
					
					
					<!-- ADDED NEW FIRST ROW 4 COLUMN SPAN ADDED ABOVE HEADER......................................................................................................-->
					
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
								
						
							
							
								<form action="UserController" method="post">
									<table align="center"  border="0" cellspacing="5" width="90%" frame="void">
									
										
										
										
												
									<tr>
										<td>
											
											<!-- This table is for displaying what the customer is purchasing............ -->
													
												<table align="center" width="100%">
															
													<tr bgcolor="#CC9966"> 
														<th colspan="4" align="center"><label><fmt:message key="login.label.details" /></label></th>
													<tr>
													
													<tr bgcolor="#CC9933"> 
														<th><label><fmt:message key="login.label.code" /></label></th><th><label><fmt:message key="login.label.name" /></label></th><th><label><fmt:message key="login.label.genre" /></label></th><th><label><fmt:message key="login.label.price" /></label></th>
													<tr>
													
													
													
													
												<!-- Using this customers what their trying to purchase on session... --> 
												
													<c:set var="item1" value="${sessionScope.product}"/>
													<c:set var="order" value="${sessionScope.customer_order}"/>
													
													<tr>
																  
																  <td align="center"><input type="text" name="orderId" value="${order.orderId}" size="5"/></td>
																  <td align="center"><c:out value="${item1.name}" /></td>
																  <td align="center"><c:out value="${item1.genre}" /></td>
																  <td align="center"><input type="text" name="prodId" value="${item1.productId}" size="5"/></td>	 
														
													</tr>
													
													
													<tr bgcolor="#CC9966">
														
															
															<td id="reg" align="right" colspan="3"><label><fmt:message key="login.label.totalprice" /></label>:</td>
															<td id="reg" align="center"><input type="text" name="total" readonly="readonly" value="${item1.price + item2.price + item3.price + item4.price + item5.price}"/></td>
															
														
													</tr>
													
													<tr>
														
															<td id="reg" align="center" colspan="4">&nbsp;</td>
														
													</tr>
											
													
												</table>
												
										</td>	
									</tr>
														
																
									
													
											
									<tr>
										<td>
										
											<table align="center" width="100%" frame="box" bgcolor="#CC9933">
											
													<tr> 
													
														<td align="left" colspan="2" width="30%"><label></label></td>
														
														
													<tr>
													
													<tr>
													
														  <td align="center"><input type="hidden" name="action" value="finish"></td>
												      	  <td align="center"><input type="submit" value="<fmt:message key="login.button.finish" />"></td>
												
													</tr>
													
											</table>
											
										</td>
									</tr>			
										
										
									
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