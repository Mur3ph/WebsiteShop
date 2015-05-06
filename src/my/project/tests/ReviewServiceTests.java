package my.project.tests;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import my.project.business_classes.Review;
import my.project.dao.MyProjectDatasource;
import my.project.dao.ReviewDao;
import my.project.services.ReviewService;

import org.junit.Before;
import org.junit.Test;

public class ReviewServiceTests {
	
	private ReviewDao revDao;
	private ReviewService revService;
	private MyProjectDatasource dataSource;
	
	@Before
	public void setUp() throws Exception {
		
		dataSource = new MyProjectDatasource();
		revDao = new ReviewDao(dataSource);
		revService = new ReviewService(revDao);
	}
	
	//TESTING THE REVIEWS FOR THE PUBLIC ON THE ALBUMS IN SHOP...............................................................
	
	@Test
	public void testRegister(){

		List<Review> rev = revService.getAllReviews(1, "XXX");
		// if user is null then message will be print
		assertNotNull("This function is not working properly testRegister", rev);
		
	}

}
