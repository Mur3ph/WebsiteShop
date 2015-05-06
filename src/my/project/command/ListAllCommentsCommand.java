package my.project.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import my.project.business_classes.Review;
import my.project.services.ReviewService;

public class ListAllCommentsCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		ReviewService reviewService = new ReviewService();
		String forwardToJsp = "";
		HttpSession session = request.getSession();
		
		//here im getting the code of the product that corresponds to that review of the product.........................
		
		String code = request.getParameter("code");
		String comment = request.getParameter("comment");
		
		// storing the comments in a list to print out on the page....................................
		List<Review> reviews = new ArrayList<Review>();
		reviews = reviewService.getAllReviews(Integer.parseInt(code), comment);

		//Put the list of comments into the session so that JSP(the View) can pick them up and display them...
		session.setAttribute("reviews", reviews);
		forwardToJsp = "/album.jsp";	

		return forwardToJsp;

		
	}

}
