package my.project.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import my.project.business_classes.Product;
import my.project.services.ProductService;

public class ListAllProductsCommand implements Command {

	@Override
	public String execute(HttpServletRequest request,HttpServletResponse response) {

		ProductService productService = new ProductService();
		String forwardToJsp = "";
		HttpSession session = request.getSession();
		
		//get a list of all the albums for the shop................................................
		List<Product> products = new ArrayList<Product>();
		products = productService.getAllProducts();

		//Put the list of albums into the session so that JSP(the View) can pick them up and display them...
		session.setAttribute("products", products);
		forwardToJsp = "/quick_shop.jsp";	

		return forwardToJsp;
		
	}

}
