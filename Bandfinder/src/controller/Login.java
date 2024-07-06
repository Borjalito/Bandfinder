package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.*;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Database database;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		String username = request.getParameter("userName");
		String password = request.getParameter("password");
		User u = database.getUser(username);
		if(u==null) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/userDoesNotExist.jsp");
			try {
				dispatcher.forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
			
		} 
		if(u!=null) {
			//con questo if evito null pointer a runtime (che teoricamente non dovrebbe dare comunque problemi)
			if(!u.getLogged()) {
				if(database.userAndPasswordCheck(username, password)) {
					u.setLogged(true);
					request.getSession().setAttribute("user", u);
				} else {
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
					try {
						dispatcher.forward(request, response);
					} catch (ServletException | IOException e) {
						e.printStackTrace();
					}
				}
			}
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/loggedSection.jsp");
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
