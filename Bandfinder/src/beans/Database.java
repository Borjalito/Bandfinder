package beans;

import java.util.HashMap;
import java.util.Map;

import model.Progetto;
import model.Utente;

public class Database {
	private Map<String, User> utenti;
	private Map<String, Utente> beatlinkUtenti;
	private Map<String, Progetto> progetti;
	
	public Database() {
		this.utenti=new HashMap<>();
		utenti.put("admin", new User("admin", "admin"));
		utenti.put("admin2", new User("admin2", "admin2"));
		utenti.put("admin3", new User("admin3", "admin3"));
	}
	
	public Progetto getProgetto(String id) {
		return this.progetti.get(id);
	}
	
	public  Map<String, Progetto> getAllProgetti() {
		return this.progetti;
	}
	
	public int addProgetto(Progetto progetto) {
		//TODO: ID UNICO
		String id = String.valueOf(111);
		this.progetti.put(id, progetto);
		return 111;
	}
	
	
	public Utente getUtente(String username) {
		return this.beatlinkUtenti.get(username);
	}
	
	public  Map<String, Utente> getAllUtenti() {
		return this.beatlinkUtenti;
	}
	
	public void addUtente(Utente utente) {
		this.beatlinkUtenti.put(utente.getUsername(), utente);
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
