package cn.wit.pojo;

public class Users {
	private int id;
	private String username;
	private String password;
	private String photo;
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
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Users(int id, String username, String password, String photo) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.photo = photo;
	}
	public Users() {
		super();
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password=" + password + ", photo=" + photo + "]";
	}
	
}
