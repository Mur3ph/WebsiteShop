package my.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import my.project.business_classes.Review;
import my.project.exceptions.DaoException;

public class ReviewDao extends Dao{
	
	public ReviewDao(DataSource ds){
		super(ds);
		}
		
	public ReviewDao(){
		super();
		}
	
	//findAllReviews
	
	// for the public to make comments on the prodducts or albums in the shop fro sale.............................
	
	 public List<Review> findAllReviews(int code, String comment) throws DaoException {
	        
	    	Connection con = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        List<Review> reviews = new ArrayList<Review>();
	        
	        try {
	        	//Get connectino object using the methos in the super class (Dao.java)...
	            con = this.getConnection();

	            String query = "SELECT * FROM REVIEW";
	            ps = con.prepareStatement(query);
	            
	            query = "INSERT INTO REVIEW(PRODUCTID,MESSAGE,REVIEWDATE)VALUES (?,?,now())";
	            ps = con.prepareStatement(query);
				ps.setInt(1, code);
				ps.setString(2, comment);
				ps.execute();
				
				query = "SELECT * FROM REVIEW WHERE PRODUCTID=?";
				ps = con.prepareStatement(query);
				ps.setInt(1, code);
	            
	            //Using a PreparedStatement to execute SQL...
	            rs = ps.executeQuery();
	            while (rs.next()) {
	            	
	                // int userId = rs.getInt("ID");
	                int revId = rs.getInt("REVIEWID");
	                int prodId = rs.getInt("PRODUCTID");
	                String message = rs.getString("MESSAGE");
	                String date = rs.getString("REVIEWDATE");
	          
	                Review r = new Review(revId, prodId, message, date);
	                reviews.add(r);
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
	        return reviews;     // may be empty
	    }

}
