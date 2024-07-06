package test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.Chat;
import model.Profilo;
import model.Utente;



public class TestUtenteAnalisi {

	private Utente attore;
	private Profilo profiloAttore;
	private List<Chat> listaChatAttore;
	private List<Utente> seguitiAttore;
	private List<Utente> seguaciAttore;
	
	private Utente pluto;
	private Utente paperino;
	private Utente gastone;
	private Utente archimede;
	
	@Before
	public void SetUp() {
		//profilo
		listaChatAttore = new ArrayList<Chat>();
		seguitiAttore = new ArrayList<Utente>();
		seguaciAttore = new ArrayList<Utente>();
		profiloAttore = new Profilo("appassionato di musica", new File("attore.png"));
		attore = new Utente("attore", profiloAttore);
		
	}
	
	@Test
	public void TestSeguiUtente() {
		//seguiti
		Profilo profiloPluto = new Profilo("mi chiamo pluto", new File("pluto.png"));
		Profilo profiloPaperino = new Profilo("mi chiamo paperino", new File("paperino.png"));
		pluto = new Utente("pluto", profiloPluto);
		paperino = new Utente("paperino", profiloPaperino);	
		//seguaci
		Profilo profiloGastone = new Profilo("mi chiamo gastone", new File("gastone.png"));
		Profilo profiloArchimede = new Profilo("mi chiamo archimede", new File("archimede.png"));
		gastone = new Utente("gastone", profiloGastone);
		archimede = new Utente("archimede", profiloArchimede);
		//segui
		attore.seguiUtente(pluto);
		attore.seguiUtente(paperino);
		gastone.seguiUtente(attore);
		archimede.seguiUtente(attore);
		//riempio le liste per confrontare che siano uguali a quelle attese in Utente attore
		seguitiAttore.add(pluto);
		seguitiAttore.add(paperino);
		seguaciAttore.add(gastone);
		seguaciAttore.add(archimede);
		//test
		assertEquals(attore.getUsername(), "attore");
		assertEquals(attore.getProfilo(), profiloAttore);
		assertEquals(attore.getSeguiti(), seguitiAttore);
		assertEquals(attore.getSeguaci(), seguaciAttore);
	}
	
	@Test
	public void TestGetterUtente() {
		assertEquals(attore.getProfilo(), profiloAttore);
		assertEquals(attore.getUsername(), "attore");
	}

	@Test
	public void TestSetterUtente() {
		Profilo aggiornamentoProfilo = new Profilo("appassionatissimo di musica", new File("attore2.png"));
		
		attore.setUsername("attore2");
		attore.setProfilo(aggiornamentoProfilo);
		
		listaChatAttore=attore.getChat();
		Chat chatConPluto = new Chat(attore, pluto);
		listaChatAttore.add(chatConPluto);
		attore.setChat(listaChatAttore);
		
		assertEquals(attore.getUsername(), "attore2");	
		assertEquals(attore.getProfilo(), aggiornamentoProfilo);
		assertEquals(attore.getChat(), listaChatAttore);
		
	}
	

}
