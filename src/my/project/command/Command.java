package my.project.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	
	// My Interface for the request and responce.............................................
	
	String execute(HttpServletRequest request, HttpServletResponse response);

}
