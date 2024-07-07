package controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import beans.*;
import model.Licenza;
import model.Progetto;
import model.Utente;

@WebServlet("/upload")
@MultipartConfig
public class CreaProgetto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Database database;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		String titolo = request.getParameter("titolo");
		String descrizione = request.getParameter("descrizione");
		Licenza licenza = Licenza.valueOf(request.getParameter("licenza"));
		int bpm = Integer.parseInt(request.getParameter("bpm"));
		
		//estrazione e salvataggio immagine
		String relativePath = "img"; // Nome della directory
        String absolutePath = getServletContext().getRealPath(relativePath);
        File uploadDir = new File(absolutePath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        
        // Ottieni il file caricato
        Part part;
        File immagine = null;
		try {
			part = request.getPart("immagine");
		
			String fileName = getFileName(part);
			immagine = new File(uploadDir, fileName);

			// Salva il file
        	InputStream input = part.getInputStream();
            Files.copy(input, immagine.toPath());
		} catch (IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		String username = ((Utente)(request.getSession().getAttribute("user"))).getUsername() ;
		Progetto progetto = new Progetto(titolo, descrizione, bpm, immagine, database.getUtente(username) ,licenza);
		database.addProgetto(progetto);
		//TODO: addProgetto restituisce l'intero che mi serve per recuperare la info dal db
		//devo salvare tale attributo da qualche parte e sapere a cosa è associato
		//potrei creare una lista/mappa di progetti e salvare come attributo servletContext
		
		//TODO: test funzionamento immagine dopo creazione progetto 
		//io salvo Progetto nel db creando con File. Quando lo visualizzo va tutto liscio?
		
		try {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/homeUtente.jsp");
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	private String getFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        String[] elements = contentDisposition.split(";");
        for (String element : elements) {
            if (element.trim().startsWith("filename")) {
                return element.substring(element.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
	
	public void init() {
		 database = (Database)getServletContext().getAttribute("database");
	}
}
