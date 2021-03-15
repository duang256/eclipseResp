package cn.wit.pojo;

public class Programmer {
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Programmer [name=" + name + ", age=" + age + "]";
	}
	public Programmer(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Programmer() {
		super();
	}
	
}
