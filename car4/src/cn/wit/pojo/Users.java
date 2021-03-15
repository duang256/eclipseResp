package cn.wit.pojo;

import java.util.List;

public class Users {
	private int id;
	private String username;
	private String password;
	private int rid;
	private List<Car> list;
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
	public List<Car> getList() {
		return list;
	}
	public void setList(List<Car> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password=" + password + ", rid=" + rid + ", list="
				+ list + "]";
	}
	public Users(int id, String username, String password, int rid, List<Car> list) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.rid = rid;
		this.list = list;
	}
	public Users(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public Users() {
		super();
	}
	
}
