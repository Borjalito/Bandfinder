package test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.Commento;
import model.Licenza;
import model.Profilo;
import model.Progetto;
import model.Tag;
import model.Utente;



public class TestProgettoAnalisi {

	private Progetto progetto;
	private File immagine;
	private Utente creatore;
			
	
	
	@Before
	public void SetUp() {
		progetto = new Progetto("NomeProgetto", "Descrizione del progetto", 80, immagine, creatore, Licenza.BY_NC);
		immagine = new File("NomeProgetto.png");
		creatore = new Utente("Pippo", new Profilo("profilo di Pippo", new File("pippo.png")));
	}
	
	@Test
	public void TestGetterProgetto() {
		assertEquals(progetto.getTitolo(), "NomeProgetto");
		assertEquals(progetto.getDescrizione(), "Descrizione del progetto");
		assertEquals(progetto.getBpm(), 80);
		assertEquals(progetto.getImmagine(), immagine);
		assertEquals(progetto.getCreatore(), creatore);
		assertEquals(progetto.getLicenza(), Licenza.BY_NC);
		
	}
	
	public void TestSetterProgetto() {
		File immagineModificata = new File("altraImmagine.png");
		List<Tag> tags = new ArrayList<>();
		tags.add(new Tag("sognante"));
		tags.add(new Tag("archi"));
		
		progetto.setDescrizione("NomeProgettoModificato");
		progetto.setBpm(70);
		progetto.setImmagine(immagineModificata);
		progetto.aggiungiTag("sognante");
		progetto.aggiungiTag("archi");
	
		assertEquals(progetto.getDescrizione(), "Descrizione del progetto");
		assertEquals(progetto.getBpm(), 70);
		assertEquals(progetto.getImmagine(), immagineModificata);
		assertEquals(progetto.getTags(), tags);

	}
	
	@Test
	public void TestMiPiaceECommento() {
		Utente paperone = new Utente("paperone", new Profilo("io sono paperone", new File("paperone.png")));
		progetto.miPiace(paperone);
		
		assertEquals(progetto.getNumeroMiPiace(), 1);
		assertEquals(progetto.getUtentiACuiPiace().get(0), paperone);
		
		progetto.miPiace(paperone);
		assertEquals(progetto.getNumeroMiPiace(), 0);
		
		Commento commento = new Commento("il mio primo commento!", paperone);
		progetto.aggiungiCommento("il mio primo commento!", paperone);
		assertEquals(progetto.getCommenti().get(0), commento);
		
	}

}
