package my.project.services;

import java.util.Collections;
import java.util.List;

import my.project.business_classes.Customer;
import my.project.comparator.*;
import my.project.dao.CustomerDao;
import my.project.exceptions.DaoException;

public class CustomerService {
	
	
private CustomerDao custDao;
	
	public CustomerService(CustomerDao custDao){
		this.custDao = custDao;
	}
	
	public CustomerService(){
		this.custDao = new CustomerDao();
	}
	
	
	// GETTING THE CUSTOMER PERSONAL AND CREDIT DETAILS FOR TRANSACTION.............................................
	
	public Customer customerDetails(String firstname, String lastname, String address1, String address2, String city, String county, String country, String zip, String phone, String cardtype, String cardnumber, String cardidnumber, String valid){
		
		Customer c = null;
		
		try{ 
			//CustomerDao dao = new CustomerDao();
			c = custDao.GetCustomerDetails(firstname, lastname, address1, address2, city, county, country, zip, phone, cardtype, cardnumber, cardidnumber, valid );
		}
		catch (DaoException e) {
			e.printStackTrace();
		}
		
		return c;
	}
	
	//GETTING A LIST OF CUSTOMERS FOR THE ADMIN TO SEE............................................
	
	public List<Customer> getAllCustomers(){
		
		List<Customer> customers = null;
		
		try {
			//CustomerDao dao = new CustomerDao();
			customers = custDao.findAllCustomers();
		} 
		catch (DaoException e) {
			e.printStackTrace();
		}
		return customers;
		
}
	
	@SuppressWarnings("unchecked")
	public List<Customer> sortByFName(){
		
		List<Customer> cust = null;
		
		try {
			//ProductDao dao = new ProductDao();
			cust = custDao.findAllCustomers();
		} 
		catch (DaoException e) {
			e.printStackTrace();
		}
		
		cust_fnameComparator fnC = new cust_fnameComparator();
		Collections.sort(cust, fnC);
		
		return cust;
		
}
	
	@SuppressWarnings("unchecked")
	public List<Customer> sortByLName(){
		
		List<Customer> cust = null;
		
		try {
			//ProductDao dao = new ProductDao();
			cust = custDao.findAllCustomers();
		} 
		catch (DaoException e) {
			e.printStackTrace();
		}
		
		cust_lnameComparator lnC = new cust_lnameComparator();
		Collections.sort(cust, lnC);
		
		return cust;
		
}
	
	@SuppressWarnings("unchecked")
	public List<Customer> sortByCity(){
		
		List<Customer> cust = null;
		
		try {
			//ProductDao dao = new ProductDao();
			cust = custDao.findAllCustomers();
		} 
		catch (DaoException e) {
			e.printStackTrace();
		}
		
		cust_cityComparator cyC = new cust_cityComparator();
		Collections.sort(cust, cyC);
		
		return cust;
		
}
	
	@SuppressWarnings("unchecked")
	public List<Customer> sortByCounty(){
		
		List<Customer> cust = null;
		
		try {
			//ProductDao dao = new ProductDao();
			cust = custDao.findAllCustomers();
		} 
		catch (DaoException e) {
			e.printStackTrace();
		}
		
		cust_countyComparator coC = new cust_countyComparator();
		Collections.sort(cust, coC);
		
		return cust;
		
}

}
