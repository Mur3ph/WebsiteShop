package my.project.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import my.project.business_classes.Track;
import my.project.services.TrackService;

public class ListAllTracksForAlbumCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		
		TrackService trackService = new TrackService();
		String forwardToJsp = "";
		HttpSession session = request.getSession();
		
		String prod_id = request.getParameter("id");
		
		
		//getting a list of album tracks that corespond to the albums id.....................
		List<Track> tracks = new ArrayList<Track>();
		tracks = trackService.getAllTracks(Integer.parseInt(prod_id));

		//Put the list of tracks into the session so that JSP(the View) can pick them up and display them...
		session.setAttribute("tracks", tracks);
		forwardToJsp = "/album_tracks.jsp";	

		return forwardToJsp;


	}

}
