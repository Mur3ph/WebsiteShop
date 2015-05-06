package my.project.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import my.project.business_classes.Customer;
import my.project.services.CustomerService;

public class ListAllCustomersCommand implements Command{

	@Override
	public String execute(HttpServletRequest request,HttpServletResponse response) {

		CustomerService customerService = new CustomerService();
		String forwardToJsp = "";
		HttpSession session = request.getSession();
		
		//storing all the customers info in an arraylist for the admin to see and sort......................
		List<Customer> customers = new ArrayList<Customer>();
		customers = customerService.getAllCustomers();

		//Put the list of customers into the session so that JSP(the View) can pick them up and display them...
		session.setAttribute("customers", customers);
		
		forwardToJsp = "/all_invoices.jsp";	

		return forwardToJsp;
		
	}
	
}
