package my.project.tests;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import my.project.business_classes.Track;
import my.project.dao.MyProjectDatasource;
import my.project.dao.TrackDao;
import my.project.services.TrackService;

import org.junit.Before;
import org.junit.Test;

public class TrackServiceTests {
	
	private TrackDao tDao;
	private TrackService tService;
	private MyProjectDatasource dataSource;
	
	@Before
	public void setUp() throws Exception {
		
		dataSource = new MyProjectDatasource();
		tDao = new TrackDao(dataSource);
		tService = new TrackService(tDao);
	}
	
	//TESTING THE USER SERVICE REGISTER..........................................
	
	@Test
	public void testgetAllTracks(){

		List<Track> t = tService.getAllTracks(1);
		// if user is null then message will be print
		assertNotNull("This function is not working properly testgetAllTracks", t);
		
	}

}
