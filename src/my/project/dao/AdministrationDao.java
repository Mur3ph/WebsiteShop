package my.project.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import my.project.business_classes.Administration;
import my.project.exceptions.DaoException;

public class AdministrationDao extends Dao{
	
	
	// CONSTRUCTORS FOR USERDAO CALLING THE DATASOURCE CLASS FOR THE TESTING.....................
	
		public AdministrationDao(DataSource ds){
			super(ds);
			}
			
		public AdministrationDao(){
			super();
			}

	
	
	// LOGIN the admin user, using parameters passed through mvc......................................................................................................................
	
		 public Administration findAdminByUsernamePassword(String uname, String pword) throws DaoException {

			 int i = 1;
			 
			 Connection con = null;
		        PreparedStatement ps = null;
		        ResultSet rs = null;
		        Administration a = null;
		        try {
		            con = getConnection();
		            //using java encrytion for the admin users password................................
		            String passwordHash = null;
					MessageDigest md5 = MessageDigest.getInstance("MD5");
					md5.update(pword.getBytes());
					passwordHash = new String(md5.digest());
		            
					//searching the db to see if user exists............................................
					
		            String query = "SELECT * FROM MYADMIN WHERE ADMINUSERNAME = ? AND ADMINPASSWORD = ?";
		            ps = con.prepareStatement(query);
		            ps.setString(1, uname);
		            ps.setString(2, passwordHash);
		            
		            rs = ps.executeQuery();
		            if (rs.next()) {
		            	
		                String username = rs.getString("adminUsername");
		                String password = rs.getString("adminPassword");
		                
		                a = new Administration(i, username, password);
		            }
		        } catch (SQLException | NoSuchAlgorithmException e) {
		            throw new DaoException("findAdminByUsernamePassword " + e.getMessage());
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
		                throw new DaoException("findAdminByUsernamePassword" + e.getMessage());
		            }
		        }
		        
		        return a;     
		    }

}
