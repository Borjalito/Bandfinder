package test;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import model.Profilo;
import model.Utente;



public class TestUtente {

	private Utente utente;
	private Profilo profilo;
	
	@Before
	public void SetUp() {
		File profileImage = new File("pippo.png");
		profilo = new Profilo("appassionato di musica", profileImage);
		utente = new Utente("pippo", profilo);
	}
	
	@Test
	public void TestGetterUtente() {
		assertEquals(utente.getUsername(), "pippo");
		assertEquals(utente.getProfile().getDescription(), "appassionato di musica");
		assertEquals(utente.getProfile().getImage(), new File("pippo.png"));
	}
	
	public void TestSetterUtente() {
		File topolinoProfileImage = new File("topolino.png");
		
		utente.setUsername("topolino");
		utente.getProfile().setDescription("mega appassionato di musica");
		utente.getProfile().setImage(topolinoProfileImage);
		
		assertEquals(utente.getUsername(), "topolino");	
		assertEquals(utente.getProfile().getDescription(), "mega appassionato di musica");
		assertEquals(utente.getProfile().getImage().getAbsolutePath(),topolinoProfileImage.getAbsolutePath());
	}
	

}
