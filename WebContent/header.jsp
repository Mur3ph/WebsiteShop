
<%@ page import="my.project.business_classes.User" %>
		<!-- START OF OUTER TABLE ......................width="80%".........................-->
				
			<table border="0" align="center" >
					
					
					<!-- ADDED NEW FIRST ROW 4 COLUMN SPAN ADDED ABOVE HEADER......................................................................................................-->
					
					<tr bgcolor="#666666">
						<td width="10%"><label><a href="welcome.jsp">${user.userName}</a></label></td>
						<td width="70%">&nbsp;</td>
						<td width="20%" colspan="2" align="right" ><a href="customer_cart.jsp">Cart</a>&nbsp;|&nbsp;<a href="UserController?action=logout">log out</a></td>
					</tr>
					
							
					<!-- HEADER FIRST ROW 4 COLUMN SPAN...............................................-->
					
							<tr>
								<th align="center"><label>The Band</label></th>
								<th colspan="3" align="right"><h1><img src="images/header2.jpg" alt="project_header"/></h1></th>
								
								
							</tr>
							
							<!-- INTERNAL LINKS SECOND ROW 4 COLUMN SPAN..................................-->
							
							<tr id="links">
							
								<td colspan="4" id="horizontal"  bgcolor="#0066CC">
									
									<ul>
										<li><a href="home.jsp">Home</a></li>
										<li><a href="register.jsp">Register</a></li>
										<li><a href="UserController?action=listAllProducts">Quick-Shop</a></li>
										<li><a href="login_index.jsp">Login</a></li>
										<li><a href="tickets.jsp">Tickets</a></li>
										
									</ul> 
									
								</td>
								
								
							</tr>
							
							<!-- ADDED NEW ROW FOR A LOGGING OUT BUTTON........................................................................................... -->
							
							<tr>
							
								<td colspan="4" align="right"></td>
								
							</tr>
					
							
							