package my.project.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import my.project.services.UserService;

public class CheckForUsernameBeingUsedCommand implements Command{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String forwardToJsp = null;
		UserService userService = new UserService();
		
		// taking the parameter from the register page to chck it against names stored.......................
		String username = request.getParameter("username");

		//Here I am checking the database to see if the username is availible or not..........................
		//If its availible return zero otherwise return one...................................................
		
		int check =  userService.findUserName(username);

		if (check == 1){
			forwardToJsp = "/regiister.jsp";
		}else{
			forwardToJsp = "/regiiister.jsp";
		}
		
		System.out.println(username + ": " + check);

		return forwardToJsp;

	}
}