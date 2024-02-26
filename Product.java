package btvn22;

public class Product extends Category {
	 Long id;
	 String productname;
	 Double price;
	 Integer quantity;
	 Category category;

	public Product(String name, Long id, String productname, Double price, Integer quantity, Category category) {
		super(name);
		this.id = id;
		this.productname = productname;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
	}
	public Product(String name, Long id, Double price, Integer quantity, Category category) {
		super(name);
		this.id = id;
		this.productname = name;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productname=" + productname + ", price=" + price + ", quantity=" + quantity
				+ ", category=" + category + "]";
	}
}
