package cn.wit.pojo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class People {
	private int id;
	private String name;
	private Set<String>set;
	private String[]array;
	private List<String>list;
	private Map<String,String>map;
	private Programmer programmer;
	
	
	public People(int id, String name, Set<String> set, String[] array, List<String> list, Map<String, String> map,
			Programmer programmer) {
		super();
		this.id = id;
		this.name = name;
		this.set = set;
		this.array = array;
		this.list = list;
		this.map = map;
		this.programmer = programmer;
	}
	@Override
	public String toString() {
		return "People [id=" + id + ", name=" + name + ", set=" + set + ", array=" + Arrays.toString(array) + ", list="
				+ list + ", map=" + map + ", programmer=" + programmer + "]";
	}
	public Programmer getProgrammer() {
		return programmer;
	}
	public void setProgrammer(Programmer programmer) {
		this.programmer = programmer;
	}
	public Set<String> getSet() {
		return set;
	}
	public void setSet(Set<String> set) {
		this.set = set;
	}
	public String[] getArray() {
		return array;
	}
	public void setArray(String[] array) {
		this.array = array;
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	public Set<String> getSets() {
		return set;
	}
	public void setSets(Set<String> sets) {
		this.set = sets;
	}
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
	
	
	public People() {
		super();
	}
	
	
}
