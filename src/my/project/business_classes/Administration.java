package my.project.business_classes;

public class Administration {
	
	private int adminId;
	private String adminUsername;
	private String adminPassword;
	
	
	public Administration(int adminId, String adminUsername, String adminPassword) {

		this.adminId = adminId;
		this.adminUsername = adminUsername;
		this.adminPassword = adminPassword;
	}


	public int getAdminId() {
		return adminId;
	}


	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}


	public String getAdminUsername() {
		return adminUsername;
	}


	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}


	public String getAdminPassword() {
		return adminPassword;
	}


	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}


	@Override
	public String toString() {
		return "Administration [adminId=" + adminId + ", adminUsername="
				+ adminUsername + ", adminPassword=" + adminPassword + "]";
	}
	
	
	

}
