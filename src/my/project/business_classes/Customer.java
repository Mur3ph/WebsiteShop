package my.project.business_classes;


public class Customer{
	
	private int customerId;
	private String firstName;
	private String lastName;
	private String address1;
	private String address2;
	private String city;
	private String county;
	private String country;
	private String zip;
	private String phone;
	private String cardType;
	private String cardNumber;
	private String cardIdNumber;
	private String validUntil;
	
	

	public Customer(int customerId, String firstName, String lastName,
			String address1, String address2, String city, String county,
			String country, String zip, String phone, String cardType,
			String cardNumber, String cardIdNumber, String validUntil) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.county = county;
		this.country = country;
		this.zip = zip;
		this.phone = phone;
		this.cardType = cardType;
		this.cardNumber = cardNumber;
		this.cardIdNumber = cardIdNumber;
		this.validUntil = validUntil;
	}
	


	public int getCustomerId() {
		return customerId;
	}




	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}




	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardIdNumber() {
		return cardIdNumber;
	}

	public void setCardIdNumber(String cardIdNumber) {
		this.cardIdNumber = cardIdNumber;
	}

	public String getValidUntil() {
		return validUntil;
	}

	public void setValidUntil(String validUntil) {
		this.validUntil = validUntil;
	}



	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", address1="
				+ address1 + ", address2=" + address2 + ", city=" + city
				+ ", county=" + county + ", country=" + country + ", zip="
				+ zip + ", phone=" + phone + ", cardType=" + cardType
				+ ", cardNumber=" + cardNumber + ", cardIdNumber="
				+ cardIdNumber + ", validUntil=" + validUntil + "]";
	}
	
	
	
	
	

}
