package btl;

public class User {
	
	private String name;
	private String password;
	
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return name + " " + password;
	}
	public User() {
		super();
	}
	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	
	
}
