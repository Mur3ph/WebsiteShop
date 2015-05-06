package my.project.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import my.project.business_classes.Customer;

import my.project.exceptions.DaoException;

public class CustomerDao extends Dao{
	
	public CustomerDao(DataSource ds){
		super(ds);
		}
		
	public CustomerDao(){
		super();
		}

	
	
	// getting the customer info and storing it in the customer table...........................................
	// all parameters passed personal and credit information................................................
	
	public Customer GetCustomerDetails(String firstname, String lastname, String address1, String address2, String city, String county, String country, String zip, String phone, String cardtype, String cardnumber, String cardidnumber, String valid) throws DaoException {
		 
 		Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Customer c = null;
         
        try {
        	
        	// USING JAVA MD5 ENCRYPTION ON THE CUSTOMER PASSWORD BEING USED TO PURCHASE AN ITEM FROM THE SHOP.........................................................

        	String cardnumberHash = null;
        	MessageDigest md5 = MessageDigest.getInstance("MD5");
        	md5.update(cardnumber.getBytes());
        	cardnumberHash = new String(md5.digest());
        	
        	String cardidnumberHash = null;
        	MessageDigest md51 = MessageDigest.getInstance("MD5");
        	md51.update(cardnumber.getBytes());
        	cardidnumberHash = new String(md51.digest());
        	
        	con = getConnection();
            String query = "SELECT * FROM CUSTOMER";
            ps = con.prepareStatement(query);
            
            rs = ps.executeQuery();
            
            query = "INSERT INTO CUSTOMER(FIRSTNAME,LASTNAME,ADDRESS1,ADDRESS2,CITY,COUNTY,COUNTRY,ZIP,PHONE,CARDTYPE,CARDNUMBER,CARDIDNUMBER,VALIDUNTIL) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(query);
            ps.setString(1, firstname);
            ps.setString(2, lastname);
            ps.setString(3, address1);
            ps.setString(4, address2);
            ps.setString(5, city);
            ps.setString(6, county);
            ps.setString(7, country);
            ps.setString(8, zip);
            ps.setString(9, phone);
            ps.setString(10, cardtype);
            ps.setString(11, cardnumberHash);
            ps.setString(12, cardidnumberHash);
            ps.setString(13, valid);
            
            ps.execute();
            
            //here im getting the id of the customer that has just given the inf to buy a product 
            // and using it for the order...............................................
            
            query = "SELECT LAST_INSERT_ID()";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            
            int Id = 1;
            
            if (rs.next())
            	Id = rs.getInt(1);
            
            c = new Customer(Id, firstname, lastname, address1, address2, city, county, country, zip, phone, cardtype, cardnumber, cardidnumber, valid);
            
        } catch (SQLException | NoSuchAlgorithmException e) {
            throw new DaoException("CustomerOrder " + e.getMessage());
        } finally {
            try {
            	
                if (rs != null) {
                    rs.close();
                }
                
                if (ps != null) {
                    ps.close();
                }
                
                if (con != null) {
                    freeConnection(con);
                }
                
            } catch (SQLException e) {
                throw new DaoException("findUserByUsernamePassword" + e.getMessage());
            }
        }
        return c;
	 
	 }
	
	// getting all the customers from the customer table for the administrator to see,,,,....................
	
	public List<Customer> findAllCustomers() throws DaoException {
        
    	Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Customer c = null;
        List<Customer> customers = new ArrayList<Customer>();
        
        try {
        	//Get connectino object using the methos in the super class (Dao.java)...
            con = this.getConnection();

            String query = "SELECT * FROM CUSTOMER";
            ps = con.prepareStatement(query);
            
            //Using a PreparedStatement to execute SQL...
            rs = ps.executeQuery();
            while (rs.next()) {
            	
                int id = rs.getInt("CUSTOMERID");
                String firstname = rs.getString("FIRSTNAME");
                String surname = rs.getString("LASTNAME");
                String address1 = rs.getString("ADDRESS1");
                String address2 = rs.getString("ADDRESS2");
                String city = rs.getString("CITY");
                String county = rs.getString("COUNTY");
                String country = rs.getString("COUNTRY");
                String zip = rs.getString("ZIP");
                String phone = rs.getString("PHONE");
                String cardtype = rs.getString("CARDTYPE");
                String cardnumber = rs.getString("CARDNUMBER");
                String cardidnumber = rs.getString("CARDIDNUMBER");
                String validuntil = rs.getString("VALIDUNTIL");
                
                c = new Customer(id, firstname, surname, address1, address2, city, county, country, zip, phone, cardtype, cardnumber, cardidnumber, validuntil);
                customers.add(c);
        }
        } catch (SQLException e) {
            throw new DaoException("findAllCustomers() " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                throw new DaoException(e.getMessage());
            }
        }
        return customers;     // may be empty
    }
 

}
