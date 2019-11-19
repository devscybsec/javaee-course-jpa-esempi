package it.cybsec.controllers;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

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
@WebServlet(urlPatterns = { "/studente/corsi" })
public class StudenteCorsiController extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
    private final StudenteDao dao;
    private final CorsoDao daoCorso;
    
    public StudenteCorsiController() {
        super();
        dao = new StudenteDao();
        daoCorso = new CorsoDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id != "" && id != null) {
			List<Corso> corsiAttribute = null;
			Studente studente = dao.recupera(Integer.parseInt(id));
			
			request.setAttribute("studente", studente);
						
			if (studente.getCorsi().isEmpty()) {
				corsiAttribute = daoCorso.recupera();
			} else {
				CriteriaBuilder cb = dao.getCriteriaBuilder();
				CriteriaQuery<Corso> query = cb.createQuery(Corso.class);
				Root<Corso> corsi = query.from(Corso.class);
				query.select(corsi).where(cb.not(corsi.in(studente.getCorsi())));
				corsiAttribute = daoCorso.recupera(query);
			}
			request.setAttribute("corsi", corsiAttribute);
			request.getServletContext().getRequestDispatcher("/studenteCorsi.jsp").forward(request, response);
		} else {
			request.setAttribute("errore", "L'id dello studente non può essere vuoto!");
			request.getServletContext().getRequestDispatcher("/errore.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			Studente studente = dao.recupera(Integer.parseInt(id));
			List<Corso> corsiStudente = studente.getCorsi();
			
			if (corsiStudente == null)
				corsiStudente = new LinkedList<Corso>();			
			corsiStudente.add(daoCorso.recupera(Integer.parseInt(request.getParameter("corso"))));
//			studente.setCorsi(corsiStudente);
			
			dao.salva(studente);
			
			response.sendRedirect("../studente/corsi?id=" + id);
		} catch(Exception e) {
		}
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Studente studente = dao.recupera(Integer.parseInt(request.getParameter("id")));
			Corso corsoDaRimuovere = daoCorso.recupera(Integer.parseInt(request.getParameter("corso")));
			List<Corso> corsiStudente = studente.getCorsi();
			
			if (corsiStudente == null || corsiStudente.isEmpty())
				throw new Exception("Nessun corso per lo studente!");
			
			Iterator<Corso> it = corsiStudente.iterator();
			Corso corso;
			while (it.hasNext()) {
				corso = it.next();
				if (corso.getId() == corsoDaRimuovere.getId())
					corsiStudente.remove(corso);
			}
			
			studente.setCorsi(corsiStudente);
			dao.salva(studente);
		} catch(Exception e) {
		}
	}

}
