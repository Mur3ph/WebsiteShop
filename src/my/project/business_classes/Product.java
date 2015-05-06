package my.project.business_classes;

public class Product{
	
	private int productId;
	private String cover;
	private String code;
	private String name;
	private String genre;
	private String description;
	private double price;
	private Review rev;


	public Product(int productId, String cover, String code, String name,
			String genre, String description, double price) {
		super();
		this.productId = productId;
		this.cover = cover;
		this.code = code;
		this.name = name;
		this.genre = genre;
		this.description = description;
		this.price = price;
		
	}

	public Product() {
		
		name = "";
		description = "";
		price = 0.0;
	}
	
	public String getProductComment(){
		return rev.getComment();
	}
	
	public String getProductDate(){
		return rev.getDate();
	}

	public int getProductId() {
		return productId;
	}



	public void setProductId(int productId) {
		this.productId = productId;
	}


	public String getGenre() {
		return genre;
	}



	public void setGenre(String genre) {
		this.genre = genre;
	}



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	

	


	@Override
	public String toString() {
		return "Product [cover=" + cover + ", code=" + code + ", name=" + name
				+ ", genre=" + genre + ", description=" + description
				+ ", price=" + price + "]";
	}



	

	

	
	
}
