package model;

import java.util.ArrayList;
import java.util.List;

public class DatabaseMock {
	
	private List<Progetto> progetti = new ArrayList<>();
	
	public DatabaseMock() {
		progetti = new ArrayList<>();
	}
	
	public int insertProgetto(Progetto progetto) {
		progetti.add(progetto);
		return progetti.size()-1;
	}
	
	public Progetto pullProgetto(int id) {
		return progetti.get(id);
	}
}
 