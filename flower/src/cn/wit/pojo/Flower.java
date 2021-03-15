package cn.wit.pojo;

public class Flower {
	private int id;
	private String name;
	private float price;
	private String production;
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
	public float getPrice() {
		return price;
	}
	public void setPrice(double price2) {
		this.price = (float) price2;
	}
	public String getProduction() {
		return production;
	}
	public void setProduction(String production) {
		this.production = production;
	}
	@Override
	public String toString() {
		return "Flower [id=" + id + ", name=" + name + ", price=" + price + ", production=" + production + "]";
	}
	public Flower(int id, String name, float price, String production) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.production = production;
	}
	public Flower() {
		super();
	}
	
	
	
	
	
	
}
