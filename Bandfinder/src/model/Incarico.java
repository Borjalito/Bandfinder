package model;

import java.util.ArrayList;
import java.util.List;

public class Incarico {
	String nome;
	String descrizione;
	List<Proposta> proposte;
	
	public Incarico(String nome, String descrizione) {
		this.nome = nome;
		this.descrizione = descrizione;
		this.proposte =  new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public List<Proposta> getProposte() {
		return proposte;
	}
	public void setProposte(List<Proposta> proposte) {
		this.proposte = proposte;
	}
	
}
