package my.project.tests;

import static org.junit.Assert.assertNotNull;
import my.project.business_classes.Administration;
import my.project.dao.MyProjectDatasource;
import my.project.dao.AdministrationDao;
import my.project.services.AdministrationService;

import org.junit.Before;
import org.junit.Test;

public class AdminServiceTests {
	
	private AdministrationDao adminDao;
	private AdministrationService adminService;
	private MyProjectDatasource dataSource;
	
	@Before
	public void setUp() throws Exception {
		
		dataSource = new MyProjectDatasource();
		adminDao = new AdministrationDao(dataSource);
		adminService = new AdministrationService(adminDao);
	}
	
	//TESTING THE USER SERVICE LOGGING IN..........................................
	
	@Test
	public void testLogin(){

		Administration admin = adminService.Login("adminuser1", "adminpass1");
		// if user is null then message will be print
		assertNotNull("This function is not working properly testLogin", admin);
		
	}

}
