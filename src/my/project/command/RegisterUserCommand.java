package my.project.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import my.project.business_classes.User;
import my.project.services.UserService;

public class RegisterUserCommand implements Command{
	
	// Register the User............................................................................
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		String forwardToJsp = null;
		UserService userService = new UserService();
		
		// Register the User............................................................................
		
		
				

					//The user wants to Register...
					String reg_firstname = request.getParameter("firstname");
					String reg_lastname = request.getParameter("lastname");
					String reg_email = request.getParameter("email");
					String reg_username = request.getParameter("username");
					String reg_password = request.getParameter("password");
					String reg_repassword = request.getParameter("repassword");
					
					
					// validation one..........................................................
					if (reg_firstname != null && reg_lastname != null && reg_email != null && reg_username != null && reg_password != null && reg_repassword != null){
						
//						validation two to stop from leavinng the page until correct info s given......................
						
						if (reg_firstname.equals("") || reg_lastname.equals("") || reg_email.equals("") || !reg_email.contains("@") || !reg_email.contains(".") || reg_username.equals("") || reg_password.equals("") || reg_repassword.equals("") || !reg_repassword.equals(reg_password))
						{
									forwardToJsp = "/regiiister.jsp";
						}
						else 
						{
						
						//Use the UserServive class to register.....
						User userIsRegistering = userService.register(reg_firstname, reg_lastname, reg_email, reg_username, reg_password);

						// makin g sure te info registeredd isn't returened empty......................
						
						if (userIsRegistering != null){
							
							//if user registers in we store the session id for client...
							HttpSession session = request.getSession();
							String clientSessionId = session.getId();
							session.setAttribute("registeredSessionId", clientSessionId);

							session.setAttribute("user", userIsRegistering);

							forwardToJsp = "/login_index.jsp";
							
							
						}else{
							
							
							forwardToJsp = "/regiiister.jsp";
							
						}
					}
					}else {
						
						
						forwardToJsp = "/regiiister.jsp";	
						
					}
					
					
		
		
					return forwardToJsp;
		
	}


}


