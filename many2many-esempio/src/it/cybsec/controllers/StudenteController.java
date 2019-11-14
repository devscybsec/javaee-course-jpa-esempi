package it.cybsec.controllers;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import it.cybsec.daos.*;
import it.cybsec.models.*;
import it.cybsec.utils.DateFormatter;

/**
 * Servlet implementation class DipendentiController
 */
@WebServlet(urlPatterns = { "/studente" })
public class StudenteController extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
    private final StudenteDao dao;
	
    public StudenteController() {
        super();
        dao = new StudenteDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id != "" && id != null) {
			Studente studente = dao.recupera(Integer.parseInt(id));
			
			request.setAttribute("studente", studente);
			request.getServletContext().getRequestDispatcher("/studente.jsp").forward(request, response);
		} else {
			request.setAttribute("errore", "L'id dello studente non può essere vuoto!");
			request.getServletContext().getRequestDispatcher("/errore.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Studente studente = dao.recupera(Integer.parseInt(request.getParameter("id")));
			studente.setNome(request.getParameter("nome"));
			studente.setCognome(request.getParameter("cognome"));
			studente.setDataNascita(DateFormatter.parse(request.getParameter("datanascita")));
			dao.salva(studente);
			response.sendRedirect("./studenti");
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
