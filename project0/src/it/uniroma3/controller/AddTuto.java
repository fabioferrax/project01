package it.uniroma3.controller;

import java.io.IOException;
import java.util.Date;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.uniroma3.dialog.Dialog;
import it.uniroma3.model.Categoria;
import it.uniroma3.model.Tuto;
import it.uniroma3.model.Utente;
import it.uniroma3.persistence.TutoDAO;

@WebServlet("/addTuto")
public class AddTuto extends HttpServlet {
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("users-unit");
		TutoDAO tutoDao = new TutoDAO(emf);		
		
		//Ricevo l'utente dalla sessione
		HttpSession session = request.getSession();
		Utente owner = (Utente) session.getAttribute("owner");
		//Ricevo i parametri per l'inserimento di un nuovo Tuto		 
		String text = request.getParameter("text");
		//Date creationtime = request.getParameter("creationtime");
		Tuto tuto = new Tuto(owner, text, new Date(System.currentTimeMillis()));
		
		//Salvo il tutto nel Db
		tutoDao.save(tuto);
		
		//Invio su showTuto.jsp il riepilogo del tuto
		request.setAttribute("Tuto",tuto);
		String nextPage = "/showTuto.jsp";		
		
		request.setAttribute("Dialog", new Dialog("Hai inserito il tuo tuto"));
		
		ServletContext application = getServletContext();		
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);		
		rd.forward(request,response);
	}
}
