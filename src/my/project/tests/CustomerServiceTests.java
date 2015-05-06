package my.project.tests;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import my.project.business_classes.Customer;
import my.project.dao.MyProjectDatasource;
import my.project.dao.CustomerDao;
import my.project.services.CustomerService;

import org.junit.Before;
import org.junit.Test;

public class CustomerServiceTests {
	
	private CustomerDao custDao;
	private CustomerService custService;
	private MyProjectDatasource dataSource;
	
	@Before
	public void setUp() throws Exception {
		
		dataSource = new MyProjectDatasource();
		custDao = new CustomerDao(dataSource);
		custService = new CustomerService(custDao);
	}
	
	//TESTING THE CUSTOMERS SERVICE DETAILS FOR BUYING PRODUCT..........................................
	
	@Test
	public void testcustomerDetails(){

		Customer cust = custService.customerDetails("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m");
		// if user is null then message will be print
		assertNotNull("This function is not working properly testcustomerDetails", cust);
		
	}
	
	
	@Test
	public void testgetAllCustomers(){

		List<Customer> cust = custService.getAllCustomers();
		// if user is null then message will be print
		assertNotNull("This function is not working properly testgetAllCustomers", cust);
		
	}

}
