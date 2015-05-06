package my.project.services;

import my.project.business_classes.Administration;
import my.project.dao.AdministrationDao;


import my.project.exceptions.DaoException;

public class AdministrationService {
	
	
private AdministrationDao adminDao;
	
	public AdministrationService(AdministrationDao adminDao){
		this.adminDao = adminDao;
	}
	
	public AdministrationService(){
		this.adminDao = new AdministrationDao();
	}
	
	
	// LOGGING THE ADMIN USER ON WITH PASSING PARAMETERS............................
	
	public Administration Login(String username, String password){
		
		Administration a = null;
		
		//AdministrationDao dao = new AdministrationDao();
		try {
			a = adminDao.findAdminByUsernamePassword(username, password);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return a;
		
	}

}
