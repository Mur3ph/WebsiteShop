package my.project.business_classes;

public class Message {

	private int messageId;
	private String message;
	private String first;
	private String last;
	private String date;
	
	

	public Message(int messageId, String message, String first, String last,
			String date) {
		
		this.messageId = messageId;
		this.message = message;
		this.first = first;
		this.last = last;
		this.date = date;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", message=" + message
				+ ", first=" + first + ", last=" + last + "]";
	}
	
	
	
}
