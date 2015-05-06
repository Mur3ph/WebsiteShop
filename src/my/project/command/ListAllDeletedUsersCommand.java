package my.project.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import my.project.business_classes.Message;
import my.project.services.MessageService;

public class ListAllDeletedUsersCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		MessageService messageService = new MessageService();
		String forwardToJsp = "";
		HttpSession session = request.getSession();
		
		//here Im getting all the info on the user that has deleted their profile using triggers, after deletion sore users info in message table
		// again for admin use only..........
		List<Message> messages = new ArrayList<Message>();
		messages = messageService.getAllDeletedUsers();

		//Put the list of deleted users into the session so that JSP(the View) can pick them up and display them...
		session.setAttribute("messages", messages);
		
		forwardToJsp = "/all_reports.jsp";	

		return forwardToJsp;
		
	}

}
