package my.project.services;


import java.util.Collections;
import java.util.List;

import my.project.business_classes.Product;
import my.project.business_classes.Ticket;
import my.project.comparator.album_codeComparator;
import my.project.comparator.album_nameComparator;
import my.project.comparator.album_priceComparator;
import my.project.dao.ProductDao;
import my.project.exceptions.DaoException;

public class ProductService {
	
private ProductDao prodDao;
	
	public ProductService(ProductDao prodDao){
		this.prodDao = prodDao;
	}
	
	public ProductService(){
		this.prodDao = new ProductDao();
	}
	
	// ******************************88These first methods are for the album***************************************************88.............................................................................
	
	// HERE IS THE ALBUM THAT THE CUSTOMER CHOSE AND PLACED IN CART......................................
	
	public Product productOrder1(String code){
		
		Product p = null;
		
		try{ 
			//ProductDao dao = new ProductDao();
			p = prodDao.CreateUsersProduct1(code);
		}
		catch (DaoException e) {
			e.printStackTrace();
		}
		return p;
	}
	
	// HERE THE CUSTONER WANTS TO VIEW INFO ON THE ALBUM........................................................
	
public Product productView(int code){
		
		Product p = null;
		
		try{ 
			//ProductDao dao = new ProductDao();
			p = prodDao.productView(code);
		}
		catch (DaoException e) {
			e.printStackTrace();
		}
		return p;
	}
	
	// GET A LIST OF ALL THE ALBUMS TO DISPLAY IN THE SHOP.........................................................
	
	public List<Product> getAllProducts(){
			
			List<Product> products = null;
			
			try {
				//ProductDao dao = new ProductDao();
				products = prodDao.findAllProducts();
			} 
			catch (DaoException e) {
				e.printStackTrace();
			}
			return products;
			
	}
	
	//HERE IM USING THE PRICE COMPARATOR TO SHOW THE ALBUMS IN THE SHOP IN PRICE ORDER.................................
	
	@SuppressWarnings("unchecked")
	public List<Product> sortByPrice(){
		
		List<Product> products = null;
		
		try {
			//ProductDao dao = new ProductDao();
			products = prodDao.findAllProducts();
		} 
		catch (DaoException e) {
			e.printStackTrace();
		}
		
		album_priceComparator pC = new album_priceComparator();
		Collections.sort(products, pC);
		
		return products;
		
}
	
	@SuppressWarnings("unchecked")
	public List<Product> sortByName(){
		
		List<Product> products = null;
		
		try {
			//ProductDao dao = new ProductDao();
			products = prodDao.findAllProducts();
		} 
		catch (DaoException e) {
			e.printStackTrace();
		}
		
		album_nameComparator nC = new album_nameComparator();
		Collections.sort(products, nC);
		
		return products;
		
}
	
	@SuppressWarnings("unchecked")
	public List<Product> sortByCode(){
		
		List<Product> products = null;
		
		try {
			//ProductDao dao = new ProductDao();
			products = prodDao.findAllProducts();
		} 
		catch (DaoException e) {
			e.printStackTrace();
		}
		
		album_codeComparator cC = new album_codeComparator();
		Collections.sort(products, cC);
		
		return products;
		
}
	
	
	
//************************88 These methods below are for the tickets***************************************************************88
	
	// GETTING THE LIST OF TICKETS FROM DB AND PLACING THEM IN TICKET SHOP...........................................
	
	public List<Ticket> getAllTickets(){
		
		List<Ticket> tickets = null;
		
		try {
			//ProductDao dao = new ProductDao();
			tickets = prodDao.findAllTickets();
		} 
		catch (DaoException e) {
			e.printStackTrace();
		}
		return tickets;
		
}
	
	
	//************************88 Admin is deleting albums from the database***************************************************************88
	
	// ADMIN USER DELETING ALBUMS FROM THE SHOP........................................................
public int deleteAlbumInfo(int id){
		
		int p = 0;
		
		try{ 
			//ProductDao dao = new ProductDao();
			p = prodDao.DeleteAlbumInfo(id);
		}
		catch (DaoException e) {
			e.printStackTrace();
		}
		return p;
	}

// all new releases for admin.....................................................
// CAN PLACE THESE IN THE SHOP FOR CUSTOMER TO BUY/..............................

public List<Product> getAllNewProducts(){
	
	List<Product> products = null;
	
	try {
		//ProductDao dao = new ProductDao();
		products = prodDao.findAllNewProducts();
	} 
	catch (DaoException e) {
		e.printStackTrace();
	}
	return products;
	
}

// Admin adding a new release album to the customer shop........................................


public Product albumDetails(String cover, String code, String name, String genre, String desc, Double price){
	
	Product p = null;
	
	try{ 
		//ProductDao dao = new ProductDao();
		p = prodDao.albumDetailsForNewRelease(cover,code,name,genre,desc,price);
	}
	catch (DaoException e) {
		e.printStackTrace();
	}
	return p;
}




}
