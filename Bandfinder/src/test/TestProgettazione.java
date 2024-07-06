package test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import controller.CreaProgettoController;
import model.DatabaseMock;
import model.Licenza;
import model.Progetto;



public class TestProgettazione {

	private CreaProgettoController creaProgettoController;
	
	@Before
	public void SetUp() {
		creaProgettoController = new CreaProgettoController();
	}
		
	@Test
	public void TestCreaProgetto() {
		String titolo = "MioProgetto";
		String descrizione = "Un progetto collaborativo";
		Licenza licenza = Licenza.BY_NC_ND;
		int bpm = 80;
		File immagine = new File("MioProgetto.png");
		List<String> tags = new ArrayList<>();
		tags.add("rock");
		tags.add("pop");
		List<String> nomeIncarichi = new ArrayList<>();
		nomeIncarichi.add("incarico1");
		List<String> descrizioneIncarichi = new ArrayList<>();
		descrizioneIncarichi.add("descrizioneIncarico1");
		List<File> audioTracce = new ArrayList<>();
		audioTracce.add(new File("tracciaIniziale.mp3"));
		List<String> nomiTracce = new ArrayList<>();
		nomiTracce.add("Traccia Iniziale");
		
		creaProgettoController.creaProgetto(titolo, descrizione, licenza, bpm, immagine, tags,
				nomeIncarichi, descrizioneIncarichi, audioTracce, nomiTracce);
		
		//questo viene fatto nei test perché non esiste un vero DB ed è un metodo per condividere l'istanza
		DatabaseMock db = creaProgettoController.getDatabase();
		//indice 0 deriva dalla logica dei test. Nell'applicazione lo si deriva dal contesto
		int projectId = 0;
		Progetto progetto = db.pullProgetto(projectId);
			
		//parametri
		assertEquals(progetto.getTitolo(), titolo);
		assertEquals(progetto.getDescrizione(), descrizione);
		assertEquals(progetto.getLicenza(), licenza);
		assertEquals(progetto.getBpm(), bpm);
		assertEquals(progetto.getImmagine(), immagine);
		//tag
		assertEquals(progetto.getTags().get(0).getValore(), "rock");
		assertEquals(progetto.getTags().get(1).getValore(), "pop");
		//incarichi
		assertEquals(progetto.getIncarichi().get(0).getNome(), "incarico1");
		assertEquals(progetto.getIncarichi().get(0).getDescrizione(), "descrizioneIncarico1");
		//tracce iniziali
		assertEquals(progetto.getTracce().get(0).getNome(), "Traccia Iniziale");
		assertEquals(progetto.getTracce().get(0).getNome(), "tracciaIniziale.mp3");
		
	}


}
