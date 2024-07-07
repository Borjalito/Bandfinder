package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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

@WebServlet("/upload")
@MultipartConfig
public class CreaProgetto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Database database;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		String titolo = request.getParameter("titolo");
		String descrizione = request.getParameter("descrizione");
		String licenza = request.getParameter("licenza");
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
		try {
			part = request.getPart("immagine");
		
			String fileName = getFileName(part);
			File file = new File(uploadDir, fileName);

			// Salva il file
        	InputStream input = part.getInputStream();
            Files.copy(input, file.toPath());
		} catch (IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		//Progetto progetto = new Progetto(titolo, descrizione, licenza, bpm..bpm.);
		
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
