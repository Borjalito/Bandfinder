package model;

import java.util.ArrayList;
import java.util.List;

public class Proposta {
	private List<Traccia> tracceProposte;
	
	public Proposta() {
		this.tracceProposte= new ArrayList<>();
	}
	
	public List<Traccia> getTracceProposte(){
		return tracceProposte;
	}
	
}