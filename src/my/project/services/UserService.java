package my.project.services;


import java.util.List;
import my.project.business_classes.User;
import my.project.dao.UserDao;
import my.project.exceptions.DaoException;

public class UserService {

	
	
	private UserDao userDao;
	
	public UserService(UserDao userDao){
		this.userDao = userDao;
	}
	
	public UserService(){
		this.userDao = new UserDao();
	}
	
	// FOR THE USER TO REGISTER THERE INFO TO DB................................................................

	public User register(String firstname, String lastname, String email, String username, String password){
			
			User u = null;
			
			try{ 
				//UserDao dao = new UserDao();
				u = userDao.CreateUser(firstname, lastname, email, username, password);
			}
			catch (DaoException e) {
				e.printStackTrace();
			}
			
			return u;
		}
	
	// LOGGING THE USER IN IF THE INFO EXISTS.......................................................
	
		public User Login(String username, String password){
				
				User u = null;
				
				//UserDao dao = new UserDao();
				try {
					u = userDao.findUserByUsernamePassword(username, password);
				} catch (DaoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				return u;
				
			}
		
		// USER UPDATING OR CHANGING THEIR PASSWORD..........................................................
	
		public User update(String oldpassword, String newpassword){
			
			User u = null;
			
			try{ 
				//UserDao dao = new UserDao();
				u = userDao.UpdateUser(oldpassword, newpassword);
			}
			catch (DaoException e) {
				e.printStackTrace();
			}
			return u;
		}
		
		//USER ABLE TO DELETE OR REMOVE THEIR OWN INFO.................................................
		
		public User delete(String firstname, String lastname, String email, String username){
			
			User u = null;
			
			try{ 
				//UserDao dao = new UserDao();
				u = userDao.DeleteUser(firstname, lastname, email, username);
			}
			catch (DaoException e) {
				e.printStackTrace();
			}
			return u;
		}
		
		//CHECKING TO SEE IF THIS USERNAME EXISTS OR NOT................................................
		
		public int findUserName(String username){
			
			int find = 0;
			
			//UserDao dao = new UserDao();
			find = userDao.findUserName(username);
			
			return find;
		
		}
		
		//GETTING A LIST OF USERS ON DB FOR THE ADMIN.....................................................
		
		public List<User> findUserName1(String username){
			
			List<User> users = null;
			
			try {
				//UserDao dao = new UserDao();
				users = userDao.findUserName1(username);
			} 
			catch (DaoException e) {
				e.printStackTrace();
			}
			return users;
			
	}
	
	
	public static void main(String[] args) {
		
		

	}

}
