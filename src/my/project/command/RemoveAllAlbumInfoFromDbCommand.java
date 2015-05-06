package my.project.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.project.services.ProductService;

public class RemoveAllAlbumInfoFromDbCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		
		String forwardToJsp = null;
		ProductService productService = new ProductService();
		@SuppressWarnings("unused")
		int adminIsDeletingAlbum = 0;
		
		// This command is for administration to delete an album from the customers shop.................................
			
					String prodId = request.getParameter("id");
					
					if (prodId != null){
						
						if (prodId == ("")){
							
							
								forwardToJsp = "/admin_shop.jsp";
									
						}
						else 
						{
						
						
						adminIsDeletingAlbum = productService.deleteAlbumInfo(Integer.parseInt(prodId));

							
					
							forwardToJsp = "/admin_shop.jsp";
							
							
						
					}
						}else {
						
						
						forwardToJsp = "/error_page.html";	
		
		
				}
					return forwardToJsp;
					
	}
	
}
	
	


