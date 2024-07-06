package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.*;

public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Database database;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		String username = request.getParameter("userName");
		String password = request.getParameter("password");
		User u = database.getUser(username);
		if(u==null || !username.contains("admin")) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/userDoesNotExist.jsp");
			try {
				dispatcher.forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}			
		}
		if(u!=null) {
			RequestDispatcher dispatcher;
			if(database.userAndPasswordCheck(username, password)) {
				u.setLogged(true); //non ho una vera e propria gestione di un admin loggato, ma lascio per completezza
				 dispatcher = getServletContext().getRequestDispatcher("/pages/adminSection.jsp");
			} else {
				 dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
			}
			try {
				dispatcher.forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		
	}
	
	public void init() {
		 //instanziato come bean in index.jsp
		 database = (Database)getServletContext().getAttribute("database");
	}
}
