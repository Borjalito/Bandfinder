package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Database;
import beans.User;

public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Database database;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		String username = request.getParameter("userName");
		String password = request.getParameter("password");
		RequestDispatcher dispatcher;
		if(database.getUser(username)!=null){
			dispatcher = getServletContext().getRequestDispatcher("/pages/alreadyRegistered.jsp");
		} else {
			database.addUser(new User(username, password));
			dispatcher = getServletContext().getRequestDispatcher("/pages/succesfulRegistration.jsp");
		}
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		
	}
	
	public void init() {
		//database è inizializzato nella index.jsp
		database = (Database)getServletContext().getAttribute("database");
	}
}
