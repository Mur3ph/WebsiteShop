package my.project.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogOutCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		
		// this is for the user or admin to log out 3 different ways to d this are below..........................
		
//		if (session.getAttribute("user") != null) { 
//			session.invalidate(); 
//			session = request.getSession(false);
//        } 
//		if (session.getAttribute("product") != null) {  
//        	session.invalidate();  
//        	session = request.getSession(false);
//        }
//		if (session.getAttribute("product1") != null) {  
//			session.invalidate();  
//        	session = request.getSession(false);
//        }
//		if (session.getAttribute("admin") != null) {  
//        	session.invalidate();  
//        	session = request.getSession(false); 
//		}
//		if (session.getAttribute("loggedSessionId") != null) {  
//    		session.invalidate();  
//    		session = request.getSession(false);
//    }
//		if (session.getAttribute("registeredSessionId") != null) {  
//        	session.invalidate();  
//        	session = request.getSession(false);
//        }
//		if (session.getAttribute("displaySessionId") != null) {  
//   		session.invalidate();  
//			session = request.getSession(false);
//}
		
		
		
//        	
//        	session.setAttribute("user", null);
//        	session.setAttribute("product", null);
//        	session.setAttribute("product1", null);
//        	session.setAttribute("admin", null);
//		
//    		session.setAttribute("loggedSessionId", null);
//    		session.setAttribute("registeredSessionId",null);
//    		session.setAttribute("displaySessionId", null);
		
//        	
        	session.removeAttribute("user");
        	session.removeAttribute("product");
        	session.removeAttribute("product1");
        	session.removeAttribute("product2");
        	session.removeAttribute("product3");
        	session.removeAttribute("product4");
    		session.removeAttribute("admin");
		
        	session.removeAttribute("registeredSessionId");
        	session.removeAttribute("loggedSessionId");
        	session.removeAttribute("displaySessionId");

		
		return "/login_index.jsp";
		
	}
	
}
