package my.project.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import my.project.business_classes.User;
import my.project.services.UserService;

public class DeleteUserCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String forwardToJsp = null;
		UserService userService = new UserService();
		// getting the user info that is being delete by the user..........................................
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		
		// just a bit of validating here...................................................................
		if (firstname != "" && lastname != "" && email != "" && username != ""){
			
			// sending info to the service and dao, could have simplified theis a liittle by just using an integer instead............
			User userIsLeaving = userService.delete(firstname, lastname, email, username);

			if (userIsLeaving != null){
			
				forwardToJsp = "/deleted_user.jsp";
				
				
			}else{
				
				
				forwardToJsp = "/error_page.html";
				
			}
		}else {
			
			
			forwardToJsp = "/error_page.html";	
			
		}

	
		
		return forwardToJsp;
	}

}
