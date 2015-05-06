package my.project.business_classes;



public class Order {
	
//	private Customer customer;
	private int orderId;
	private String date;
	private int OrdercustId;
	private Product product;
	
	public Order(int orderId, int custId, String date, Product prod) {
		
		this.orderId = orderId;
		OrdercustId = custId;
		this.date = date;
		product = prod;
	}
	
	
	public int getOrderCustId() {
		return OrdercustId;
	}


	public void setOrderCustId(int OrdercustId) {
		this.OrdercustId = OrdercustId;
	}


	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
//	public Customer getCustomer() {
//		return customer;
//	}
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}
	
	public String getProductNameOrdered(){
		return product.getName();
	}
	
	public Double getProductPriceOrdered(){
		return product.getPrice();
	}
	
	
}
