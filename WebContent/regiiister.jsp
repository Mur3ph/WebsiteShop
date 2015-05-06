<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
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
<title>Registration Page</title>

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
										<li><a href="UserController?action=listAllTickets"><fmt:message key="login.label.tickets" /></a></li>
										
									</ul> 
									
								</td>
								
								
							</tr>
							
							<!-- Added extra row, for some text..............................................................................-->
							
							<tr>
							
								<td colspan="4" id="reg">
									
									
								</td>
								
								
							</tr>
							
							<!-- THIRD ROW 4 COLUMNS MIGHT SPAN ON SOME PAGES FOR ANOTHER TABLE GOING IN HERE... -->
							
				
							<tr>
							
								
								<td colspan="4">
								
									<fieldset>
									
										<legend>
											<b><fmt:message key="login.button.reg" /></b>
										</legend>
										<!--  action="UserController" method="post" name="myRegForm" ... onsubmit="return validateRegForm()"-->
										
											<form action="UserController" method="post" name="myRegForm">
												<!-- style="text-align=center;" -->
												<table width="79%">
												
														<tr><td colspan="4"><span style="color: red">* User name Available *</span></td></tr>
												
														<tr>							
															<td id="reg" align="left" bgcolor="#CC9966" width="30%"><label><fmt:message key="login.label.username" /><span style="color: red">*</span>:</label></td>
															<td id="reg" align="left"><input type="text" id="username" name="username" maxlength="40" size="40"/></td>
															<td id="reg" align="left"><input type="hidden" name="" value=""></td>
															<td id="reg" align="left"><input type="button" value="<fmt:message key="login.button.avail" />"></td>			
														</tr>
												
												
													
														<tr>
															<td id="reg" align="left" bgcolor="#CC9966"><label><fmt:message key="login.label.firstname" /><span style="color: red">*</span>:</label></td>
															<td id="reg" align="left"><input type="text" name="firstname" maxlength="40" size="40"/></td>
															<td id="reg"></td>
															<td id="reg"></td>
														</tr>
														
													
														<tr>
															<td id="reg" align="left" bgcolor="#CC9966"><label><fmt:message key="login.label.lastname" /><span style="color: red">*</span>:</label></td>
															<td id="reg" align="left"><input type="text" name="lastname" maxlength="40" size="40"/></td>
															<td id="reg"></td>
															<td id="reg"></td>
														</tr>
														
														<tr>
															<td id="reg" align="left" bgcolor="#CC9966"><label><fmt:message key="login.label.email" /><span style="color: red">*</span>:</label></td>
															<td id="reg" align="left"><input type="text" name="email" maxlength="40" size="40"/></td>
															<td id="reg"></td>
															<td id="reg"></td>
														</tr>
											
														<tr>
														
													
														<tr>
															<td align="left" id="reg" bgcolor="#CC9966"><label><fmt:message key="login.label.password" /><span style="color: red">*</span>:</label></td>
															<td align="left" id="reg"><input type="password" name="password" id="password" maxlength="40" size="40"/></td>
															<td id="reg"><a href=""></a>
															</td>
															<td id="reg"></td>
														</tr>
														
														<tr>
															<td align="left" id="reg" bgcolor="#CC9966"><label><fmt:message key="login.label.repassword" /><span style="color: red">*</span>:</label></td>
															<td align="left" id="reg"><input type="password" name="repassword" id="repassword" maxlength="40" size="40"/></td>
															<td id="reg"><a href=""></a>
															</td>
															<td id="reg"></td>
														</tr>
														
														
														<tr>
															
															<td colspan="2"><input type="hidden" name="action" value="registration"></td>
												      		<td align="left" id="reg" colspan="2"><input type="submit" value="<fmt:message key="login.button.reg" />" onclick="validateRegForm()"></td>
															
														</tr>
														
												</table>
											
											</form>
									
									</fieldset>
								
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