package my.project.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import my.project.business_classes.OrderItem;
import my.project.services.OrderService;

public class OrderItemCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String forwardToJsp = null;
		OrderService orderService = new OrderService();
		
		// Getting the Customer Details............................................................................
			
					String productId = request.getParameter("prodId");
					String orderId = request.getParameter("orderId");
					
					
					// final part of the customer transaction where i get the corder and product id s and
					// place the order for the cutomer..................................
					
					
					// validation below...........................................
					if (productId != null && orderId != null){
						
						if (productId == ("") || orderId == ("")){
							
							
								forwardToJsp = "/end.html";
									
						}
						else 
						{
						
						//Use the UserServive class to order the album...................................
						OrderItem custIsOrdering = orderService.order1(Integer.parseInt(productId), Integer.parseInt(orderId));
						
						// making sure some thing is returned...............................
						
						if (custIsOrdering != null){
							
							//if the customer orders in we store the session id for client...
							HttpSession session = request.getSession();
							String clientSessionId = session.getId();
							session.setAttribute("registeredSessionId", clientSessionId);

							session.setAttribute("customer_order", custIsOrdering);

							forwardToJsp = "/end.html";
							
							
						}else{
							
							
							forwardToJsp = "/error_page.html";
							
						}
					}
						}else {
						
						
						forwardToJsp = "/error_page.html";	
						
					}
					
					
					
		
					return forwardToJsp;
					
	}

	}
