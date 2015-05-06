package my.project.dao;


import java.sql.ResultSet;
import java.sql.SQLException;




import com.mysql.jdbc.Statement;

public class DaoUtil{
	
	// here i was trig to cut down on the size of the code in other daos................
	// two worked the other wouldnt for smre reason.............................
	
	    
	    public static void closePreparedStatement(Statement ps)
	    {
	        try
	        {
	            if (ps != null)
	                ps.close();
	        }
	        catch(SQLException e)
	        {
	            e.printStackTrace();
	        }
	    }

	    public static void closeResultSet(ResultSet rs){
	    	 
	    	try {
	            	
	                if (rs != null) 
	                    rs.close();
	                }
	        catch(SQLException e)
	        {
	            e.printStackTrace();
	        }
	   
	   
	    
	    }
	    
	    
//	    public static void closeConnection(Connection con){
//	    	
//	    	try{
//	    			
//	    			  if (con != null) 
//		                    freeConnection(con);
//		        }
//	    			  
//	    			catch(SQLException e)
//			        {
//			            e.printStackTrace();
//			        }
//	    		
//}
	    }

	

