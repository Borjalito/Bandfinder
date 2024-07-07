package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.*;

public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Database database;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		User u = (User) request.getSession().getAttribute("user");
		//se avessi lo username potrei prendere user dal database
		//per costruzione sono comunque sicuro che l'attributo user non sia nullo perché lo imposto dal login
		u.setLogged(false);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/login.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		
	}
	
	public void init() {
		 database = (Database)getServletContext().getAttribute("database");
	}
}
