package cn.wit.pojo;

import java.util.List;

public class Menu {
	private int id;
	private String name;
	private int pid;
	private List<Menu> children;
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
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public List<Menu> getChildren() {
		return children;
	}
	public void setChildren(List<Menu> children) {
		this.children = children;
	}
	@Override
	public String toString() {
		return "Menu [id=" + id + ", name=" + name + ", pid=" + pid + ", children=" + children + "]";
	}
	public Menu(int id, String name, int pid, List<Menu> children) {
		super();
		this.id = id;
		this.name = name;
		this.pid = pid;
		this.children = children;
	}
	public Menu() {
		super();
	}
	
}
