<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administration Index</title>
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
										<li><a href="UserController?action=listAllTickets">Tickets</a></li>
										
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
										
											<tr bgcolor="#CC9966"> 
												<th colspan="2" align="center">Customer Services</th>
											<tr>
										
												<tr>
													<td rowspan="3">	
														
														<form action="UserController" method="post">	
															<table align="left" width="50%">
															
																	
																	<tr bgcolor="#CC9933"> 
															
																		<td>
									
																			<ul>
																				<li><a href="UserController?action=listAllAdminProducts">Remove Albums</a></li>
																				<li><a href="UserController?action=listAllNewProducts">New Releases</a></li>
																				<li><a href="UserController?action=listAllTickets">Tickets</a></li>
																				
																			</ul> 
							
																		</tr>
																		
																	
															</table>
														</form>	
													</td>	
												</tr>
											
													
												<tr>
													<td>	
														
														<form action="UserController" method="post">	
															<table align="center" width="100%">
															
																	
																	<tr > 
															
																		<td id="reg" align="center"><input type="hidden" name="action" value="records"></td>
																		<td id="reg" align="center" bgcolor="#CC9933"><input type="submit" value="View Records..."></td>
							
																	</tr>
																		
																	
															</table>
														</form>	
													</td>	
												</tr>
												
												<tr>
													<td>	
														<form action="UserController" method="post">	
															<table align="center" width="100%">
															
																	
																	<tr > 
															
																		<td id="reg" align="center"><input type="hidden" name="action" value="invoices"></td>
																		<td id="reg" align="center" bgcolor="#CC9933"><input type="submit" value="Review Invoices..."></td>
																		
																	</tr>
																		
																	
															</table>
														</form>	
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