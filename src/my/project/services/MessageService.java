package my.project.services;

import java.util.List;

import my.project.business_classes.Message;
import my.project.dao.MessageDao;
import my.project.exceptions.DaoException;

public class MessageService {
	
private MessageDao msgDao;
	
	public MessageService(MessageDao msgDao){
		this.msgDao = msgDao;
	}
	
	public MessageService(){
		this.msgDao = new MessageDao();
	}
	
	// FOR THE ADMIN USE TO SEE WHICH USER DELETED THEMSELVES FROM THE DB....................................
	
public List<Message> getAllDeletedUsers(){
		
		List<Message> messages = null;
		
		try {
			//MessageDao dao = new MessageDao();
			messages = msgDao.findAllDeletedUsers();
		} 
		catch (DaoException e) {
			e.printStackTrace();
		}
		return messages;

}
}