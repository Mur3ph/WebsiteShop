package my.project.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import my.project.business_classes.Order;
import my.project.services.OrderService;


public class OrderCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String forwardToJsp = null;
		OrderService orderService = new OrderService();
		
		// Getting the Customer Details............................................................................

					String customerId = request.getParameter("custId");
					
					// getting the id of the customer that is ordering////////////////////////////
					// the validation below.................................
					
					if (customerId != null){
						
						if (customerId == (""))
						{
									forwardToJsp = "/process_order.jsp";
						}
						else 
						{
						
						//Use the UserServive class to register.....
						Order custIsOrdering = orderService.order(Integer.parseInt(customerId));

						if (custIsOrdering != null){
							
							//if customers order in we store the session id for client...
							HttpSession session = request.getSession();
							String clientSessionId = session.getId();
							session.setAttribute("registeredSessionId", clientSessionId);

							session.setAttribute("customer_order", custIsOrdering);

							forwardToJsp = "/receipt.jsp";
							
							
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
