package my.project.business_classes;

public class OrderItem {
	
//	private Order order;
//	private Product product;
//	private int quantity;
	private int orderId ;
	private int productId;
	
	public OrderItem(int orderItemOrderId, int orderItemProductId) {
		
//		this.quantity = quantity;
		orderId = orderItemOrderId;
		productId = orderItemProductId;
		
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

//	public Order getOrder() {
//		return order;
//	}
//
//	public void setOrder(Order order) {
//		this.order = order;
//	}
//
//	public Product getProduct() {
//		return product;
//	}
//
//	public void setProduct(Product product) {
//		this.product = product;
//	}
//
//	public int getQuantity() {
//		return quantity;
//	}
//
//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	}

	
	

}
