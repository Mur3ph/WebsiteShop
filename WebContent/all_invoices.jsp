<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
<%@ page import="my.project.business_classes.Customer" %>
     
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customers Paid</title>
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
														
														
														<table align="left" width="100%">
														
														
												
															<tr>
													
																<th id="reg" align="left" bgcolor="#CCCCCC" width="17%"><a href=""><label>Customer Id</label></a></th>
																<th id="reg" align="left" bgcolor="#CCCCCC" width="10%"><a href="UserController?action=sortByFName"><label>First Name</label></a></th>
																<th id="reg" align="left" bgcolor="#CCCCCC" width="18%"><a href="UserController?action=sortByLName"><label>Last Name</label></a></th>
																<th id="reg" align="left" bgcolor="#CCCCCC" width="14%"><a href=""><label>Address</label></a></th>
																<th id="reg" align="left" bgcolor="#CCCCCC" width="10%"><a href=""><label></label></a></th>
																<th id="reg" align="left" bgcolor="#CCCCCC" width="14%"><a href="UserController?action=sortByCity"><label>City</label></a></th>
																<th id="reg" align="left" colspan="2" bgcolor="#CCCCCC"><a href="UserController?action=sortByCounty"><label>County</label></a></th>
																
															</tr>
														
															<tr><td id="reg" colspan="7"></td></tr>
												
														</table>
														
													</td>	
												</tr>
											
												
												<%
												
													List<Customer> customers;
													customers = (List)(request.getSession().getAttribute("customers"));
													
													if (customers != null){
													
													  for (Customer c : customers){ 
														  int x = 0;
														  x++;
												%>
										
										
												<tr>
													<td>
													
														
														<form action="UserController" method="post">
														
															<table frame="box" align="center" width="90%">
															
																<tr>
																
															
																	<td id="reg" align="center"><input type="text" name="custId" value="<%=c.getCustomerId()%>" readonly="readonly" maxlength="5" size="5"/></td>
																	<td id="reg" align="center"><input type="text" name="fname" value="<%=c.getFirstName()%>" readonly="readonly" maxlength="10" size="10"/></td>
																	<td id="reg" align="center"><input type="text" name="lname" value="<%=c.getLastName()%>" readonly="readonly" maxlength="10" size="10"/></td>
																	<td id="reg" align="center"><input type="text" name="address1" value="<%=c.getAddress1()%>" readonly="readonly" maxlength="15" size="15"/></td>
																	<td id="reg" align="center"><input type="text" name="address2" value="<%=c.getAddress2()%>" readonly="readonly" maxlength="15" size="15"/></td>
																	<td id="reg" align="center"><input type="text" name="city" value="<%=c.getCity()%>" readonly="readonly" maxlength="5" size="5"/></td>
																	<td id="reg" align="center"><input type="text" name="county" value="<%=c.getCounty()%>" readonly="readonly" maxlength="5" size="5"/></td>
																	<td id="reg" align="center"><a href="UserController?action=listCustomerOrder&custId=<%=c.getCustomerId()%>">Invoice</a></td>
																	
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
															
																		
																		<td id="reg" align="center" colspan="8"><a href="admin_index.jsp">Back To Admin Home Page !</a></td>
																		
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