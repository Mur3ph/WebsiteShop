package my.project.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import my.project.business_classes.Ticket;
import my.project.services.ProductService;

public class ListAllTicketsCommand implements Command{



	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
	

		ProductService productService = new ProductService();
		String forwardToJsp = "";
		HttpSession session = request.getSession();
		
		//getting a list of tickets for some festival all sold out though...............
		// just put there to take the javascript page i had for previous ..................
		List<Ticket> tickets = new ArrayList<Ticket>();
		tickets = productService.getAllTickets();

		//Put the list of users into the session so that JSP(the View) can pick them up and display them...
		session.setAttribute("tickets", tickets);
		forwardToJsp = "/tickets.jsp";	

		return forwardToJsp;
		
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	

}
