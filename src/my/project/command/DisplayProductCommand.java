package my.project.command;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import my.project.business_classes.Product;
import my.project.services.ProductService;


public class DisplayProductCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		String forwardToJsp = null;
		ProductService productService = new ProductService();
		
		// Order a product...................................................
		
		//The user wants to buy an item............................................................................
		
		String prod_code = request.getParameter("code");
		
		// Validation.................................
		if (prod_code != ""){
			
			//Use the ProductServive class to order a product.....................................................
			Product productIsBeingBought = productService.productOrder1(prod_code);
			
			// checking to see if it returns something...........................................................
				if (productIsBeingBought != null){
					
					//if user orders, we store the session id for client..............................................
					
//					ArrayList<Product> customerProuctList = null;
//					customerProuctList = new ArrayList<Product>();
//					customerProuctList.add(productIsBeingBought);
					
					HttpSession session = request.getSession();
					String clientSessionId = session.getId();
					session.setAttribute("registeredSessionId", clientSessionId);

					session.setAttribute("product", productIsBeingBought);
//					request.setAttribute("testattribute", customerProuctList);

					forwardToJsp = "/customer_cart.jsp";
					
					
				}else{
					
					
					forwardToJsp = "/quick_shop.jsp";
					
				}
			}else {
				
				
				forwardToJsp = "/quick_shop.jsp";	
				
			}

		
		

	       
		return forwardToJsp;
	}
	
	

}
