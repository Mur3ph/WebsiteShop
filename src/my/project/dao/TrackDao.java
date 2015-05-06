package my.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import my.project.business_classes.Track;
import my.project.exceptions.DaoException;

public class TrackDao extends Dao{
	
	public TrackDao(DataSource ds){
		super(ds);
		}
		
	public TrackDao(){
		super();
		}
	
	// used to display the tracks of all the albums ithat are in the shop........................................
	
	public List<Track> findAllAlbumTracks(int id) throws DaoException {
        
    	Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Track> tracks = new ArrayList<Track>();
        int i = 0;
        int x = 0;
        
        try {
        	//Get connectino object using the methos in the super class (Dao.java)...
            con = this.getConnection();

            String query = "SELECT * FROM TRACK WHERE PRODUCTID=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            
            //Using a PreparedStatement to execute SQL...
            rs = ps.executeQuery();
            while (rs.next()) {
            	i++;
            	x++;
                String name = rs.getString("TRACK_NAME");
                String duration = rs.getString("TRACK_DURATION");
               
            
                
                Track t = new Track(i, x, name, duration);
                tracks.add(t);
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
        return tracks;     // may be empty
    }

}
