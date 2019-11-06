package it.cybsec.controllers;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import it.cybsec.daos.*;
import it.cybsec.models.*;

/**
 * Servlet implementation class DipendentiController
 */
@WebServlet(urlPatterns = { "/dipendenti" })
public class DipendentiController extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
    private final DipendenteDao dao;
    private final UfficioDao daoUfficio; 
    private final RuoloDao daoRuolo; 
	
    public DipendentiController() {
        super();
        dao = new DipendenteDao();
        daoUfficio = new UfficioDao();
        daoRuolo = new RuoloDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("dipendenti", dao.recupera());
		request.setAttribute("ruoli", daoRuolo.recupera());
		request.setAttribute("uffici", daoUfficio.recupera());		
		request.setAttribute("responsabili", dao.recupera());
		request.getServletContext().getRequestDispatcher("/dipendenti.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Ruolo ruolo = daoRuolo.recupera(Integer.parseInt(request.getParameter("ruolo")));
			Ufficio ufficio = daoUfficio.recupera(Integer.parseInt(request.getParameter("ufficio")));
			Dipendente responsabile = null;
			if (request.getParameter("responsabile") != "")
				responsabile = dao.recupera(Integer.parseInt(request.getParameter("responsabile")));
			dao.nuovo(new Dipendente(responsabile, ruolo, ufficio, request.getParameter("nome"),request.getParameter("cognome"), null));
			response.sendRedirect("./dipendenti");
		} catch(Exception e) {
		}
	}

}
