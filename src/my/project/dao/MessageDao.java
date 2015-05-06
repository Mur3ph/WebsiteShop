package my.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import my.project.business_classes.Message;
import my.project.exceptions.DaoException;

public class MessageDao extends Dao{
	
	public MessageDao(DataSource ds){
		super(ds);
		}
		
	public MessageDao(){
		super();
		}


	//here i set up a mess table with a trigger to find All user that Deleted them selves.....
	// and storing that info in this table for the admin to see..........................
	
	 public List<Message> findAllDeletedUsers() throws DaoException {
	        
	    	Connection con = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        List<Message> messages = new ArrayList<Message>();
	        
	        try {
	        	//Get connectino object using the methos in the super class (Dao.java)...
	            con = this.getConnection();

	            String query = "SELECT * FROM MESSAGE";
	            ps = con.prepareStatement(query);
	            
	           
	            
	            //Using a PreparedStatement to execute SQL...
	            rs = ps.executeQuery();
	            while (rs.next()) {
	            	
	                // int userId = rs.getInt("ID");
	                int messId = rs.getInt("MESSAGEID");
	                String message = rs.getString("MESSAGE");
	                String first = rs.getString("FNAME");
	                String last = rs.getString("LNAME");
	                String date = rs.getString("MESSAGE_TIME");
	          
	                Message m = new Message(messId, message, first, last, date);
	                messages.add(m);
	        }
	        } catch (SQLException e) {
	            throw new DaoException("findAllReviews() " + e.getMessage());
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
	        return messages;     // may be empty
	    }

	
}
