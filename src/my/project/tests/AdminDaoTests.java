package my.project.tests;

import static org.junit.Assert.assertNotNull;
import my.project.business_classes.Administration;
import my.project.dao.MyProjectDatasource;
import my.project.dao.AdministrationDao;
import my.project.exceptions.DaoException;

import org.junit.Before;
import org.junit.Test;

public class AdminDaoTests {
	
	private AdministrationDao adminDao;
	private MyProjectDatasource dataSource;
	
	@Before
	public void setUp() throws Exception {
		dataSource = new MyProjectDatasource();
		adminDao = new AdministrationDao(dataSource);
	}
	
	//TESTER THE ADMIN logging in.....................................................
	
	
		@Test
		public void testfindAdminByUsernamePassword() throws DaoException {
			Administration admin = adminDao.findAdminByUsernamePassword("adminuser1", "adminpass1");
			// if user is null then message will be print
			assertNotNull("This function is not working properly testfindAdminByUsernamePassword", admin);
		}

}
