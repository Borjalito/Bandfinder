package model;

public class Utente {
	 
	private String username;
	private Profilo profilo;
	
	public Utente(String username, Profilo profilo) {
			super();
			this.username = username;
			this.profilo = profilo;
	}
	 
	public String getUsername() {
		return username;
	}
	public Profilo getProfile() {
		return profilo;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setProfilo(Profilo profilo) {
		this.profilo = profilo;
	}
	 
	 
}
