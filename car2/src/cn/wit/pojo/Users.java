package cn.wit.pojo;

import java.util.List;

public class Users {
	private int id;
	private String username;
	private String password;
	private int rid;
	private List<Car> cars;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public List<Car> getCars() {
		return cars;
	}
	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password=" + password + ", rid=" + rid + ", cars="
				+ cars + "]";
	}
	public Users(int id, String username, String password, int rid, List<Car> cars) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.rid = rid;
		this.cars = cars;
	}
	public Users() {
		super();
	}
	public Users(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
		
}
