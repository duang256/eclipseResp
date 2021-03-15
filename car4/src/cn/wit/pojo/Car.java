package cn.wit.pojo;

public class Car {
	private int id;
	private String name;
	private int price;
	private String slogan;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getSlogan() {
		return slogan;
	}
	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", price=" + price + ", slogan=" + slogan + "]";
	}
	public Car(int id, String name, int price, String slogan) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.slogan = slogan;
	}
	public Car() {
		super();
	}
	
	
}
