package my.project.business_classes;


public class User{

	
	private int UserID;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String userName;
	private String password;
	
	
	public User(){
		UserID++;
		 firstName = "";
	        lastName = "";
	        emailAddress = "";
	        userName = "";
	        password = "";
	}
	




	public User(int userID, String firstName, String lastName,
			String emailAddress, String userName, String password) {
		
		UserID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.userName = userName;
		this.password = password;
	}
	
	public User(String userName, String password) {

		this.userName = userName;
		this.password = password;
		
	}
	


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public int getUserID() {
	return UserID;
}

public void setUserID(int userID) {
	UserID = userID;
}



	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}





	@Override
	public String toString() {
		return "User [UserID=" + UserID + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", emailAddress=" + emailAddress
				+ ", userName=" + userName + ", password=" + password + "]";
	}
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
