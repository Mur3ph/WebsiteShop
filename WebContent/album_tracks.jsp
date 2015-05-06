<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
<%@ page import="my.project.business_classes.Track" %> 

<%@ page import="my.project.business_classes.User, my.project.business_classes.Product, java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Album Tracks</title>
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
						<td colspan="2"></td>
						<td colspan="2" align="right" ><a href="customer_cart.jsp">Cart</a>&nbsp;|&nbsp;<a href="UserController?action=logout">log out</a></td>
					</tr>
							
					<!-- HEADER FIRST ROW 4 COLUMN SPAN......................................................................................................-->
					
							<tr>
							
								<th colspan="4"><h1><img src="images/header2.jpg" alt="project_header"/></h1></th>
								
								
							</tr>
							
							<!-- INTERNAL LINKS SECOND ROW 4 COLUMN SPAN......................................................................................-->
							
							<tr id="links">
							
								<td colspan="4" id="horizontal">
									
									<ul>
										<li><a href="home.jsp">Home</a></li>
										<li><a href="register.jsp">Register</a></li>
										<li><a href="UserController?action=listAllProducts">Quick-Shop</a></li>
										<li><a href="login_index.jsp">Login</a></li>
										<li><a href="tickets.jsp">Tickets</a></li>
										
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
									
										<caption></caption>
										
											
												
												<%
												
													List<Track> tracks;
													tracks = (List)(request.getSession().getAttribute("tracks"));
													Track t2 = null;
													
													if (tracks != null){
													
													  for (Track t : tracks){ 
														  int x = 0;
														  x++;
												%>
										
										
												<tr>
													<td colspan="2">
													
														
														<form action="UserController" method="post">
														
															<table border="0" align="center" width="100%">
															
																<tr>
																
															
																	<td id="reg" align="left" width="50%"><label><%=t.getName()%></label></td>
																	<td id="reg" align="left" width=""><label><%=t.getDuration()%></label></td>
																	<td id="reg" align="right" width=""><a href="">Listen</a></td>
																	<!-- UserController?action=listCustomerOrder&custId=<%=t.getTrackId()%> -->
																</tr>
																
															</table>
														</form>
													</td>		
												</tr>
													
										
												<% 
												  		}
													}
												%>
													 <c:set var="prod" value="${sessionScope.product}"/>
													<tr bgcolor="#CCCCCC">
																  <td id="reg" align="center" width="50%" colspan=""><a href="UserController?action=listAllProducts">Back To Shop</a></td>
																  <td id="reg" align="center" width="50%" colspan=""><a href="UserController?action=viewAlbumInfo&album=${prod.productId}">Back To Album</a></td> 
																  
													</tr>
													
													<% %>
												
														
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