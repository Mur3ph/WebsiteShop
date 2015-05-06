<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<c:set var="language" 
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
	   scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename = "my.project.languages.labels" />  

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User/Customer Login</title>
			
		
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
						<td colspan="2"></td>
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
							
							<!-- ADDED NEW ROW FOR A LOGGING OUT BUTTON........................................ -->
							
							<tr>
							
								<td colspan="4" align="right"></td>
								
							</tr>
					
							
							<!-- THIRD ROW 4 COLUMNS MIGHT SPAN ON SOME PAGES FOR ANOTHER TABLE GOING IN HERE... -->
							
							<tr>
							
								<td colspan="4">
								
									<fieldset>
									
										<legend>
											<fmt:message key="login.label.clogin" />
										</legend>
											<form action="UserController" method="post" name="myLoginForm" onsubmit="return validateLoginForm()">
												<!-- style="text-align=center;" -->
												<table align="center">
												
													<tr><td colspan="4"><span style="color: red"><fmt:message key="login.label.validate1" /> </span></td></tr>
												
													<tr>
														<td id="reg" align="left"></td>
														<td id="reg" align="right"><label><fmt:message key="login.label.username" />:</label></td>
														<td id="reg"><input type="text" name="username" maxlength="20" size="40"/></td>
														<td id="reg"></td>
													</tr>
													
													<tr>
														<td id="reg" align="left"></td>
														<td id="reg" align="right"><label><fmt:message key="login.label.password" />:</label></td>
														<td id="reg"><input type="password" name="password" maxlength="20" size="40"/></td>
														<td id="reg"></td>
													</tr>
													
													
													
													<tr>
														<td align="left" id="reg"><label></label></td>
														<td><input type="hidden" name="action" value="userlogin"></td>
											      		<td><input type="submit" value="<fmt:message key="login.button.login" />"></td>
														<td id="reg"></td>
													</tr>
												</table>
											</form>	
										</fieldset>
													
								
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