package beans;

public class User {
	String username;
	String password;
	boolean logged;
	
	public User(String username, String password) {
		this.username=username;
		this.password=password;
		this.logged=false;
	}

	public boolean getLogged(){
		return logged;
	}

	public void setLogged(boolean logged){
		this.logged=logged;
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
	
}
