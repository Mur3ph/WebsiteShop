package my.project.tests;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import my.project.business_classes.Message;
import my.project.dao.MyProjectDatasource;
import my.project.dao.MessageDao;
import my.project.services.MessageService;

import org.junit.Before;
import org.junit.Test;

public class MessageServiceTests {
	
	private MessageDao msgDao;
	private MessageService msgService;
	private MyProjectDatasource dataSource;
	
	@Before
	public void setUp() throws Exception {
		
		dataSource = new MyProjectDatasource();
		msgDao = new MessageDao(dataSource);
		msgService = new MessageService(msgDao);
	}
	
	//TESTING THE USER SERVICE REGISTER..........................................
	
	@Test
	public void testgetAllDeletedUsers(){

		List<Message> msg = msgService.getAllDeletedUsers();
		// if user is null then message will be print
		assertNotNull("This function is not working properly testgetAllDeletedUsers", msg);
		
	}

}
