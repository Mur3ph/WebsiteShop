<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
<%@ page import="my.project.business_classes.Message" %>    
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Deleted Profiles</title>
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
										
										
											
												
												<tr>
													<td>
														
														
														<table align="left" width="90%">
														
														
												
															<tr>
													
																<th id="reg" align="left" bgcolor="#CCCCCC" width="17%"><label>Customer Id</label></th>
																<th id="reg" align="left" bgcolor="#CCCCCC" width="14%"><label>Message</label></th>
																<th id="reg" align="left" bgcolor="#CCCCCC" width="10%"><label>First Name</label></th>
																<th id="reg" align="left" bgcolor="#CCCCCC" width="24%"><label>Last Name</label></th>
																<th id="reg" align="left" bgcolor="#CCCCCC" width="14%"><label>Date</label></th>
																
																
																
															</tr>
														
															<tr><td id="reg" colspan="7"></td></tr>
												
														</table>
														
													</td>	
												</tr>
											
												
												<%
												
													List<Message> messages;
												messages = (List)(request.getSession().getAttribute("messages"));
													
													if (messages != null){
													
													  for (Message m : messages){ 
														  int x = 0;
														  x++;
												%>
										
										
												<tr>
													<td>
													
														
														<form action="UserController" method="post">
														
															<table frame="box" align="center" width="100%">
															
																<tr>
																
																	
																	
																	<td id="reg" align="left"><label><%=m.getMessageId()%></label></td>
																	<td id="reg" align="left"><label><%=m.getMessage()%></label></td>
																	<td id="reg" align="left"><label><%=m.getFirst()%></label></td>
																	<td id="reg" align="left"><label><%=m.getLast()%></label></td>
																	<td id="reg" align="left"><label><%=m.getDate()%></label></td>
																	<td id="reg" align="left"><a href="">Record</a></td>
																	<!-- UserController?action=listCustomerOrder&custId=<%=m.getMessageId()%> -->
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