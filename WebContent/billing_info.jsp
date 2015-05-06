<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="my.project.business_classes.User, my.project.business_classes.Product, java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="javax.xml.parsers.DocumentBuilderFactory" %>
<%@ page import="javax.xml.parsers.DocumentBuilder" %>
<%@ page import="org.w3c.dom.*" %>
<%@ page import="java.util.*" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>




<c:set var="language" 
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
	   scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename = "my.project.languages.labels" />

<%  
	DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
	DocumentBuilder db=dbf.newDocumentBuilder();
	Document doc=db.parse("counties.xml");
	NodeList nl=doc.getElementsByTagName("county");
%>

<%  
	DocumentBuilderFactory dbf1=DocumentBuilderFactory.newInstance();
	DocumentBuilder db1=dbf1.newDocumentBuilder();
	Document doc1=db1.parse("countries.xml");
	NodeList nl1=doc1.getElementsByTagName("country");
%>

<%  
	DocumentBuilderFactory dbf2=DocumentBuilderFactory.newInstance();
	DocumentBuilder db2=dbf2.newDocumentBuilder();
	Document doc2=db2.parse("years.xml");
	NodeList nl2=doc2.getElementsByTagName("year");
%>

<%  
	DocumentBuilderFactory dbf3=DocumentBuilderFactory.newInstance();
	DocumentBuilder db3=dbf3.newDocumentBuilder();
	Document doc3=db3.parse("months.xml");
	NodeList nl3=doc3.getElementsByTagName("month");
%>

<%  
	DocumentBuilderFactory dbf4=DocumentBuilderFactory.newInstance();
	DocumentBuilder db4=dbf4.newDocumentBuilder();
	Document doc4=db4.parse("creditcards.xml");
	NodeList nl4=doc4.getElementsByTagName("cardtype");
%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Billing Information</title>
<!-- LINK TO MY EXTERNAL CSS FILE ...............................................-->
				<link href="project.css" rel="stylesheet" type="text/css"/>
				
		<!-- LINK TO MY EXTERNAL JAVASCRIPT FILE ...............................................-->		
				<script src="javascript.js"></script>

