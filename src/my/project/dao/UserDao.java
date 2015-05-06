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

import my.project.business_classes.User;
import my.project.exceptions.DaoException;

public class UserDao extends Dao{

// CONSTRUCTORS FOR USERDAO CALLING THE DATASOURCE CLASS FOR THE TESTING.....................
	
	public UserDao(DataSource ds){
		super(ds);
		}
		
	public UserDao(){
		super();
		}

	// REGISTER USER..............................................................................................................

	public User CreateUser(String firstname, String lastname, String email, String username, String password) throws DaoException {


		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User u = null;
		int i = 1;


		try {
			
			// USING JAVA MD5 ENCRYPTION ON THE USER PASSWORD BEING REGISTERED...........................

			String passwordHash = null;
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(password.getBytes());
			passwordHash = new String(md5.digest());

			con = getConnection();
			String query = "SELECT * FROM THEUSER";
			ps = con.prepareStatement(query);

			rs = ps.executeQuery();
			if (rs.next()) {
				i++;
			}
			
			// INSERTING THE USERS DETAILS ONTO THE USER TABLE................................................
			
			query = "INSERT INTO THEUSER(FIRSTNAME,LASTNAME,EMAILADDRESS,USERNAME,PASSWORD) VALUES (?, ?, ?, ?, ?)";
			ps = con.prepareStatement(query);
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, email);
			ps.setString(4, username);
			ps.setString(5, passwordHash);

			ps.execute();


			u = new User(i, firstname, lastname, email, username, passwordHash);

		} catch (SQLException | NoSuchAlgorithmException e) {
			throw new DaoException("CreateUser " + e.getMessage());
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
		return u;

	}


	//LOGIN USER........................................................................................................

	public User findUserByUsernamePassword(String uname, String pword) throws DaoException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User u = null;
		try {
			con = getConnection();

			// BECAUSE ALL THE PASSWORDS ARE ENCRYPTED I HAVE TO USE THE JAVA MD5 ENCRYPTION TO LOG THE USER IN.............
			
			String passwordHash = null;
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(pword.getBytes());
			passwordHash = new String(md5.digest());

			String query = "SELECT * FROM THEUSER WHERE USERNAME = ? AND PASSWORD = ?";
			ps = con.prepareStatement(query);
			ps.setString(1, uname);
			ps.setString(2, passwordHash);

			rs = ps.executeQuery();
			if (rs.next()) {

				int userId = rs.getInt("UserID");
				String firstname = rs.getString("firstName");
				String lastname = rs.getString("lastName");
				String emailAddress = rs.getString("emailAddress");
				String username = rs.getString("userName");
				String password = rs.getString("password");

				u = new User(userId, firstname, lastname, emailAddress,username, password);
			}
		} catch (SQLException | NoSuchAlgorithmException e) {
			throw new DaoException("findUserByUsernamePassword " + e.getMessage());
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

		return u;     
	}


	//UPDATE USERS PASSWORD........................................................................................................


	public User UpdateUser(String oldpassword, String newpassword) throws DaoException {


		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User u = null;



		try {

			// CHANGING THE USERS OLD ENCRYPTED PASSWORD FOR A NEW ENCRYPTED PASSWORD............................
			
			String passwordHash1 = null;
			MessageDigest md51 = MessageDigest.getInstance("MD5");
			md51.update(oldpassword.getBytes());
			passwordHash1 = new String(md51.digest());

			String passwordHash2 = null;
			MessageDigest md52 = MessageDigest.getInstance("MD5");
			md52.update(newpassword.getBytes());
			passwordHash2 = new String(md52.digest());

			con = getConnection();
			String query = "SELECT * FROM THEUSER WHERE PASSWORD=?";
			ps = con.prepareStatement(query);
			ps.setString(1, passwordHash1);

			rs = ps.executeQuery(); 

			query = "UPDATE THEUSER SET PASSWORD=? WHERE PASSWORD=?";
			ps = con.prepareStatement(query);

			ps.setString(1, passwordHash2);
			ps.setString(2, passwordHash1);

			ps.execute();
			if (rs.next()) {
				int userId = rs.getInt("UserID");
				String firstname = rs.getString("firstName");
				String lastname = rs.getString("lastName");
				String email = rs.getString("emailAddress");
				String username = rs.getString("userName");


				u = new User(userId,firstname, lastname, email, username, passwordHash2);
			}
		} catch (SQLException | NoSuchAlgorithmException e) {
			throw new DaoException("UpdateUser " + e.getMessage());
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
				throw new DaoException("UpdateUser" + e.getMessage());
			}
		}
		return u;




	}

	// DELETING THE USERS DETAILS FROM THE DATABASE..........................................................

	public User DeleteUser(String firstname, String lastname, String email, String username) throws DaoException {


		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User u = null;
		int i = 1;



		try {
			con = getConnection();
			String query = "SELECT * FROM THEUSER";
			ps = con.prepareStatement(query);

			rs = ps.executeQuery();

			query = "DELETE FROM THEUSER WHERE USERNAME=?";
			ps = con.prepareStatement(query);

			ps.setString(1, username);

			ps.execute();

			String password = null;

			u = new User(i, firstname, lastname, email, username, password);

		} catch (SQLException e) {
			throw new DaoException("DeleteUser " + e.getMessage());
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
				throw new DaoException("DeleteUser" + e.getMessage());
			}
		}
		return u;
	}


// checking to see if the user name exists or not ................................................
	
	public int findUserName(String username){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int check = 0;

		try {
			con = getConnection();

			String query = "SELECT USERNAME FROM THEUSER WHERE USERNAME=?";
			ps = con.prepareStatement(query);
			ps.setString(1, username); 

			rs = ps.executeQuery();

			if (rs.next()) {
				check = 1;
			}else{
				check = 0;
			}
		} catch (SQLException e) {

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

			}
		}
		return check;     
	}

// getting a list of all the users for the admin to sort or look at whos who.............................

	public List<User> findUserName1(String username) throws DaoException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User u = null;
		List<User> users = new ArrayList<User>();

		try {
			//Get connectino object using the methos in the super class (Dao.java)...
			con = this.getConnection();

			String query = "SELECT USERNAME FROM THEUSER WHERE USERNAME=?";
			ps = con.prepareStatement(query);
			ps.setString(1, username); 

			//Using a PreparedStatement to execute SQL...
			rs = ps.executeQuery();
			while (rs.next()) {

				int id = rs.getInt("USERID");
				String firstname = rs.getString("FIRSTNAME");
				String lastname = rs.getString("LASTNAME");
				String username1 = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				String email = rs.getString("EMAIL");


				u = new User(id, firstname, lastname, username1, password, email);
				users.add(u);
			}
		} catch (SQLException e) {
			throw new DaoException("findUserName() " + e.getMessage());
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
		return users;     // may be empty
	}



	public static void main(String[] args) {

		UserDao u = new UserDao();
		String username = null;
		u.findUserName(username);

		System.out.println(u.findUserName(username));

	}

}
