package my.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import my.project.business_classes.Product;
import my.project.business_classes.Ticket;
import my.project.exceptions.DaoException;
import my.project.dao.Dao;


public class ProductDao extends Dao{
	
	public ProductDao(DataSource ds){
		super(ds);
		}
		
	public ProductDao(){
		super();
		}
	
//	here im selecting the 
	//album the customer wants to buy from the shop and placing it in the cart.................................
	// should be stroringt this in an arraylist at later stage so cust can buy many products.....................................
	
	public Product CreateUsersProduct1(String code) throws DaoException {
		
 		Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Product p = null;
        
        try {
            con = getConnection();

            String query = "SELECT * FROM THEALBUMS WHERE PRODUCTCODE = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, code);
           
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
            	int id = rs.getInt("PRODUCTID");
            	String cover = rs.getString("ALBUM_COVER");
                String ccode = rs.getString("PRODUCTCODE");
                String name = rs.getString("PRODUCT_NAME");
                String genre = rs.getString("PRODUCT_GENRE");
                String description = rs.getString("PRODUCT_DESC");
                Double price = rs.getDouble("PRODUCT_PRICE");
             
            	
            	 ps.execute();
                 
                 p = new Product(id,cover, ccode, name, genre, description, price);
             }
      
           
        } catch (SQLException e) {
            throw new DaoException("CreateUsersProduct " + e.getMessage());
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
                throw new DaoException("CreateUsersProduct" + e.getMessage());
            }
        }
        return p;
	 }
	
	// here im getting the individual reviews that correspond to the album made on products by customers or users...............................
	 public Product productView(int code) throws DaoException {
 		
   		 
  		Connection con = null;
         PreparedStatement ps = null;
         ResultSet rs = null;
         Product p = null;
//         Review r = null;
//         int i = 0;
         
         try {
             con = getConnection();

             String query = "SELECT * FROM THEALBUMS,REVIEW WHERE THEALBUMS.PRODUCTID = ? AND THEALBUMS.PRODUCTID = REVIEW.PRODUCTID";
             ps = con.prepareStatement(query);
             ps.setInt(1, code);
            
             
             rs = ps.executeQuery();
             
             while (rs.next()) {
//             	i++;
             	int id = rs.getInt("PRODUCTID");
             	String cover = rs.getString("ALBUM_COVER");
                 String ccode = rs.getString("PRODUCTCODE");
                 String name = rs.getString("PRODUCT_NAME");
                 String genre = rs.getString("PRODUCT_GENRE");
                 String description = rs.getString("PRODUCT_DESC");
                 Double price = rs.getDouble("PRODUCT_PRICE");
//                 
//                 int id1 = rs.getInt("REVIEWID");
//                 int id2 = rs.getInt("PRODUCTID");
//                 String message = rs.getString("MESSAGE");
//                 String date = rs.getString("REVIEWDATE");
              
             	
             	 ps.execute();
//                  r = new Review(id1,id2,message,date);
                  p = new Product(id,cover, ccode, name, genre, description, price);
             }
    
				 } catch (SQLException e) {
				     throw new DaoException("CreateUsersProduct " + e.getMessage());
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
				         throw new DaoException("CreateUsersProduct" + e.getMessage());
				     }
				 }
				 return p;
				}
	 
	 
	
	// getting a list of all the products for the shop/................................................
	 public List<Product> findAllProducts() throws DaoException {
	        
	    	Connection con = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        List<Product> products = new ArrayList<Product>();
	        int i = 0;
	        
	        try {
	        	//Get connectino object using the methos in the super class (Dao.java)...
	            con = this.getConnection();

	            String query = "SELECT * FROM THEALBUMS";
	            ps = con.prepareStatement(query);
	            
	            //Using a PreparedStatement to execute SQL...
	            rs = ps.executeQuery();
	            while (rs.next()) {
	            	i++;
	                // int userId = rs.getInt("ID");
	                String cover = rs.getString("ALBUM_COVER");
	                String code = rs.getString("PRODUCTCODE");
	                String name = rs.getString("PRODUCT_NAME");
	                String genre = rs.getString("PRODUCT_GENRE");
	                String description = rs.getString("PRODUCT_DESC");
	                Double price = rs.getDouble("PRODUCT_PRICE");
	            
	                
	                Product u = new Product(i,cover, code, name, genre, description, price);
	                products.add(u);
	        }
	        } catch (SQLException e) {
	            throw new DaoException("findAllProducts() " + e.getMessage());
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
	        return products;     // may be empty
	    }
	 
	 
	 // not sure about this one of of yet....................................................
	 // could be one that got away from me...................................................
	 // doesnt seem to be doing anything unique,.............................................
	 // certainly not finding ordered album......................................
	 
	 public Product findOrderedProducts() throws DaoException {
	        
	    	Connection con = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        Product p = null;
	        int i = 0;
	        
	        try {
	        	//Get connectino object using the methos in the super class (Dao.java)...
	            con = this.getConnection();

	            String query = "SELECT * FROM THEALBUMS";
	            ps = con.prepareStatement(query);
	            
	            //Using a PreparedStatement to execute SQL...
	            rs = ps.executeQuery();
	            while (rs.next()) {
	            	i++;
	                // int userId = rs.getInt("ID");
	                String cover = rs.getString("ALBUM_COVER");
	                String code = rs.getString("PRODUCTCODE");
	                String name = rs.getString("PRODUCT_NAME");
	                String genre = rs.getString("PRODUCT_GENRE");
	                String description = rs.getString("PRODUCT_DESC");
	                Double price = rs.getDouble("PRODUCT_PRICE");
	                
	                p = new Product(i,cover, code, name, genre, description, price);
	                
	        }
	        } catch (SQLException e) {
	            throw new DaoException("findAllProducts() " + e.getMessage());
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
	        return p;     // may be empty
	    }
	 
	 
	 //****************************88 This section below is for the ticket product**********************************************8888
	
	 // for displaying all the tickets in the ticket jsp page.........................................................
	 
	 public List<Ticket> findAllTickets() throws DaoException {
	        
	    	Connection con = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        List<Ticket> tickets = new ArrayList<Ticket>();
	       
	        
	        try {
	        	//Get connectino object using the methos in the super class (Dao.java)...
	            con = this.getConnection();

	            String query = "SELECT * FROM TICKET";
	            ps = con.prepareStatement(query);
	            
	            //Using a PreparedStatement to execute SQL...
	            rs = ps.executeQuery();
	            while (rs.next()) {
	           
	                int ticketId = rs.getInt("TICKETID");
	                String name = rs.getString("EVENT_NAME");
	                String loc = rs.getString("EVENT_LOCATION");
	                String start = rs.getString("EVENT_STARTTIME");
	                String date = rs.getString("EVENT_DATE");
	                String price = rs.getString("EVENT_PRICE");
	                String quantity = rs.getString("QUANTITY_IN_STOCK");
	            
	                
	                Ticket t = new Ticket(ticketId,name, loc, start, date, price, quantity);
	                tickets.add(t);
	        }
	        } catch (SQLException e) {
	            throw new DaoException("findAllProducts() " + e.getMessage());
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
	        return tickets;     // may be empty
	    }
	 
	 
	 //*******************************88Admin is removing Albums from the shp and database*******************************8888
	 
	 // this one is for the adminuser to delete albums from the customer shop...............................................
	 
	 public int DeleteAlbumInfo(int code) throws DaoException {
			
		 
	 		Connection con = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        int p = 0;
//	       
	        try {
	            con = getConnection();

	            String query1 = "SELECT * FROM TRACK";
	            ps = con.prepareStatement(query1);
	            rs = ps.executeQuery();
	        	
	        	query1 = "DELETE FROM TRACK WHERE PRODUCTID=?";
	            ps = con.prepareStatement(query1);
	            ps.setInt(1, code);
	            
	            ps.execute();
	            
	            String query2 = "SELECT * FROM THEALBUMS";
	            ps = con.prepareStatement(query2);
	            rs = ps.executeQuery();
	            
	            query2 = "DELETE FROM THEALBUMS WHERE PRODUCTID=?";
	            ps = con.prepareStatement(query2);
	            ps.setInt(1, code);
	            
	            ps.execute();
	           
	        } catch (SQLException e) {
	            throw new DaoException("DeleteAlbumInfo " + e.getMessage());
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
	                throw new DaoException("DeleteAlbumInfo" + e.getMessage());
	            }
	        }
	        return p;
		 }
	 
	 
	 // to get a list of all the new releases that the admin can add to the customer shop.................................
	 
	 public List<Product> findAllNewProducts() throws DaoException {
	        
	    	Connection con = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        List<Product> products = new ArrayList<Product>();
	        int i = 0;
	        
	        try {
	        	//Get connectino object using the methos in the super class (Dao.java)...
	            con = this.getConnection();

	            String query = "SELECT * FROM NEWRELEASES";
	            ps = con.prepareStatement(query);
	            
	            //Using a PreparedStatement to execute SQL...
	            rs = ps.executeQuery();
	            while (rs.next()) {
	            	i++;
	                // int userId = rs.getInt("ID");
	                String cover = rs.getString("ALBUM_COVER");
	                String code = rs.getString("PRODUCTCODE");
	                String name = rs.getString("PRODUCT_NAME");
	                String genre = rs.getString("PRODUCT_GENRE");
	                String description = rs.getString("PRODUCT_DESC");
	                Double price = rs.getDouble("PRODUCT_PRICE");
	            
	                
	                Product u = new Product(i,cover, code, name, genre, description, price);
	                products.add(u);
	        }
	        } catch (SQLException e) {
	            throw new DaoException("findAllProducts() " + e.getMessage());
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
	        return products;     // may be empty
	    }
	 
	 // for the admin to add new releases to the shop by inserting them into the album table.......................................................
	 
	 public Product albumDetailsForNewRelease(String cover, String code, String name, String genre, String desc, Double price) throws DaoException {
			
		 
	 		Connection con = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        Product p = null;
//	        int i = 0;
	        
	        try {
	            con = getConnection();

	            String query = "SELECT * FROM THEALBUMS";
	            ps = con.prepareStatement(query);
	            rs = ps.executeQuery();
	           
	            query = "INSERT INTO THEALBUMS(SUPPLIERID,ALBUM_COVER,PRODUCTCODE,PRODUCT_NAME,PRODUCT_GENRE,PRODUCT_DESC,PRODUCT_PRICE) VALUES (?,?,?,?,?,?,?)";
	            ps = con.prepareStatement(query);
	            ps.setInt(1, 1);
	            ps.setString(2, cover);
	            ps.setString(3, code);
	            ps.setString(4, name);
	            ps.setString(5, genre);
	            ps.setString(6, desc);
	            ps.setDouble(7, price);
	            
	            ps.execute();
	                 
	                 p = new Product(1,cover, code, name, genre, desc, price);
	             
	      
	           
	        } catch (SQLException e) {
	            throw new DaoException("albumDetailsForNewRelease " + e.getMessage());
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
	                throw new DaoException("albumDetailsForNewRelease" + e.getMessage());
	            }
	        }
	        return p;
		 }
		
		
	 
	 
	
}
	       
	 