</head>
<body>

		<!-- START OF OUTER TABLE .......................width="80%"........................-->
				
					<table border="0" align="center">
					
					
					<!-- ADDED NEW FIRST ROW 4 COLUMN SPAN ADDED ABOVE HEADER......................................................................................................-->
					
					<tr bgcolor="#666666">
						<td colspan="2"></td>
						<td colspan="2" align="right" ><a href="customer_cart.jsp"><fmt:message key="login.label.cart" /></a>&nbsp;|&nbsp;<a href="UserController?action=logout"><fmt:message key="login.label.logout" /></a></td>
					</tr>
					
							
					<!-- HEADER FIRST ROW 4 COLUMN SPAN...............................................-->
					
							<tr>
	
								<th colspan="4" align="right"><h1><img src="images/header2.jpg" alt="project_header"/></h1></th>
								
								
							</tr>
							
							<!-- INTERNAL LINKS SECOND ROW 4 COLUMN SPAN..................................-->
							
							<tr id="links">
							
								<td colspan="4" id="horizontal"  bgcolor="#0066CC">
									
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
								
						
							
							
								<form action="UserController" method="post" name="billForm">
									<table align="center"  border="0" cellspacing="5" width="100%" frame="void">
										
									
									<!-- Personal Billing Information And Payment Information -->				
													
									<tr>
										<td>
											
														
											    <table align="center" border="1" cellpadding="1" cellspacing="1" width="100%">
													
													<tr> 
													
														<td align="left" colspan="2" width="30%" bgcolor="#CC9933"><label><fmt:message key="login.label.baddress"/></label></td>
														
														
													<tr>
													
													<tr> 
													
														<td align="left" width="30%" bgcolor="#CC9966"><label><fmt:message key="login.label.firstname" />:<span style="color: red">*</span></label></td>
														<td align="left"><input type="text" name="firstname" value="${user.firstName}" size="30"/></td>	
														
													<tr>
													
							
													<tr>
													
														  <td align="left" width="30%" bgcolor="#CC9966"><label><fmt:message key="login.label.lastname" />:<span style="color: red">*</span></label></td>
														  <td align="left"><input type="text" name="lastname" value="${user.lastName}" size="30"/></td> 
														
													</tr>
													
												
													
													<tr>
													
														  <td align="left" width="30%" bgcolor="#CC9966"><label><fmt:message key="login.label.addr1" /></label>:<span style="color: red">*</span><br/><fmt:message key="login.label.street" /></td>
														  <td align="left"><input type="text" name="address1" size="50"/></td>
													   	  
													</tr>
													
													<tr>
													
														  <td align="left" width="30%" bgcolor="#CC9966"><fmt:message key="login.label.addr2" />:<span style="color: red">*</span><br/><fmt:message key="login.label.apps" /></td>
														  <td align="left"><input type="text" name="address2" size="50"/></td>
												
													</tr>
													
													<tr>
											
														  <td align="left" width="30%" bgcolor="#CC9966"><label><fmt:message key="login.label.city" /></label>:<span style="color: red">*</span></td>
														  <td align="left"><input type="text" name="city" /></td>
												
													</tr>
													
													<tr>
											
														  <td align="left" width="30%" bgcolor="#CC9966"><label><fmt:message key="login.label.county" /></label>:<span style="color: red">*</span></td>
														  
														  <td align="left" id="reg">
														  <select name="county">
															  <% for(int x=0;x<32;x++){ %>
															  	<option value="<%=nl.item(x).getFirstChild().getNodeValue() %>"><%=nl.item(x).getFirstChild().getNodeValue() %></option>
															   <% } %>
														  </select>
														  </td>
														 
													</tr>
													
													<tr>
											
														  <td align="left" width="30%" bgcolor="#CC9966"><label><fmt:message key="login.label.country" /></label>:<span style="color: red">*</span></td>
														  <td align="left" id="reg">
														  
														  	<select name="country">
															  <% for(int x=0;x<51;x++){ %>
															  	<option value="<%=nl1.item(x).getFirstChild().getNodeValue() %>"><%=nl1.item(x).getFirstChild().getNodeValue() %></option>
															   <% } %>
														  </select>
														  
														  </td>
												
													</tr>
													
													<tr>
											
														  <td align="left" width="30%" bgcolor="#CC9966"><label><fmt:message key="login.label.zip" /></label>:<span style="color: red">*</span></td>
														  <td align="left"><input type="text" name="zip" size="10"/></td>
												
													</tr>
													
													<tr>
											
														  <td align="left" width="30%" bgcolor="#CC9966"><label><fmt:message key="login.label.phone" /></label>:</td>
														  <td align="left"><input type="text" name="phone" size="30"/></td>
												
													</tr>
													
													
													
													
													
												</table>
											
										</td>	
									</tr>	
									
									
									<tr>
										<td>
											
														
											    <table align="center" border="1" cellpadding="1" cellspacing="1" width="100%">
													
													<tr> 
													
														<td align="left" colspan="2" width="30%" bgcolor="#CC9933"><label><fmt:message key="login.label.creditinfo" /></label></td>
														
														
													<tr>
													
													<tr> 
													
														<td align="left" width="30%" bgcolor="#CC9966"><label><fmt:message key="login.label.ctype" /></label>:<span style="color: red">*</span></td>
														<td align="left">

															<select name="cardtype" id="reg">
															  <% for(int x=0;x<5;x++){ %>
															  	<option value="<%=nl4.item(x).getFirstChild().getNodeValue() %>"><%=nl4.item(x).getFirstChild().getNodeValue() %></option>
															   <% } %>
														  </select>
														
														</td>	
														
													<tr>
													
							
													<tr>
													
														  <td align="left" width="30%" bgcolor="#CC9966"><label><fmt:message key="login.label.cnum" /></label>:<span style="color: red">*</span></td>
														  <td align="left"><input type="text" name="cardnumber" size="30"/></td> 
														
													</tr>
													
												
													
													<tr>
													
														  <td align="left" width="30%" bgcolor="#CC9966"><label><fmt:message key="login.label.cidnum" /></label>:<span style="color: red">*</span></td>
														  <td align="left">
														  
														  	<table>
														  	
														  		<tr>
														  		
														  			<td align="left"><input type="text" name="cardidnumber" size="10"/></td>
														  			<td align="left"><label><fmt:message key="login.label.four" /></label></td>
														  		
														  		</tr>
														  		<tr>
														  		
														  			<td></td>
														  			<td align="left"><img src="images/ccard.gif" alt="Credit Card"/></td>
														  		
														  		</tr>
														  	
														  	</table>
														  
														  </td>
													   	  
													</tr>
													
													<tr>
													
														  <td align="left" width="30%" bgcolor="#CC9966"><label><fmt:message key="login.label.vdate" /></label><span style="color: red">*</span></td>
														  <td align="left" id="reg">

															<select name="valid">
															  <% for(int x=0;x<21;x++){ %>
															  	<option value="<%=nl2.item(x).getFirstChild().getNodeValue() %>"><%=nl2.item(x).getFirstChild().getNodeValue() %></option>
															   <% } %>
														  </select>

														  </td>
												
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
													
														  <td align="center"><input type="hidden" name="action" value="processorder"></td>
												      	  <td align="center"><input type="submit" value="<fmt:message key="login.button.preorder" />" onclick="validateBillingPage()"></td>
												
													</tr>
													
											</table>
											
										</td>
									</tr>			
										
										
									
									</table>
								</form>
								
								</td>
								
							
								
							</tr>
							
							<!-- FOURTH ROW FOOTER 4 COLUMNS SPAN ............................................-->
							
							<jsp:include page="/footer.html"/>
							
						</table> 

</body>
</html>