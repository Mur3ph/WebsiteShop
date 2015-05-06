package my.project.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import my.project.services.OrderService;

public class RemoveCustAndOrderCommand implements Command{

	
		@Override
		public String execute(HttpServletRequest request, HttpServletResponse response) {
			
			String forwardToJsp = null;
			OrderService orderService = new OrderService();
			@SuppressWarnings("unused")
			int adminIsDeletingOrder = 0;
			
			// This command is for administration to delete the oreder that the customer made buying a product from the shop...
				
						String custId = request.getParameter("custId");
						String orderId = request.getParameter("orederId");
						
						if (custId != null && orderId != null){
							
							if (custId == ("") || orderId == ("")){
								
								
									forwardToJsp = "/invoice.jsp";
										
							}
							else 
							{
							
							//Use the UserServive class to DELETE ORDER.....
							adminIsDeletingOrder = orderService.deleteOrder(Integer.parseInt(custId), Integer.parseInt(orderId));

								
						
								forwardToJsp = "/invoice.jsp";
								
								
							
						}
							}else {
							
							
							forwardToJsp = "/error_page.html";	
							
						}
						
						
						
			
						return forwardToJsp;
	}

}
