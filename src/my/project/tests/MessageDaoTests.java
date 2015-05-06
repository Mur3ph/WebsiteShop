package my.project.tests;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import my.project.business_classes.Message;
import my.project.dao.MyProjectDatasource;
import my.project.dao.MessageDao;
import my.project.exceptions.DaoException;

import org.junit.Before;
import org.junit.Test;

public class MessageDaoTests {
	
	private MessageDao msgDao;
	private MyProjectDatasource dataSource;
	
	@Before
	public void setUp() throws Exception {
		dataSource = new MyProjectDatasource();
		msgDao = new MessageDao(dataSource);
	}
	
	//TESTER THE MESSAGE SENT TO ADMIN WHEN USER DELETES PROFILE.....................................................
	
	@Test
	public void testfindAllDeletedUsers() throws DaoException {
		List<Message> msg = msgDao.findAllDeletedUsers();
		// if user is null then message will be print
		assertNotNull("This function is not working properly testfindAllDeletedUsers", msg);
	}

}
