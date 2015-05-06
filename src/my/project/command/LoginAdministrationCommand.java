package my.project.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import my.project.business_classes.Administration;

import my.project.services.AdministrationService;


public class LoginAdministrationCommand implements Command{
	
	

		@Override
		public String execute(HttpServletRequest request, HttpServletResponse response) {
			
			String forwardToJsp = null;
			AdministrationService adminService = new AdministrationService();
			
			
			// Checking to see what the user wants.....................................................................
			
			
			// logging in Aministration.................................................................................
			
				String admin_username = request.getParameter("username");
				String admin_password = request.getParameter("password");
				
				
				// Two forms of validation in the two if statements......................................................
				if(admin_username != null && admin_password != null){
					
					
					if (admin_username.equals("") || admin_password.equals(""))
					{
								forwardToJsp = "admin_logiin.jsp";
					}
					else 
					{
					
					
					Administration adminLoggingIn = adminService.Login(admin_username, admin_password);
					
					// checking to see that its not returned empty..........................................
					
					if(adminLoggingIn != null){
						
						//if user logs in we store the session id for client...
						HttpSession session = request.getSession();
						String clientSessionId = session.getId();
						session.setAttribute("loggedSessionId", clientSessionId);
						
						session.setAttribute("admin", adminLoggingIn);
						
						forwardToJsp = "/admin_index.jsp";
						
					}else{
						
						forwardToJsp = "/admin_logiin.jsp";
						
					}
					}
				}else{
					
					forwardToJsp = "/admin_logiin.jsp";
					
				}
			
			
			return forwardToJsp;
		}
		
	
	
	

}
