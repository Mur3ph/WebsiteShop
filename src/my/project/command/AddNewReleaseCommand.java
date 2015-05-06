package my.project.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import my.project.business_classes.Product;
import my.project.services.ProductService;

public class AddNewReleaseCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
	

		String forwardToJsp = null;
		ProductService prodService = new ProductService();
		
		// Admin Getting the Album Details from new releases to place a new album in the shop............................................................................

					String cover = request.getParameter("cover");
					String code = request.getParameter("code");
					String name = request.getParameter("name");
					String genre = request.getParameter("genre");
					String desc = request.getParameter("desc");
					String price = request.getParameter("price");
					
					// Two types of Validation here....................................................
					//First one just check that the value isn't null/empty.............................
					
					if (cover != null && code != null && name != null && genre != null && desc != null && price != null){
						
						// Second Validation is more important...............................................
						
						if (cover.equals("") || code.equals("") || name.equals("") || genre.equals("") || desc.equals("") || price.equals(""))
						{
									forwardToJsp = "/admin_new_releases.jsp";
						}
						else 
						{
						
						//Use the UserServive class to register.....
						Product adminAddingAlbumToShop = prodService.albumDetails(cover, code, name, genre, desc, Double.parseDouble(price));

						if (adminAddingAlbumToShop != null){
							
							//if insert is successful we store the session id for client.........................
							HttpSession session = request.getSession();
							String clientSessionId = session.getId();
							session.setAttribute("registeredSessionId", clientSessionId);

							session.setAttribute("product", adminAddingAlbumToShop);

							forwardToJsp = "/admin_new_releases.jsp";
							
							
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
