package my.project.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import my.project.business_classes.Customer;
import my.project.services.CustomerService;

public class SoetByCustCityCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		

		CustomerService custService = new CustomerService();
		String forwardToJsp = "";
		HttpSession session = request.getSession();
		
		//here im using the comparator to sort the albums way they are displayed by lowest price first etc................
		// could be done for every element of the album in the shop, if i had time....................................
		List<Customer> customers = new ArrayList<Customer>();
		
		customers = custService.sortByCity();

		//Put the list of albums into the session so that JSP(the View) can pick them up and display them...
		session.setAttribute("customers", customers);
		forwardToJsp = "/all_invoices.jsp";	

		return forwardToJsp;
		
	}

}
