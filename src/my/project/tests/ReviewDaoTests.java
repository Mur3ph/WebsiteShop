package my.project.tests;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import my.project.business_classes.Review;
import my.project.dao.MyProjectDatasource;
import my.project.dao.ReviewDao;
import my.project.exceptions.DaoException;

import org.junit.Before;
import org.junit.Test;

public class ReviewDaoTests {
	
	private ReviewDao revDao;
	private MyProjectDatasource dataSource;
	
	@Before
	public void setUp() throws Exception {
		dataSource = new MyProjectDatasource();
		revDao = new ReviewDao(dataSource);
	}
	
	//TESTER THE REVIEWS FOR THE ALBUMS IN THE SHOP......................................................
	
	@Test
	public void testfindAllReviews() throws DaoException {
		List<Review> rev = revDao.findAllReviews(2, "Big fan, loved it..");
		// if user is null then message will be print
		assertNotNull("This function is not working properly testfindAllReviews", rev);
	}

}
