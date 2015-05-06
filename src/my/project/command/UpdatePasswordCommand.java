package my.project.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import my.project.business_classes.User;
import my.project.services.UserService;

public class UpdatePasswordCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String forwardToJsp = null;
		UserService userService = new UserService();
		
		String oldpassword = request.getParameter("opassword");
		String username = request.getParameter("uname");
		String newpassword = request.getParameter("npassword");
		String vnpassword = request.getParameter("vnpassword");
		
		// for the user to change their password if they need be..............................
		
		
		//validatio one...............................................
		if (oldpassword != null && username != null && newpassword != null && vnpassword != null){
			
			//|| validation two...................................................................
			
			if (oldpassword.equals("") || username.equals("") || newpassword.equals("") || vnpassword.equals("") || !vnpassword.equals(newpassword))
			{
						forwardToJsp = "/update.jsp";
			}
			else 
			{
			
			//Use the UserServive class to update.....
			User userIsRegistering = userService.update(oldpassword, newpassword);

			if (userIsRegistering != null){
				
				//if user updates in we store the session id for client...
				HttpSession session = request.getSession();
				String clientSessionId = session.getId();
				session.setAttribute("updatedSessionId", clientSessionId);

				session.setAttribute("user", userIsRegistering);

				forwardToJsp = "/update_success.jsp";
				
				
			}else{
				
				
				forwardToJsp = "/update.jsp";
				
			}
			}
		}else {
			
			
			forwardToJsp = "/update.jsp";	
			
		}

	
		
		return forwardToJsp;
		
	}
	
	

}
