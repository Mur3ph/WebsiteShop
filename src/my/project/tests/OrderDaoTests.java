package my.project.tests;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import my.project.business_classes.Order;
import my.project.business_classes.OrderItem;
import my.project.dao.MyProjectDatasource;
import my.project.dao.OrderDao;
import my.project.exceptions.DaoException;

import org.junit.Before;
import org.junit.Test;

public class OrderDaoTests {
	
	private OrderDao oDao;
	private MyProjectDatasource dataSource;
	
	@Before
	public void setUp() throws Exception {
		dataSource = new MyProjectDatasource();
		oDao = new OrderDao(dataSource);
	}
	
	

	//TESTER THE Order for the order & product id.....................................................
	
		@Test
		public void testCreateOrderItem() throws DaoException {
			//Keep changing the first num up one after each test, change to random num generator later.......6............
			OrderItem o = oDao.CreateOrderItem(6, 2);
			// if user is null then message will be print
			assertNotNull("This function is not working properly testCreateOrderItem", o);
		}
		
		
	
	//TESTER the administrator deleting the order made by the custome after checking it.....................................................
	
	@Test
	public void testDeleteOrder() throws DaoException {
		int o = oDao.DeleteOrder(2, 2);
		// if user is null then message will be print
		assertNotNull("This function is not working properly testDeleteOrder", o);
	}
	
	
	
	
	//TESTER THE Order for the customers id.....................................................
	
	@Test
	public void testCreateOrder() throws DaoException {
		Order o = oDao.CreateOrder(10);
		// if user is null then message will be print
		assertNotNull("This function is not working properly testCreateOrder", o);
	}
	
	
	
	//TESTER THE Order made by the customer and called by administrator.....................................................
	
		@Test
		public void testgetOrder() throws DaoException {
			List<Order> o = oDao.getOrder(1);
			// if user is null then message will be print
			assertNotNull("This function is not working properly testgetOrder", o);
		}
		
		
		

}
