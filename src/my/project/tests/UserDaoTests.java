package my.project.tests;

import static org.junit.Assert.*;

import java.util.List;

import my.project.business_classes.User;
import my.project.dao.MyProjectDatasource;
import my.project.dao.UserDao;
import my.project.exceptions.DaoException;

import org.junit.Before;
import org.junit.Test;

public class UserDaoTests {
	
	private UserDao userDao;
	private MyProjectDatasource dataSource;
	
	@Before
	public void setUp() throws Exception {
		dataSource = new MyProjectDatasource();
		userDao = new UserDao(dataSource);
	}
	
	//TESTER THE USER REGISTER.....................................................
	
	@Test
	public void testCreateUser() throws DaoException {
		User user = userDao.CreateUser("a", "b", "c", "d", "e");
		// if user is null then message will be print
		assertNotNull("This function is not working properly testCreateUser", user);
	}
	
	
	//TESTING THE USER LOGGING ON..................................................
	
	
	@Test
	public void testfindUserByUsernamePassword() throws DaoException {
		User user = userDao.findUserByUsernamePassword("pmurp09", "p9823874m");
		// if user is null then message will be print
		assertNotNull("This function is not working properly testfindUserByUsernamePassword", user);
	}
	
	
	//TESTING THE USER UPDATING THEIR PASSWORD.......................................
	
	
	@Test
	public void testUpdateUser() throws DaoException {
		User user = userDao.UpdateUser("p9823874m", "p9823874m");
		// if user is null then message will be print
		assertNotNull("This function is not working properly testUpdateUser", user);
	}
	

	//TESTING THE USER DELETION OF PERSONAL DETAILS METHOD..................................................
	
	@Test
	public void testDeleteUser() throws DaoException {
		User user = userDao.DeleteUser("a", "b","c","d");
		// if user is null then message will be print
		assertNotNull("This function is not working properly testDeleteUser", user);
	}
	
	//TESTING THE USER SEARCHING FOR USER NAME EXISTS IN DATABASE...................
	
	@Test
	public void testfindUserName() throws DaoException {
		int user = userDao.findUserName("str");
		// if user is null then message will be print
		assertNotNull("This function is not working properly testfindUserName", user);
	}
	
	
	@Test
	public void testfindUserName1() throws DaoException {
		List<User> user = userDao.findUserName1("str");
		// if user is null then message will be print
		assertNotNull("This function is not working properly testfindUserName1", user);
	}
	
	

}
