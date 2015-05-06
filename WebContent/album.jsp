<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
<%@ page import="my.project.business_classes.Product" %>
<%@ page import="my.project.business_classes.Review" %>


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
<title>Album Info Page</title>

<!-- LINK TO MY EXTERNAL CSS FILE ..........................................................................................................................-->
				<link href="project.css" rel="stylesheet" type="text/css"/>
				
		<!-- LINK TO MY EXTERNAL JAVASCRIPT FILE ...........................................................................................................-->		
				<script src="javascript.js"></script>

</head>
<body>

		<!-- START OF OUTER TABLE ...........................................................................................................................-->
				
					<table border="0" align="center" width="60%">
					
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
										<li><a href="tickets.jsp"><fmt:message key="login.label.tickets" /></a></li>
										
									</ul> 
									
								</td>
								
								
							</tr>
							
							<!-- ADDED NEW ROW FOR A LOGGING OUT BUTTON......................<a href="UserController?action=viewAlbumInfo&album="></a>................................................................ -->
							
							<tr>
							
								<td colspan="4" align="right"></td>
								
							</tr>
					
							
							<!-- THIRD ROW 4 COLUMNS MIGHT SPAN ON SOME PAGES FOR ANOTHER TABLE GOING IN HERE... -->
							
							<tr >
							
								
								<td colspan="4" width="40%" bgcolor="#CCCCFF">
								
								<form action="UserController" method="post">
									<table id="" align="center"  border="0" cellspacing="0" width="70%">
									
										<caption> Catalogue </caption>
											
												<c:set var="item" value="${sessionScope.product}"/>
												
													<tr>
																  <td id="reg" align="left"><a href="UserController?action=track&id=${item.productId}"><img src="<c:out value="${item.cover}" />" name="<c:out value="${item.cover}" />" height="250" width="250"/></a></td>
																  <td align="left"><c:out value="${item.name}" /><br/><c:out value="${item.genre}" /><br/><c:out value="${item.price}" /></td>
																 	 
														
													</tr>
													
													<tr>
																  <td id="reg" align="left" colspan="2"><p><c:out value="${item.description}" /></p></td> 
														
													</tr>
													
													<tr>
																  <td id="reg" align="center" width="50%"><a href="UserController?action=listAllProducts">Back To Shop</a></td> 
																  <td id="reg" align="center" width="50%"><a href="UserController?action=addtocart&code=${item.code}">Buy</a></td>
													</tr>
														
												
									
									</table>
								</form>
								
							</td>
								
							
								
					</tr>
					
					<!-- THIRD ROW 5 COLUMNS MIGHT SPAN ON SOME PAGES FOR ANOTHER TABLE GOING IN HERE... -->
							
							<tr >
							
								
								<td colspan="4" width="40%" bgcolor="#CCCCFF">
								
								<form action="UserController" method="post">
									<table id="" align="center"  border="0" cellspacing="0" width="70%">
									
										
											
												<c:set var="item" value="${sessionScope.product}"/>
												
													<tr>
																  <td id="reg" align="left"><label>Comments</label></td>
																  <td align="left"><input type="hidden" name="code" value="${item.productId}"></td>
																 	 
														
													</tr>
													
													<tr>
																  <td id="reg" align="left" colspan="2"><textarea rows="3" cols="70" name="comment">Comment...</textarea></td> 
														
													</tr>
													
													<tr>
													
													
																  <td id="reg" align="center" width="50%"><input type="hidden" name="action" value="post"></td> 
																  <td id="reg" align="right" width="50%"><input type="submit" value="Post"></td>
													</tr>
													
													
													<c:forEach var="rev2" items="${sessionScope.reviews}">
														<tr id="reg">
														  <td colspan="2">
														  				<table id="reg" align="center" frame="box" width="95%">
														  						<tr>
														  							<td width="80%"><c:out value="${rev2.comment}" /></td>
														  							 <td align="left" width="20%"><c:out value="${rev2.date}" /></td> 
														  							  
														  						</tr>
														  				</table>
														  
														</tr>  
													</c:forEach>
														
												
									
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