package my.project.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import my.project.business_classes.User;
import my.project.dao.MyProjectDatasource;
import my.project.dao.UserDao;
import my.project.services.UserService;

public class UserServiceTests {
	
	private UserDao userDao;
	private UserService userService;
	private MyProjectDatasource dataSource;
	
	@Before
	public void setUp() throws Exception {
		
		dataSource = new MyProjectDatasource();
		userDao = new UserDao(dataSource);
		userService = new UserService(userDao);
	}
	
	//TESTING THE USER SERVICE REGISTER..........................................
	
	@Test
	public void testRegister(){

		User user = userService.register("a", "b", "c", "d", "e");
		// if user is null then message will be print
		assertNotNull("This function is not working properly testRegister", user);
		
	}
	
	//TESTING THE USER SERVICE LOGIN..............................................
	
	
	
	@Test
	public void testLogin(){

		User user = userService.Login("pmurp09", "p9823874m");
		// if user is null then message will be print
		assertNotNull("This function is not working properly testLogin", user);
		
	}
	
	
	//TESTING THE USER SERVICE USER UPDATING THEIR PASSWORD.......................
	
	
	
	@Test
	public void testupdate(){

		User user = userService.update("p9823874m", "p9823874m");
		// if user is null then message will be print
		assertNotNull("This function is not working properly testupdate", user);
		
	}
	
	
	//TESTING THE USER SERVIVE DELETE FOR THE USER TO DELETE THEIR PERSONAL INFO..................................
	
	@Test
	public void testDelete(){

		User user = userService.delete("a", "b", "c", "d");
		// if user is null then message will be print
		assertNotNull("This function is not working properly testDelete", user);
		
	}
	
	//TESTING THE USER SERVICE METHOG WHERE THE USERNAE PARAMETER IS PASSED TO CHECK THE DB FOR IT EXISTS.................
	
	@Test
	public void testfindUserName(){

		int user = userService.findUserName("a");
		// if user is null then message will be print
		assertNotNull("This function is not working properly testfindUserName", user);
		
	}
	
	//TESTING AN ARRAYLIST OF USERS FOR THE ADMIN USE.......................................................................
	
	@Test
	public void testfindUserName1(){

		List<User> user = userService.findUserName1("a");
		// if user is null then message will be print
		assertNotNull("This function is not working properly testfindUserName1", user);
		
	}
	

}
