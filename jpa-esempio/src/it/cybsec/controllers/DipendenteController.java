package it.cybsec.controllers;

import java.io.IOException;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import it.cybsec.daos.*;
import it.cybsec.models.*;

/**
 * Servlet implementation class DipendentiController
 */
@WebServlet(urlPatterns = { "/dipendente" })
public class DipendenteController extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
    private final DipendenteDao dao;
    private final UfficioDao daoUfficio; 
    private final RuoloDao daoRuolo; 
	
    public DipendenteController() {
        super();
        dao = new DipendenteDao();
        daoUfficio = new UfficioDao();
        daoRuolo = new RuoloDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dipendente dipendente = dao.recupera(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("ruoli", daoRuolo.recupera());
		request.setAttribute("uffici", daoUfficio.recupera());
		
		CriteriaBuilder cb = dao.getCriteriaBuilder();
		CriteriaQuery<Dipendente> query = cb.createQuery(Dipendente.class);
		Root<Dipendente> dipendenti = query.from(Dipendente.class);
		query.select(dipendenti).where(cb.notEqual(dipendenti.get("id"), dipendente.getId()));
		request.setAttribute("responsabili", dao.recupera(query));
		
		request.setAttribute("dipendente", dipendente);
		request.getServletContext().getRequestDispatcher("/dipendente.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Dipendente dipendente = dao.recupera(Integer.parseInt(request.getParameter("id")));
			dipendente.setRuolo(daoRuolo.recupera(Integer.parseInt(request.getParameter("ruolo"))));
			dipendente.setUfficio(daoUfficio.recupera(Integer.parseInt(request.getParameter("ufficio"))));
			Dipendente responsabile = null;
			if (request.getParameter("responsabile") != "")
				responsabile = dao.recupera(Integer.parseInt(request.getParameter("responsabile")));
			dipendente.setResponsabile(responsabile);
			dao.salva(dipendente);
			response.sendRedirect("./dipendenti");
		} catch(Exception e) {
		}
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			dao.elimina(dao.recupera(Integer.parseInt(request.getParameter("id"))));
		} catch(Exception e) {
		}
	}

}
