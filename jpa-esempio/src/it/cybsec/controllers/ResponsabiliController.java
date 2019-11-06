package it.cybsec.controllers;

import java.io.IOException;
import java.util.*;

import javax.persistence.criteria.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import it.cybsec.daos.DipendenteDao;
import it.cybsec.models.Dipendente;

/**
 * Servlet implementation class DipendentiController
 */
@WebServlet(urlPatterns = { "/responsabili" })
public class ResponsabiliController extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
    private final DipendenteDao dao;
    
    public ResponsabiliController() {
        super();
        dao = new DipendenteDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CriteriaBuilder cb = dao.getCriteriaBuilder();
		CriteriaQuery<Dipendente> query = cb.createQuery(Dipendente.class);
		Root<Dipendente> dipendenti = query.from(Dipendente.class);
		query.select(dipendenti.get("responsabile")).distinct(true).where(cb.isNotNull(dipendenti.get("responsabile")));		
		List<Dipendente> responsabili = dao.recupera(query);
		request.setAttribute("responsabili", responsabili);
		request.getServletContext().getRequestDispatcher("/responsabili.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
