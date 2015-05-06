package my.project.command;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import my.project.business_classes.User;
import my.project.services.UserService;


public class LoginUserCommand implements Command{

	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String forwardToJsp = null;
		UserService userService = new UserService();
		
		
		// Checking to see what the user wants.............................................................
		// logging in user.................................................................................
		
			// taking the parameters......................................................................
			String user_username = request.getParameter("username");
			String user_password = request.getParameter("password");
			
			// loogging the user in again check ing or validating the entrys made by the user..........................
			
			if(user_username != null && user_password != null){
				
				if (user_username.equals("") || user_password.equals(""))
				{
							forwardToJsp = "/user_login.jsp";
				}
				else 
				{
				
				User userLoggingIn = userService.Login(user_username, user_password);
				// making sure it isnt returned empty............................
				if(userLoggingIn != null){
					
					//if user logs in we store the session id for client...
					HttpSession session = request.getSession();
					String clientSessionId = session.getId();
					session.setAttribute("loggedSessionId", clientSessionId);
					
					session.setAttribute("user", userLoggingIn);
					// here i have cookie from or to welcome the user when they log in........................
					String nameoftheuser= userLoggingIn.getFirstName();
					if(nameoftheuser==null) 
						nameoftheuser="";
					Cookie cookie = new Cookie ("nameoftheuser",nameoftheuser);
					cookie.setMaxAge(365 * 24 * 60 * 60);
					response.addCookie(cookie);
					
					forwardToJsp = "/welcome.jsp";
					
				}else{
					
					forwardToJsp = "/user_logiin.jsp";
					
				}
				}
			}else{
				
				forwardToJsp = "/user_logiin.jsp";
				
			}
			
		
		
		
		return forwardToJsp;
	}

}
