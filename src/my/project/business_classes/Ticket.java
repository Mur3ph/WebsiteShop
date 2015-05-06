package my.project.business_classes;

public class Ticket {
	
	private int ticketId;
	private String name;
	private String location;
	private String startTime;
	private String date;
	private String price; 
	private String quantityInStock;
	
	
	public Ticket(int ticketId, String name, String location, String startTime,
			String date, String price, String quantityInStock) {
	
		this.ticketId = ticketId;
		this.name = name;
		this.location = location;
		this.startTime = startTime;
		this.date = date;
		this.price = price;
		this.quantityInStock = quantityInStock;
	}
	
	
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getQuantityInStock() {
		return quantityInStock;
	}
	public void setQuantityInStock(String quantityInStock) {
		this.quantityInStock = quantityInStock;
	}
	
	
	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", name=" + name
				+ ", location=" + location + ", startTime=" + startTime
				+ ", date=" + date + ", price=" + price + ", quantityInStock="
				+ quantityInStock + "]";
	}
	
	

}
