package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.*;

public class ValutaProposta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Database database;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		
	}
	
	
	public void init() {
		 //instanziato come bean in index.jsp
		 database = (Database)getServletContext().getAttribute("database");
	}
}
