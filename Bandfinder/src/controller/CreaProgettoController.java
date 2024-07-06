package controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import model.DatabaseMock;
import model.Incarico;
import model.Licenza;
import model.Profilo;
import model.Progetto;
import model.Tag;
import model.Traccia;
import model.Utente;

public class CreaProgettoController {
	
	private DatabaseMock db = new DatabaseMock();
	
	public CreaProgettoController() {
		
	}
	
	public Progetto creaProgetto(String titolo, String descrizione, Licenza licenza,int bpm ,File immagine, 
			List<String> tags, List<String> nomeIncarichi ,List<String> descrizioneIncarichi,
			List<File> audioTracce, List<String> nomiTracce) {
		
		Utente creatore = new Utente("Tyler", new Profilo("The creator", new File("tyler.png")));
		Progetto progetto = new Progetto(titolo, descrizione, bpm, immagine, creatore, licenza);
		
		List<Tag> tagsList = new ArrayList<>();
		List<Incarico> incarichi = new ArrayList<>();
		List<Traccia> tracce = new ArrayList<>();
		
		for(int i=0; i<tags.size(); i++) {
			tagsList.add(new Tag(tags.get(i)));
		}
		
		for(int i=0; i<nomeIncarichi.size(); i++) {
			incarichi.add(new Incarico(nomeIncarichi.get(i), descrizioneIncarichi.get(i)));
		}
		
		for(int i=0; i<nomiTracce.size(); i++) {
			tracce.add(new Traccia(nomiTracce.get(i), audioTracce.get(i), creatore));
		}

		progetto.setTags(tagsList);
		progetto.setIncarichi(incarichi);
		progetto.setTracce(tracce);
		
		int idProgetto = db.insertProgetto(progetto);
		
		return progetto;
	}
	
	public DatabaseMock getDatabase() {
		return db;
	}

}
