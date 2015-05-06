package my.project.tests;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import my.project.business_classes.Product;
import my.project.business_classes.Ticket;
import my.project.dao.MyProjectDatasource;
import my.project.dao.ProductDao;
import my.project.exceptions.DaoException;
import my.project.services.ProductService;

import org.junit.Before;
import org.junit.Test;

public class ProductServiceTests {

	
	private ProductDao prodDao;
	private ProductService prodService;
	private MyProjectDatasource dataSource;
	
	@Before
	public void setUp() throws Exception {
		
		dataSource = new MyProjectDatasource();
		prodDao = new ProductDao(dataSource);
		prodService = new ProductService(prodDao);
	}
	
	
	
	//TESTER THE ADMIN TO GET THE LIST OF NEW ALBUMS.....................................................
	
		@Test
		public void testalbumDetails() throws DaoException {
			Product prod = prodService.albumDetails("A", "B", "C", "D", "E", 9.9);
			// if user is null then message will be print
			assertNotNull("This function is not working properly testalbumDetails", prod);
		}
		
		
		//TESTER THE CUSTOMER WANTS TO BUY AN ALBUMS USING THE PRODUCT CODE.....................................................
		
			@Test
			public void testproductOrder1() throws DaoException {
				Product prod = prodService.productOrder1("1010A");
				// if user is null then message will be print
				assertNotNull("This function is not working properly testproductOrder1", prod);
			}
			
				
				//TESTER TO FIND THE PRODUCT DETAILS BY ID.....................................................
				
				@Test
				public void testproductView() throws DaoException {
					Product prod = prodService.productView(1);
					// if user is null then message will be print
					assertNotNull("This function is not working properly testproductView", prod);
				}
				
				
				//TESTER DELETE ALBUM FROM DB.....................................................
				//NACH OIBRE DO ROINNT CUIS.............................................
				
				@Test
				public void testDeleteAlbumInfo() throws DaoException {
					int prod = prodService.deleteAlbumInfo(1);
					// if user is null then message will be print
					assertNotNull("This function is not working properly testDeleteAlbumInfo", prod);
				}
				
				//TESTER DELETE ALBUM FROM DB.....................................................
				
				@Test
				public void testgetAllProducts() throws DaoException {
					List<Product> prod = prodService.getAllProducts();
					// if user is null then message will be print
					assertNotNull("This function is not working properly testgetAllProducts", prod);
				}
				
				@Test
				public void testgetAllNewProducts() throws DaoException {
					List<Product> prod = prodService.getAllNewProducts();
					// if user is null then message will be print
					assertNotNull("This function is not working properly testgetAllNewProducts", prod);
				}
				
				@Test
				public void testgetAllTickets() throws DaoException {
					List<Ticket> prod = prodService.getAllTickets();
					// if user is null then message will be print
					assertNotNull("This function is not working properly testgetAllTickets", prod);
				}
}
