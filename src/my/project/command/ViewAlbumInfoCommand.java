package my.project.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import my.project.business_classes.Product;
import my.project.services.ProductService;

public class ViewAlbumInfoCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String forwardToJsp = null;
		ProductService productService = new ProductService();
		
		// particular info for athe albums desc etc...................................................
		
		//............................................................................
		
		String prod_code = request.getParameter("album");
		
		if (prod_code != ""){
			
			//Use the ProductServive class to get product...info..................................................
			Product productIsBeingViewed = productService.productView(Integer.parseInt(prod_code));

				if (productIsBeingViewed != null){
					
					//if  albums there which it is, we store the session id for client..............................................
					
//					ArrayList<Product> customerProuctList = null;
//					customerProuctList = new ArrayList<Product>();
//					customerProuctList.add(productIsBeingBought);
					
					HttpSession session = request.getSession();
					String clientSessionId = session.getId();
					session.setAttribute("registeredSessionId", clientSessionId);

					session.setAttribute("product", productIsBeingViewed);
//					request.setAttribute("testattribute", customerProuctList);

					forwardToJsp = "/album.jsp";
					
					
				}else{
					
					
					forwardToJsp = "/quick_shop.jsp";
					
				}
			}else {
				
				
				forwardToJsp = "/quick_shop.jsp";	
				
			}

		
		

	       
		return forwardToJsp;
	}

}
