package my.project.tests;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import my.project.business_classes.Product;
import my.project.business_classes.Ticket;
import my.project.dao.MyProjectDatasource;
import my.project.dao.ProductDao;
import my.project.exceptions.DaoException;

import org.junit.Before;
import org.junit.Test;

public class ProductDaoTests {
	
	private ProductDao prodDao;
	private MyProjectDatasource dataSource;
	
	@Before
	public void setUp() throws Exception {
		dataSource = new MyProjectDatasource();
		prodDao = new ProductDao(dataSource);
	}
	
	//TESTER THE ADMIN TO GET THE LIST OF NEW ALBUMS.....................................................
	
	@Test
	public void testalbumDetailsForNewRelease() throws DaoException {
		Product prod = prodDao.albumDetailsForNewRelease("A", "B", "C", "D", "E", 9.9);
		// if user is null then message will be print
		assertNotNull("This function is not working properly testalbumDetailsForNewRelease", prod);
	}
	
	
	//TESTER THE CUSTOMER WANTS TO BUY AN ALBUMS USING THE PRODUCT CODE.....................................................
	
		@Test
		public void testCreateUsersProduct1() throws DaoException {
			Product prod = prodDao.CreateUsersProduct1("1010A");
			// if user is null then message will be print
			assertNotNull("This function is not working properly testCreateUsersProduct1", prod);
		}
		
		
		//TESTER TO FIND WHAT THE CUSTOMER ORDERED FOR THE ADMIN USE.....................................................
		
			@Test
			public void testfindOrderedProducts() throws DaoException {
				Product prod = prodDao.findOrderedProducts();
				// if user is null then message will be print
				assertNotNull("This function is not working properly testfindOrderedProducts", prod);
			}
			
			//TESTER TO FIND THE PRODUCT DETAILS BY ID.....................................................
			
			@Test
			public void testproductView() throws DaoException {
				Product prod = prodDao.productView(1);
				// if user is null then message will be print
				assertNotNull("This function is not working properly testproductView", prod);
			}
			
			
			//TESTER DELETE ALBUM FROM DB.....................................................
			//NACH OIBRE DO ROINNT CUIS.............................................
			
//			@Test
//			public void testDeleteAlbumInfo() throws DaoException {
//				int prod = prodDao.DeleteAlbumInfo(1);
//				// if user is null then message will be print
//				assertNotNull("This function is not working properly testDeleteAlbumInfo", prod);
//			}
			
			//TESTER DELETE ALBUM FROM DB.....................................................
			
			@Test
			public void testfindAllNewProducts() throws DaoException {
				List<Product> prod = prodDao.findAllNewProducts();
				// if user is null then message will be print
				assertNotNull("This function is not working properly testfindAllNewProducts", prod);
			}
			
			@Test
			public void testfindAllProducts() throws DaoException {
				List<Product> prod = prodDao.findAllProducts();
				// if user is null then message will be print
				assertNotNull("This function is not working properly testfindAllProducts", prod);
			}
			
			@Test
			public void testfindAllTickets() throws DaoException {
				List<Ticket> prod = prodDao.findAllTickets();
				// if user is null then message will be print
				assertNotNull("This function is not working properly testfindAllTickets", prod);
			}


}
