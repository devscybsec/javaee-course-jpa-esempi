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
@WebServlet(urlPatterns = { "/corso" })
public class CorsoController extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
    private final CorsoDao dao;
    private final ProfessoreDao daoProfessore;
	
    public CorsoController() {
        super();
        dao = new CorsoDao();
        daoProfessore = new ProfessoreDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id != "" && id != null) {
			Corso corso = dao.recupera(Integer.parseInt(id));
	
			request.setAttribute("corso", corso);
			request.setAttribute("professori", daoProfessore.recupera());
			request.getServletContext().getRequestDispatcher("/corso.jsp").forward(request, response);
		} else {
			request.setAttribute("errore", "L'id del corso non può essere vuoto!");
			request.getServletContext().getRequestDispatcher("/errore.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Corso corso = dao.recupera(Integer.parseInt(request.getParameter("id")));
			corso.setNome(request.getParameter("nome"));
			corso.setDescrizione(request.getParameter("descrizione"));
			corso.setProfessore(daoProfessore.recupera(Integer.parseInt(request.getParameter("professore"))));
			dao.salva(corso);
			response.sendRedirect("./corsi");
		} catch(Exception e) {
			request.setAttribute("errore", e.toString());
			request.getServletContext().getRequestDispatcher("/errore.jsp").forward(request, response);
		}
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			dao.elimina(dao.recupera(Integer.parseInt(request.getParameter("id"))));
		} catch(Exception e) {
		}
	}

}
