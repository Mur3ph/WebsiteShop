package my.project.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import my.project.business_classes.Order;
import my.project.services.OrderService;

public class ListCustomerOrderCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		OrderService orderService = new OrderService();
		String forwardToJsp = "";
		HttpSession session = request.getSession();
		// admin getting the customers id............................
		String id = request.getParameter("custId");
		// validation.....................................
		if (id != null ){
			
		
		//admin checking to see what a certanin customer with this id bought..................
			//Using advanced sql join to retrieve the info......................................
		List<Order> orders = new ArrayList<Order>();
		orders = orderService.getAllCustomerOrders(Integer.parseInt(id));

		
		//Put the list of customers buying stuff into the session so that JSP(the View) can pick them up and display them...
		session.setAttribute("orders", orders);
		
		forwardToJsp = "/invoice.jsp";	

		}else{
			
			
			forwardToJsp = "/error_page.html";
			
		}
	
	
		
	
		
		return forwardToJsp;
		
	}

}
