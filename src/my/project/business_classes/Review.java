package my.project.business_classes;

public class Review {
	
	private int reviewId;
	private int albumId;
	private String comment;
	private String date;
	
	
	public Review(int reviewId, int albumId, String comment, String date) {

		this.reviewId = reviewId;
		this.albumId = albumId;
		this.comment = comment;
		this.date = date;
	}


	public int getReviewId() {
		return reviewId;
	}


	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}


	public int getAlbumId() {
		return albumId;
	}


	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}
	
	

}
