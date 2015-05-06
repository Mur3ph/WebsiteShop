<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
<%@ page import="my.project.business_classes.Customer" %>
<%@ page import="my.project.business_classes.Order" %>
<%@ page import="my.project.business_classes.OrderItem" %>
<%@ page import="my.project.business_classes.Product" %>
     
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
<title>Invoice</title>
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
								
								<form >
									<table align="center"  border="0" cellspacing="0" width="90%">
									
										<caption></caption>
										
										
											
												
												<tr>
													<td>
														
														
														<table align="center" width="100%">
														
														
												
															<tr>
													
																<th id="reg" align="left" bgcolor="#CCCCCC" width="17%"><label>Customer Id</label></th>
																<th id="reg" align="left" bgcolor="#CCCCCC" width="10%"><label>Order Id</label></th>
																<th id="reg" align="left" bgcolor="#CCCCCC" width="24%"><label>Date Ordered</label></th>
																<th id="reg" align="left" bgcolor="#CCCCCC" width="14%"><label>Album</label></th>
																<th id="reg" align="left" bgcolor="#CCCCCC" width="10%"><label>Price</label></th>
																<th id="reg" align="left" bgcolor="#CCCCCC" width="14%"><label>Transaction Complete</label></th>
																
															</tr>
														
															<tr><td id="reg" colspan="7"></td></tr>
												
														</table>
														
													</td>	
												</tr>
											
												
												<%
												
													List<Order> orders;
													orders = (List)(request.getSession().getAttribute("orders"));
													
													if (orders != null){
													
													  for (Order o : orders){ 
														  int x = 0;
														  x++;
												%>
										
										
												<tr>
													<td>
													
														
														<form action="UserController" method="post">
														
															<table frame="box" align="center" width="90%">
															
																<tr>
																
																	<td id="reg" align="center"><input type="text" name="custId" value="<%=o.getOrderCustId()%>" readonly="readonly" maxlength="2" size="2"/></td>
																	<td id="reg" align="center"><input type="text" name="orederId" value="<%=o.getOrderId()%>" readonly="readonly" maxlength="2" size="2"/></td>
																	<td id="reg" align="center"><input type="text" name="date" value="<%=o.getDate()%>" readonly="readonly" maxlength="10" size="10"/></td>
																	<td id="reg" align="center"><input type="text" name="product" value="<%=o.getProductNameOrdered()%>" readonly="readonly" maxlength="25" size="25"/></td>
																	<td id="reg" align="center"><input type="text" name="price" value="<%=o.getProductPriceOrdered()%>" readonly="readonly" maxlength="10" size="10"/></td>
																	<td id="reg" align="center"><label><span style="color: red">PAID</span></label></td>
																	
																</tr>
																
																
															</table>
														</form>
													</td>		
												</tr>
													
										
												
												<tr>
													<td>	
														<form action="UserController" method="post">	
															<table align="center" width="50%">
															
																	
																	<tr bgcolor=""> 
															
																		<td id="reg" align="center"><input type="hidden" name="custId" value="<%=o.getOrderCustId()%>"></td>
																		<td id="reg" align="center"><input type="hidden" name="orederId" value="<%=o.getOrderId()%>"></td>
																		<td id="reg" align="center"><input type="hidden" name="action" value="remove"></td>
																		<td id="reg" align="left"><input type="submit" value="Remove"></td>
																		
																	</tr>
																		
																	
															</table>
														</form>	
													</td>	
												</tr>
												
												<% 
												  		}
													}
												%>
												
												<tr>
													<td>	
														<form action="UserController" method="post">	
															<table align="center" width="50%">
															
																	
																	<tr bgcolor="#CCCCCC"> 
															
																		<td id="reg" align="center"><input type="hidden" name="action" value="invoices"></td>
																		<td id="reg" align="center"><input type="submit" value="Back To Invoices..."></td>
																		
																	</tr>
																		
																	
															</table>
														</form>	
													</td>	
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