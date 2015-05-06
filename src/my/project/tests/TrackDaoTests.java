package my.project.tests;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import my.project.business_classes.Track;
import my.project.dao.MyProjectDatasource;
import my.project.dao.TrackDao;
import my.project.exceptions.DaoException;

import org.junit.Before;
import org.junit.Test;

public class TrackDaoTests {
	
	private TrackDao tDao;
	private MyProjectDatasource dataSource;
	
	@Before
	public void setUp() throws Exception {
		dataSource = new MyProjectDatasource();
		tDao = new TrackDao(dataSource);
	}
	
	//TESTER THE USER REGISTER.....................................................
	
	@Test
	public void testfindAllAlbumTracks() throws DaoException {
		List<Track> t = tDao.findAllAlbumTracks(1);
		// if user is null then message will be print
		assertNotNull("This function is not working properly testfindAllAlbumTracks", t);
	}

}
