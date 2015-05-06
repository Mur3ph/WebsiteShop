package my.project.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import my.project.business_classes.Customer;
import my.project.services.CustomerService;

public class GetCustomerDetailsForOrderCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String forwardToJsp = null;
		CustomerService customerService = new CustomerService();
		
		// Getting the Customer Details............................................................................

					String firstname = request.getParameter("firstname");
					String lastname = request.getParameter("lastname");
					String address1 = request.getParameter("address1");
					String address2 = request.getParameter("address2");
					String city = request.getParameter("city");
					String county = request.getParameter("county");
					String country = request.getParameter("country");
					String zip = request.getParameter("zip");
					String phone = request.getParameter("phone");
					String cardtype = request.getParameter("cardtype");
					String cardnumber = request.getParameter("cardnumber");
					String cardidnumber = request.getParameter("cardidnumber");
					String valid = request.getParameter("valid");
					
					// Validation..........................................................
					
					if (firstname != null && lastname != null && address1 != null && address2 != null && city != null && county != null && country != null && zip != null && phone != null && cardtype != null && cardnumber != null && cardidnumber != null && valid != null){
						
						//More and improved Validation so that it stays on this page until properly filled out.....................................................................................................................................................................................................................................
						
						if (firstname.equals("") || lastname.equals("") || address1.equals("") || address2.equals("") || city.equals("") || county.equals("") || country.equals("") || zip.equals("") || phone.equals("") || cardtype.equals("") || cardnumber.equals("") || cardnumber.length() != 15 || cardidnumber.equals("") || cardidnumber.length() != 4 || valid.equals(""))
						{
									forwardToJsp = "/billing_info.jsp";
						}
						else 
						{
						
						//Use the UserServive class to collect the personal and credit info of the customer.....................
						Customer custIsOrdering = customerService.customerDetails(firstname, lastname, address1, address2, city, county, country, zip, phone, cardtype, cardnumber, cardidnumber, valid);
						
						// making sure its not empty..........................................................
						if (custIsOrdering != null){
							
							//if user customer info is coorrect we store the session id for client...
							HttpSession session = request.getSession();
							String clientSessionId = session.getId();
							session.setAttribute("registeredSessionId", clientSessionId);

							session.setAttribute("customer", custIsOrdering);

							forwardToJsp = "/process_order.jsp";
							
							
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
