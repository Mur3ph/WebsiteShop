<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="language" 
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
	   scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename = "my.project.languages.labels" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Index Page</title>

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
							
								
								<td colspan="4">
								
									<table align="center" frame="box" width="80%">
									
										<tr>
									
											<td id="reg" colspan="5"></td>
										
										</tr>
										
										<tr bgcolor="#CC9933"> 
											<th colspan="5" align="center"><label><fmt:message key="login.button.login" /></label></th>
										<tr>
										
										<tr>
										
											<th></th>
											<th id="reg" align="center" bgcolor="#CC9966"><label><fmt:message key="login.label.admin" /></label></th>
											<th></th>
											<th id="reg" align="center" bgcolor="#CC9966"><label><fmt:message key="login.label.user" /></label></th>
											<th></th>
										
										</tr>
										
										
										<tr>
										
											<td id="reg"></td>
											<td id="" align="center"><a href="admin_login.jsp"><img onmouseover="this.src='images/admin_login2.png';" onmouseout="this.src='images/admin_login1.png';" src="images/admin_login1.png" alt="admin login header" height="200" width="200"/></a></td>
											<td id="reg" width="20%"></td>
											<td id="" align="center"><a href="user_login.jsp"><img onmouseover="this.src='images/user_login1.jpg';" onmouseout="this.src='images/user_login.png';" src="images/user_login.png" alt="customer login header" height="200" width="200"/></a></td>
											<td id="reg"></td>
										
										</tr>
										
										<tr>
									
											<td id="reg" colspan="5"></td>
										
										</tr>
									
									</table>
								
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