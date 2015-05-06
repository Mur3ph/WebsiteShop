package my.project.tests;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import my.project.business_classes.Order;
import my.project.business_classes.OrderItem;
import my.project.dao.MyProjectDatasource;
import my.project.dao.OrderDao;
import my.project.services.OrderService;

import org.junit.Before;
import org.junit.Test;

public class OrderServiceTests {

	
	private OrderDao oDao;
	private OrderService oService;
	private MyProjectDatasource dataSource;
	
	@Before
	public void setUp() throws Exception {
		
		dataSource = new MyProjectDatasource();
		oDao = new OrderDao(dataSource);
		oService = new OrderService(oDao);
	}
	
	
	//TESTING GETTING A LIST OF ALL THE CUSTOMERS THAT MADE ORDERS..........................................
	
	@Test
	public void testorder1(){
		//Keep changing the first num up one after each test, change to random num generator later.......4............
		OrderItem o = oService.order1(4, 7);
		// if user is null then message will be print
		assertNotNull("This function is not working properly testorder1", o);
		
	}
	
	
	//TESTING THE ORDER SERVICE FOR CUSTOMER ID..........................................
	
	@Test
	public void testorder(){

		Order o = oService.order(1);
		// if user is null then message will be print
		assertNotNull("This function is not working properly testorder", o);
		
	}
	
	//TESTING THE ORDER SERVICE FOR ORDER & PRODUCT ID..........................................
	
		@Test
		public void testdeleteOrder(){

			int o = oService.deleteOrder(2, 2);
			// if user is null then message will be print
			assertNotNull("This function is not working properly testdeleteOrder", o);
			
		}
		
		
		//TESTING GETTING A LIST OF ALL THE CUSTOMERS THAT MADE ORDERS..........................................
		
			@Test
			public void testgetAllCustomerOrders(){

				List<Order> o = oService.getAllCustomerOrders(1);
				// if user is null then message will be print
				assertNotNull("This function is not working properly testgetAllCustomerOrders", o);
				
			}
			
			
			
	
}
