package my.project.tests;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import my.project.business_classes.Customer;
import my.project.dao.MyProjectDatasource;
import my.project.dao.CustomerDao;
import my.project.exceptions.DaoException;

import org.junit.Before;
import org.junit.Test;

public class CustomerDaoTests {
	
	private CustomerDao custDao;
	private MyProjectDatasource dataSource;
	
	@Before
	public void setUp() throws Exception {
		dataSource = new MyProjectDatasource();
		custDao = new CustomerDao(dataSource);
	}
	
	//TESTER THE USER REGISTER.....................................................
	
	@Test
	public void testGetCustomerDetails() throws DaoException {
		Customer cust = custDao.GetCustomerDetails("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m");
		// if user is null then message will be print
		assertNotNull("This function is not working properly testGetCustomerDetails", cust);
	}
	
	
	@Test
	public void testgetAllCustomers() throws DaoException{

		List<Customer> cust = custDao.findAllCustomers();
		// if user is null then message will be print
		assertNotNull("This function is not working properly testgetAllCustomers", cust);
		
	}

}
