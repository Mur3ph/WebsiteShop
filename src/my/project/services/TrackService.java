package my.project.services;

import java.util.List;

import my.project.business_classes.Track;
import my.project.dao.TrackDao;
import my.project.exceptions.DaoException;

public class TrackService {
	
private TrackDao tDao;
	
	public TrackService(TrackDao tDao){
		this.tDao = tDao;
	}
	
	public TrackService(){
		this.tDao = new TrackDao();
	}
	
	// ALL THE SONGS ON EACH ALBUM DISPLAYED INDIVIDUALLY.........................................
	
public List<Track> getAllTracks( int id){
		
		List<Track> tracks = null;
		
		try {
			//TrackDao dao = new TrackDao();
			tracks = tDao.findAllAlbumTracks(id);
		} 
		catch (DaoException e) {
			e.printStackTrace();
		}
		return tracks;
		
}

}
