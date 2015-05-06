<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
<%@ page import="my.project.business_classes.Product" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page import="java.util.*" %>
    
    

<c:set var="language" 
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
	   scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename = "my.project.languages.labels" />

    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Shop Page</title>

<!-- LINK TO MY EXTERNAL CSS FILE ..........................................................................................................................-->
				<link href="project.css" rel="stylesheet" type="text/css"/>
				
		<!-- LINK TO MY EXTERNAL JAVASCRIPT FILE ...........................................................................................................-->		
				<script src="javascript.js"></script>

</head>
<body>

		<!-- START OF OUTER TABLE ...........................................................................................................................-->
				
					<table border="0" align="center">
					
					<!-- ADDED NEW FIRST ROW 4 COLUMN SPAN ADDED......................................................................................................-->
					
					<tr bgcolor="#666666">
					
						<td></td>
						
						<td>
						
						</td>
						
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
										<li><a href="UserController?action=listAllTickets"><fmt:message key="login.label.tickets" /></a></li>
										
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
									<table align="center"  border="0" cellspacing="0" width="90%">
									
										<caption><h1> Albums </h1></caption>
										
										
											
												
												<tr>
													<td>
														
														
														<table align="left" width="90%">
														
														
												
															<tr>
													
																<th id="reg" align="left" bgcolor="#CCCCCC" width="20%"><label for="username"><fmt:message key="login.label.cover" /></label></th>
																<th id="reg" align="left" bgcolor="#CCCCCC" width="12%"><label><fmt:message key="login.label.code" /></label></th>
																<th id="reg" align="left" bgcolor="#CCCCCC" width="27%"><label><fmt:message key="login.label.name" /></label></th>
																<th id="reg" align="left" bgcolor="#CCCCCC" width="16%"><label><fmt:message key="login.label.genre" /></label></th>
																<th id="reg" align="left" bgcolor="#CCCCCC" width="14%"><label><fmt:message key="login.label.desc" /></label></th>
																<th id="reg" align="left" bgcolor="#CCCCCC" width="14%"><a href="UserController?action=sortByPrice"><label><fmt:message key="login.label.price" /></label></a></th>
																<th id="reg" align="left" colspan="2" bgcolor=""><label>&nbsp;</label></th>
																
															</tr>
														
															<tr><td id="reg" colspan="7"></td></tr>
												
														</table>
														
													</td>	
												</tr>
											
												
												<%
												
													List<Product> products;
													products = (List)(request.getSession().getAttribute("products"));
													
													if (products != null){
													
													  for (Product p : products){ 
														  int x = 0;
														  x++;
												%>
										
										
												<tr>
													<td>
													
														
														<form action="UserController" method="post">
														
															<table frame="box" align="center" width="100%">
															
																<tr>
																
																	<td id="reg" align="center"><a href="UserController?action=viewAlbumInfo&album=<%=p.getProductId()%>"><img src="<%=p.getCover()%>" name="<%=p.getCover()%>" height="100" width="100"/></a></td>
																	<td id="reg" align="center"><input type="text" name="code" value="<%=p.getCode()%>" readonly="readonly" maxlength="5" size="5"/></td>
																	<td id="reg" align="center"><input type="text" name="name" value="<%=p.getName()%>" readonly="readonly" maxlength="20" size="20"/></td>
																	<td id="reg" align="center"><input type="text" name="genre" value="<%=p.getGenre()%>" readonly="readonly" maxlength="10" size="10"/></td>
																	<td id="reg" align="center"><input type="text" name="description" value="Indie Music" readonly="readonly" maxlength="10" size="10"/></td>
																	<td id="reg" align="center"><input type="text" name="price" value="<%=p.getPrice()%>" readonly="readonly" maxlength="5" size="5"/></td>
																	<td id="reg" align="center"><a href="UserController?action=removeAlbum&id=<%=p.getProductId()%>">Remove</a></td>
																	
																	
																</tr>
																
															</table>
														</form>
													</td>		
												</tr>
													
										
												<% 
												  		}
													}
												%>
													
													<tr bgcolor="#CCCCCC"> 
															
																		
																		<td id="reg" align="center" colspan="6"><a href="admin_index.jsp">Back To Admin Home Page !</a></td>
																		
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