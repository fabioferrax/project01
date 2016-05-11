package it.uniroma3.controller;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/addTuto")
public class AddTuto {
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("users-unit");
		TutoDAO tutoDao = new TutoDAO(emf);		
		
		//Ricevo l'utente dalla sessione
		HttpSession session = request.getSession();
		Utente utente = session.getAttribute("Utente");
		//Ricevo i parametri per l'inserimento di un nuovo Tuto		 
		Categoria categoria = request.getParameter("");
		String text = request.getParameter("");
		Tuto tuto = new Tuto(,,);
		
		//Salvo il tutto nel Db
		tutoDao.save(tuto);
		
		//Invio su showTuto.jsp il riepilogo del tuto
		request.setAttribute("Tuto",tuto);
		String nextPage = "/showTuto.jsp";
		
		
		
		ServletContext application = getServletContext();		
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);		
		rd.forward(request,response);
	}
}
