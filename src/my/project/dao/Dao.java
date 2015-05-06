package my.project.dao;

import java.sql.Connection;

import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import my.project.exceptions.DaoException;

public class Dao extends DaoUtil{
	
	private DataSource datasource;
	
	public Dao(DataSource ds){
		this.datasource = ds;
	}
	
	// here i have the methods for the connection pooling set up and the methods for data sourse.................................
	// data getting the connection and 
			public Dao(){
				
				String DATASOURCE_CONTEXT = "java:comp/env/jdbc/test";
				Context initialContext;
				DataSource ds=null;
				try {
					initialContext = new InitialContext();
					ds = (DataSource)initialContext.lookup(DATASOURCE_CONTEXT);
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if (ds == null) {
				System.out.println(("Failed to lookup datasource."));
				}
				else {
				datasource = ds;
				}
			}
	
			
			public Connection getConnection()
				{	
				Connection conn = null;
				
				try {
					return datasource.getConnection();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return conn;
			}

	   
			public void freeConnection(Connection con) throws DaoException {
		        try {
		            if (con != null) {
		                con.close();
		                con = null;
		            }
		        } catch (SQLException e) {
		            System.out.println("Failed to free connection: " + e.getMessage());
		            System.exit(1);
		        }
		    }

	

}
