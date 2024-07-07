package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Database;
import beans.User;
import model.Profilo;
import model.Utente;

public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Database database;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		String username = request.getParameter("userName");
		String password = request.getParameter("password");
		//String url = request.getRequestURL().toString(); 
	    //String baseURL = url.substring(0, url.length() - request.getRequestURI().length()) + request.getContextPath() + "/"; 
		
		RequestDispatcher dispatcher;
		if(database.getUser(username)!=null){
			dispatcher = getServletContext().getRequestDispatcher("/pages/alreadyRegistered.jsp");
		} else {
			database.addUser(new User(username, password));
			database.addUtente(new Utente(username, new Profilo()));
			dispatcher = getServletContext().getRequestDispatcher("/pages/login.jsp");
		}
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void init() {
		database = (Database)getServletContext().getAttribute("database");
	}
}
