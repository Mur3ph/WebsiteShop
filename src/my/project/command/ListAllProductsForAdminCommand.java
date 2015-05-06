package my.project.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import my.project.business_classes.Product;
import my.project.services.ProductService;

public class ListAllProductsForAdminCommand implements Command{
	
	

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
	
		
		ProductService productService = new ProductService();
		String forwardToJsp = "";
		HttpSession session = request.getSession();
		
		//a list of the albums for the admin that are als in the customer shop....................
		//but the admin can remove any of theses by deleting them or removeing any of them..................
		List<Product> products = new ArrayList<Product>();

		products = productService.getAllProducts();

		//Put the list of albums into the session so that JSP(the View) can pick them up and display them...
		session.setAttribute("products", products);
		forwardToJsp = "/admin_shop.jsp";	

		return forwardToJsp;

		
	}
	
}
