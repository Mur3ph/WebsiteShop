package my.project.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import my.project.business_classes.Product;
import my.project.services.ProductService;

public class ListAllNewReleasesCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		ProductService productService = new ProductService();
		String forwardToJsp = "";
		HttpSession session = request.getSession();
		
		//for admin use to sort what goes to the customer shop or not......................
		//gets a list of new releases..........................................
		List<Product> products = new ArrayList<Product>();
		products = productService.getAllNewProducts();

		//Put the list of newly released albums into the session so that JSP(the View) can pick them up and display them...
		session.setAttribute("products", products);
		forwardToJsp = "/admin_new_releases.jsp";	

		return forwardToJsp;

		
	}

}
