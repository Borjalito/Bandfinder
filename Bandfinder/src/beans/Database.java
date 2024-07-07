package beans;

import java.util.HashMap;
import java.util.Map;

public class Database {
	private Map<String, User> utenti;
	
	public Database() {
		this.utenti=new HashMap<>();
		utenti.put("admin", new User("admin", "admin"));
		utenti.put("admin2", new User("admin2", "admin2"));
		utenti.put("admin3", new User("admin3", "admin3"));
	}
	
	public User getUser(String username) {
		return this.utenti.get(username);
	}
	
	public  Map<String, User> getAllUsers() {
		return this.utenti;
	}
	
	public void addUser(User user) {
		this.utenti.put(user.getUsername(), user);
	}
	
	public void removeUser(String username) {
		this.utenti.remove(username);
	}
	
	public boolean userAndPasswordCheck(String username, String password) {
		boolean res=false;
		
		User u = this.utenti.get(username);
		if(u!=null) {
			if(u.getPassword().equals(password)){
				res=true;
			}
		}
		
		return res;
	}
}
