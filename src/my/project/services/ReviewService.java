package my.project.services;

import java.util.List;

import my.project.business_classes.Review;
import my.project.dao.ReviewDao;
import my.project.exceptions.DaoException;

public class ReviewService {
	
private ReviewDao revDao;
	
	public ReviewService(ReviewDao revDao){
		this.revDao = revDao;
	}
	
	public ReviewService(){
		this.revDao = new ReviewDao();
	}
	
	//FOR THE PUBLIC TO REVIEW THE ALBUMS AND WRITE COOMMENT S TO BE DISPLAYED UNDER EACH ALBUM......................
	
	public List<Review> getAllReviews(int code, String comment){
		
		List<Review> reviews = null;
		
		try {
			//ReviewDao dao = new ReviewDao();
			reviews = revDao.findAllReviews(code, comment);
		} 
		catch (DaoException e) {
			e.printStackTrace();
		}
		return reviews;
		
}

}
