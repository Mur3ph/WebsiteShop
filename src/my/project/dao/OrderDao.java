package my.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import my.project.business_classes.Order;
import my.project.business_classes.OrderItem;
import my.project.business_classes.Product;



import my.project.exceptions.DaoException;

public class OrderDao extends Dao{
	
	public OrderDao(DataSource ds){
		super(ds);
		}
		
	public OrderDao(){
		super();
		}


	// putting customer id info from buying an album and date of transaction into my order table ..................................
	public Order CreateOrder(int id) throws DaoException {
		
		 
 		Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Order o = null;
        Product p = null;
      
        try {
        	// FIRST TABLE..........................
        	con = getConnection();
            String query = "SELECT * FROM THEORDER";
            ps = con.prepareStatement(query);
            
            rs = ps.executeQuery();
            
            query = "INSERT INTO THEORDER (CUSTOMERID,ORDERDATE) VALUES(?,now())";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
          
            ps.execute();
            
            query = "SELECT LAST_INSERT_ID()";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            
            int Id = 1;
            
            if (rs.next())
            	Id = rs.getInt(1);
            
            o = new Order(Id, id, "2012-04-09", p);
            
        } catch (SQLException e) {
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
        return o;
	 
	 }
	
	// continueation of above.........
	// when info put into that order table..............
	// the order and product info placed into this table innit........................
	
	public OrderItem CreateOrderItem(int id1, int id2) throws DaoException {
		
		 
 		Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        OrderItem oi = null;
         
        try {
            // SECOND TABLE.........................
            con = getConnection();
            String query = "SELECT * FROM ORDERITEM";
            ps = con.prepareStatement(query);
            
            rs = ps.executeQuery();
           
            query = "INSERT INTO ORDERITEM(ORDERID,PRODUCTID) VALUES(?,?) ";
            		
            ps = con.prepareStatement(query);
            ps.setInt(1, id1);
            ps.setInt(2, id2);
           
            ps.execute(); 

            oi = new OrderItem(id1, id2);
            
        } catch (SQLException e) {
            throw new DaoException("CustomerOrder2 " + e.getMessage());
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
        return oi;
	 
	 }
	
	// adanced sql used here for the admin to see who ordered what
	// and when....................................................
	
	public List<Order> getOrder(int id) throws DaoException {
        
    	Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Product p = null;
        List<Order> orders = new ArrayList<Order>();
//        int i = 0;
        
        try {
        	//Get connectino object using the methos in the super class (Dao.java)...
            con = this.getConnection();
            
            con = getConnection();
            String query = "SELECT * FROM THEORDER,ORDERITEM,THEALBUMS";
            ps = con.prepareStatement(query);
            
            rs = ps.executeQuery();
            
            

            query = "SELECT * FROM THEORDER,ORDERITEM,THEALBUMS WHERE THEORDER.CUSTOMERID=? AND THEORDER.ORDERID = ORDERITEM.ORDERID AND ORDERITEM.PRODUCTID = THEALBUMS.PRODUCTID";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
           
            //Using a PreparedStatement to execute SQL... + "AND CUSTOMERID = ?"
            rs = ps.executeQuery();
            while (rs.next()) {
//            	i++;
                int userId = rs.getInt("PRODUCTID");
                String cover = rs.getString("ALBUM_COVER");
                String code = rs.getString("PRODUCTCODE");
                String name = rs.getString("PRODUCT_NAME");
                String genre = rs.getString("PRODUCT_GENRE");
                String description = rs.getString("PRODUCT_DESC");
                Double price = rs.getDouble("PRODUCT_PRICE");
               
                
                int orderId = rs.getInt("ORDERID");
                int custId = rs.getInt("CUSTOMERID");
                String date = rs.getString("ORDERDATE");
                
//                ProductDao pd = new ProductDao();
//                pd.findAllProducts();
//               
//                Review oo = null;
                p = new Product(userId,cover, code, name, genre, description, price);
                
                Order o = new Order(orderId, custId, date, p);
                orders.add(o);
                
        }
        } catch (SQLException e) {
            throw new DaoException("findAllOrders() " + e.getMessage());
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
        return orders;     // may be empty
    }
	
	//and continued from above when the admnin sees the customer has paid or what not...............
	//the admin deletes all records from the database 3 tables ...........................
	
	public int DeleteOrder(int pid, int oid) throws DaoException {
		
		 
 		Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int o = 0;
        
      
        
        
        try {
        	// FIRST TABLE..........................
        	con = getConnection();
        	String query1 = "SELECT * FROM ORDERITEM";
            ps = con.prepareStatement(query1);
            rs = ps.executeQuery();
        	
        	query1 = "DELETE FROM ORDERITEM WHERE ORDERID=?";
            ps = con.prepareStatement(query1);
            ps.setInt(1, pid);
            
            ps.execute();
            
            String query2 = "SELECT * FROM THEORDER";
            ps = con.prepareStatement(query2);
            rs = ps.executeQuery();
            
            query2 = "DELETE FROM THEORDER WHERE ORDERID=?";
            ps = con.prepareStatement(query2);
            ps.setInt(1, oid);
            
            ps.execute();
            
            String query3 = "SELECT * FROM CUSTOMER";
            ps = con.prepareStatement(query3);
            rs = ps.executeQuery();
            
            query3 = "DELETE FROM CUSTOMER WHERE CUSTOMERID=?";
            ps = con.prepareStatement(query3);
            ps.setInt(1, pid);
            
            ps.execute();
            

           
            
        } catch (SQLException e) {
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
        return o;
	 
	 }
	
	
}
