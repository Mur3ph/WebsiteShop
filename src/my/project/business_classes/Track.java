package my.project.business_classes;

public class Track {

	private int trackId;
	private int albumId;
	private String name;
	private String duration;
	
	public Track(int trackId, int albumId, String name, String duration) {
		super();
		this.trackId = trackId;
		this.albumId = albumId;
		this.name = name;
		this.duration = duration;
	}



	public int getTrackId() {
		return trackId;
	}



	public void setTrackId(int trackId) {
		this.trackId = trackId;
	}



	public int getAlbumId() {
		return albumId;
	}



	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDuration() {
		return duration;
	}



	public void setDuration(String duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Track [trackId=" + trackId + ", albumId=" + albumId + ", name="
				+ name + ", duration=" + duration + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}



	
	
	

}
